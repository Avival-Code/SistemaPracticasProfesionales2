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
    private ResponsableProyectoDAO responsableProyecto = new ResponsableProyectoDAO();

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
    private TextField tfNombresRepresentante;

    @FXML
    private TextField tfApellidosRepresentante;

    @FXML
    private TextField tfCorreoRepresentante;

    @FXML
    private TextField tfTelefonoRepresentante;

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
  //      AsignarValorColumnasResponsableProyecto();
  //      MostrarResponsablesDisponibles();
        DatosDeUsuario();
    }

    /**
     * Cambia la pantalla de RegistrarOrganizacion_Coordinador a GestionarOrganizacion_Coordinador.
     * @param mouseEvent el evento de mouse que activo la acci??n.
     */
    public void ClicRegresar ( MouseEvent mouseEvent ){
        screenChanger.MostrarPantallaGestionarOrganizacion( mouseEvent, errorText );
    }

    /**
     * Limpia los campos de datos de organizaci??n.
     * @param mouseEvent el evento de mouse que activo la acci??n.
     */
    public void ClicCancelar ( MouseEvent mouseEvent ){

        tfNombre.setText("");
        tfDireccion.setText("");
        tfCorreoElectronico.setText("");
        tfTelefono.setText("");
        tfNombresRepresentante.setText("");
        tfApellidosRepresentante.setText("");
        tfCorreoRepresentante.setText("");
        tfTelefonoRepresentante.setText("");
    }

    public void ManejoRegistroOrganizacion(){
        ManejoRegistroRepresentante();
        VerificarDatos();
        if( inputValidator.IsOrganizationInformationValid( ObtenerOrganizacionVinculada() ) ) {
            if ( !OrganizacionExistente() ) {
                RegistrarOrganizacion();
            }
        }
    }

    public List ObtenerListaResponsables(){
        listaResponsables = responsableProyecto.ReadAll();
        for( ResponsableProyecto responsableProyecto : listaResponsables) {
            responsableProyecto.getIdResponsableProyecto();
        }
        return listaResponsables;
    }

    /**
     * Crea una instancia de Organizacion Vinculada utilizando la informaci??n
     * introducida por el usuario en todos los campos de texto.
     * @return una instancia de OrganizacionVinculada
     */
   private OrganizacionVinculada ObtenerOrganizacionVinculada() {
        return new OrganizacionVinculada ( tfNombre.getText(), tfDireccion.getText(), TipoSector.Publico,
                tfTelefono.getText(),tfCorreoElectronico.getText(),0,ObtenerListaResponsables());

    }

    /**
     * Intenta crear una Organizaci??n en la base de datos y coloca
     * el mensaje correspondiente en caso de ??xito o fracaso.
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
     * Revisa si ya existe un Estudiante en la base de datos con
     * la misma informaci??n que fue introducida.
     * @return true si se encuentra una instancia con la misma informaci??n, false s?? no.
     */
    private boolean OrganizacionExistente() {
        boolean organizacionExistente = false;
        if( organizacionVinculada.Read( ObtenerOrganizacionVinculada().getIdOrganizacion() ) != null ) { //Cambiar el DAO el READ esta mal
            errorText.setText( outputMessages.OrganizacionExistente() );
            successText.setText( "" );
            organizacionExistente = true;
        }
        return organizacionExistente;
    }

    /**
     * Verifica que la informaci??n introducida por el usuario
     * sea valida.
     */
    private void VerificarDatos() {
        NombreValido();
        DireccionValida();
        CorreoValido();
        TelefonoValido();
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
     * Revisa que la direcci??n introducida sea valida.
     */
    private void DireccionValida() {
        if ( !inputValidator.DireccionValida( tfDireccion.getText() ) ) {
            errorText.setText( outputMessages.DireccionInvalida() );
            successText.setText( "" );
        }
    }

    /**
     * Revisa que el correo el??ctronico introducido sea valido.
     */
    private void CorreoValido() {
        if ( !inputValidator.IsEmailValid( tfCorreoElectronico.getText() ) ) {
            errorText.setText( outputMessages.InvalidEmail() );
            successText.setText( "" );
        }
    }

    /**
     * Revisa que el t??lefono introducido sea valido.
     */
    private void TelefonoValido() {
        if ( !inputValidator.IsTelephoneValid( tfTelefono.getText() ) ) {
            errorText.setText( outputMessages.InvalidTelephone() );
            successText.setText( "" );
        }
    }

    /**
     * Coloca la informaci??n del usuario actual en los campos de texto de
     * nombres, apellidos y No.Trabajador
     */
    public void DatosDeUsuario(){
        lbNombres.setText( LoginSession.GetInstance().GetCoordinador().getNombres() );
        lbApellidos.setText( LoginSession.GetInstance().GetCoordinador().GetApellidos() );
        lbNoTrabajador.setText( LoginSession.GetInstance().GetCoordinador().GetNumeroPersonal() );
    }

    /**
     * Crea una instancia de Organizacion Vinculada utilizando la informaci??n
     * introducida por el usuario en todos los campos de texto.
     * @return una instancia de OrganizacionVinculada
     */
    private ResponsableProyecto ObtenerResponsableProyecto() {
        return new ResponsableProyecto ( 0, tfNombresRepresentante.getText(), tfApellidosRepresentante.getText(),
                tfCorreoRepresentante.getText(), tfTelefonoRepresentante.getText(), null );
    }

    /**
     * Revisa si ya existe un Estudiante en la base de datos con
     * la misma informaci??n que fue introducida.
     * @return true si se encuentra una instancia con la misma informaci??n, false s?? no.
     */
    private boolean ResponsableExistente() {
        boolean responsableExistente = false;
        if( responsableProyecto.Read( ObtenerResponsableProyecto().getIdResponsableProyecto() ) != null ) { //Cambiar el DAO el READ esta mal
            errorText.setText( outputMessages.ResponsableExistente() );
            successText.setText( "" );
            responsableExistente = true;
        }
        return responsableExistente;
    }

    /**
     * Intenta crear un ResponsableProyecto en la base de datos y coloca
     * el mensaje correspondiente en caso de ??xito o fracaso.
     */
    private void RegistrarResponsableProyecto() {
        if( responsableProyecto.Create ( ObtenerResponsableProyecto() ) ) {
            errorText.setText( "" );
            successText.setText( outputMessages.RegistroResponsableExitoso() );
        }
        else {
            errorText.setText( outputMessages.DatabaseConnectionFailed() );
            successText.setText( "" );
        }
    }

    public void ManejoRegistroRepresentante(){
        VerificarDatosResponsable();
        if( inputValidator.IsResponsableInformationValid( ObtenerResponsableProyecto() ) ) {
            if ( !ResponsableExistente() ) {
                RegistrarResponsableProyecto();
            }
        }
    }

    private void VerificarDatosResponsable() {
        NombresResponsableValido();
        ApellidosResponsableValido();
        CorreoResponsableValido();
        TelefonoResponsableValido();
    }

    /**
     * Revisa que el nombre introducido sea valido.
     */
    private void NombresResponsableValido() {
        if ( !inputValidator.AreNamesValid(tfNombresRepresentante.getText() ) ) {
            errorText.setText(outputMessages.InvalidNames() );
            successText.setText( "" );
        }
    }

    /**
     * Revisa que la direcci??n introducida sea valida.
     */
    private void ApellidosResponsableValido() {
        if ( !inputValidator.DireccionValida( tfApellidosRepresentante.getText() ) ) {
            errorText.setText( outputMessages.DireccionInvalida() );
            successText.setText( "" );
        }
    }

    /**
     * Revisa que el correo el??ctronico introducido sea valido.
     */
    private void CorreoResponsableValido() {
        if ( !inputValidator.IsEmailValid( tfCorreoRepresentante.getText() ) ) {
            errorText.setText( outputMessages.InvalidEmail() );
            successText.setText( "" );
        }
    }

    /**
     * Revisa que el t??lefono introducido sea valido.
     */
    private void TelefonoResponsableValido() {
        if ( !inputValidator.IsTelephoneValid( tfTelefonoRepresentante.getText() ) ) {
            errorText.setText( outputMessages.InvalidTelephone() );
            successText.setText( "" );
        }
    }

}