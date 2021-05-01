package Controllers;

import Database.OrganizacionVinculadaDAO;
import Entities.OrganizacionVinculada;
import Utilities.OutputMessages;
import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import Utilities.LoginSession;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionarOrganizacion_Coordinador implements Initializable {
    private ScreenChanger screenChanger = new ScreenChanger();
    private OrganizacionVinculadaDAO organizacionVinculada = new OrganizacionVinculadaDAO();
    private OutputMessages outputMessages = new OutputMessages();

    @FXML
    private Label lbNombres;

    @FXML
    private Label lbApellidos;

    @FXML
    private Label lbNoTrabajador;

    @FXML
    private Button btnGestionarProyectos;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextField tfBuscar;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableView<OrganizacionVinculada> tbOrganizaciones;

    @FXML
    private TableColumn<OrganizacionVinculada, String> clnOrganizaciones;

    @FXML
    private Button btnConsultarOrganizacion;

    @FXML
    private Button btnRegistrarOrganizacion;

    @FXML
    private Button btnEliminarOrganizacion;

    @FXML
    private Button btnModificarOrganizacion;

    @FXML
    private Text errorText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatosDeUsuario();
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

    /**
     * Cambia la pantalla de GestionarOrganizacion_Coordinador a la pantalla Principal_Coordinador.
     * @param mouseEvent el evento de mouse que activo la acción.
     */
    public void ClicRegresar ( MouseEvent mouseEvent ){
        screenChanger.MostrarPantallaPrincipalCoordinador( mouseEvent, errorText );
    }

    /**
     * Cambia la pantalla de GestionarOrganizacion_Coordinador a la pantalla GestionarProyecto_Coordinador.
     * @param mouseEvent el evento de mouse que activo la acción.
     */
    public void ClicGestionarProyecto ( MouseEvent mouseEvent ){
        screenChanger.MostrarPantallaGestionarProyecto( mouseEvent, errorText );
    }

    /**
     * Cambia la pantalla de GestionarOrganizacion_Coordinador a la pantalla RegistrarOrganizacion_Coordinador.
     * @param mouseEvent el evento de mouse que activo la acción.
     */
    public void ClicRegistrar( MouseEvent mouseEvent ){
        screenChanger.MostrarPantallaRegistrarOrganizacion( mouseEvent, errorText );
    }

    /**
     * Recupera la selección de la tabla para Elimina una OrganizacionVinculada de la base de datos.
     * @param mouseEvent el evento de mouse que activo la acción.
     */
    public void ClicEliminarRegistro( MouseEvent mouseEvent){
        String fila = tbOrganizaciones.getSelectionModel().getSelectedItem().getNombre();
        ObtenerInformacion(fila);
        EliminarRegistro( fila );
    }

    public void ObtenerInformacion( String fila ){

    }

    public void EliminarRegistro( String fila ){
        System.out.println("¿Seguro que quieres eliminar la organización?");
        if( organizacionVinculada.Delete ( obtenerOrganizacionVinculada,null ) ) {
            errorText.setText( "" );
            successText.setText( outputMessages.RegistroOrganizacionExitoso() );
        }
        else {
            errorText.setText( outputMessages.DatabaseConnectionFailed() );
            successText.setText( "" );
        }
    }
}