package Controllers;

import Database.OrganizacionVinculadaDAO;
import Database.ResponsableProyectoDAO;
import Entities.ResponsableProyecto;
import Enumerations.TipoSector;
import Entities.OrganizacionVinculada;
import Utilities.InputValidator;
import Utilities.OutputMessages;
import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import Utilities.LoginSession;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegistrarOrganizacion_Coordinador implements Initializable {
    private OrganizacionVinculadaDAO organizacionVinculada = new OrganizacionVinculadaDAO();
    private OutputMessages outputMessages = new OutputMessages();
    private ScreenChanger screenChanger = new ScreenChanger();
    private InputValidator inputValidator = new InputValidator();
    private List< ResponsableProyecto > listaResponsables = new ArrayList<>();
    private ResponsableProyectoDAO responsable = new ResponsableProyectoDAO();

    @FXML
    private Label lbNombres;

    @FXML
    private Label lbApellidos;

    @FXML
    private Label lbNoTrabajador;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfDireccion;

    @FXML
    private TextField tfCorreoElectronico;

    @FXML
    private TextField tfTelefono;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Text errorText;

    @FXML
    private Text successText;

    @FXML
    private TableView <ResponsableProyectoDAO> tbResponsable;

    @FXML
    private TableColumn <ResponsableProyectoDAO, String> clnResponsable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        VerificarDatos();
        RegistrarOrganizacion();
        ValorColumnasProyecto();
        MostrarResponsablesDisponibles();
        DatosDeUsuario();
    }

    public void ValorColumnasProyecto() {
        clnResponsable.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    }

    public void MostrarResponsablesDisponibles(){
        listaResponsables = responsable.ReadAll();
        for( ResponsableProyecto responsableProyecto : listaResponsables){
            responsableProyecto.GetNombres();
            tbResponsable.getItems().add( responsable );
        }
    }

    /**
     * Crea una instancia de Organizacion Vinculada utilizando la información
     * introducida por el usuario en todos los campos de texto.
     * @return una instancia de OrganizacionVinculada
     */
   private OrganizacionVinculada ObtenerOrganizacionVinculada() {
        return new OrganizacionVinculada ( tfNombre.getText(), tfDireccion.getText(), TipoSector.Publico,
                tfTelefono.getText(),tfCorreoElectronico.getText(),0,null);
    }

    /**
     * Cambia la pantalla de RegistrarOrganizacion_Coordinador a GestionarOrganizacion_Coordinador.
     * @param mouseEvent el evento de mouse que activo la acción.
     */
    public void ClicRegresar ( MouseEvent mouseEvent ){
        screenChanger.MostrarPantallaGestionarOrganizacion( mouseEvent, errorText );
    }

    /**
     * Intenta crear una Organización en la base de datos y coloca
     * el mensaje correspondiente en caso de éxito o fracaso.
     */
    private void RegistrarOrganizacion() {
        if( organizacionVinculada.Create ( ObtenerOrganizacionVinculada() ) ) {
            errorText.setText( "" );
            successText.setText( outputMessages.RegistroOrganizacionExitoso() );
        }
        else {
            errorText.setText( outputMessages.DatabaseConnectionFailed() );
            successText.setText( "" );
        }
    }


    /**
     * Verifica que la información introducida por el usuario
     * sea valida.
     */
    private void VerificarDatos() {
        NombreValido();
        DireccionValida();
        CorreoValido();
    }

    /**
     * Revisa que el nombre introducido sea valido.
     */
    private void NombreValido() {
        if ( !inputValidator.AreNamesValid(tfNombre.getText() ) ) {
            errorText.setText(outputMessages.InvalidNames() );
            successText.setText( "" );
        }
    }

    /**
     * Revisa que la dirección introducida sea valida.
     */
    private void DireccionValida() {
        if ( !inputValidator.DireccionValida( tfDireccion.getText() ) ) {
            errorText.setText( outputMessages.DireccionInvalida() );
            successText.setText( "" );
        }
    }

    /**
     * Revisa que el correo eléctronico introducido sea valido.
     */
    private void CorreoValido() {
        if ( !inputValidator.IsEmailValid( tfCorreoElectronico.getText() ) ) {
            errorText.setText( outputMessages.InvalidEmail() );
            successText.setText( "" );
        }
    }

    /**
     * Coloca la información del usuario actual en los campos de texto de
     * nombres, apellidos y No.Trabajador
     */
    public void DatosDeUsuario(){
        lbNombres.setText( LoginSession.GetInstance().GetCoordinador().getNombres() );
        lbApellidos.setText( LoginSession.GetInstance().GetCoordinador().GetApellidos() );
        lbNoTrabajador.setText( LoginSession.GetInstance().GetCoordinador().GetNumeroPersonal() );
    }




}