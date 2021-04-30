package Controllers;

import Database.*;
import Entities.Expediente;
import Entities.OrganizacionVinculada;
import Entities.Proyecto;
import Entities.ResponsableProyecto;
import Enumerations.EstadoProyecto;
import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import sample.LoginSession;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProjectDetailsController implements Initializable {
    private ScreenChanger screenChanger = new ScreenChanger();
    private ExpedienteDAO expedientes = new ExpedienteDAO();
    private ProyectoDAO proyectos = new ProyectoDAO();
    private OrganizacionVinculadaDAO organizaciones = new OrganizacionVinculadaDAO();
    private ResponsableProyectoDAO responsables = new ResponsableProyectoDAO();
    private ResponsablesOrganizacionDAO responsablesOrganizacion = new ResponsablesOrganizacionDAO();
    private ProyectosDeResponsablesDAO responsablesProyectos = new ProyectosDeResponsablesDAO();
    private Proyecto proyecto;
    private OrganizacionVinculada organizacion;
    private ResponsableProyecto responsable;

    @FXML
    private Text nameText;

    @FXML
    private Text lastNameText;

    @FXML
    private Text matriculaText;

    @FXML
    private Text projectText;

    @FXML
    private Button returnButton;

    @FXML
    private Text errorText;

    @FXML
    private Text studentName1;

    @FXML
    private Text studentName2;

    @FXML
    private Text studentName3;

    @FXML
    private Text studentName4;

    @FXML
    private Text projectNameText;

    @FXML
    private Text cupoText;

    @FXML
    private Text organizacionText;

    @FXML
    private Text direccionText;

    @FXML
    private Text responsableText;

    @FXML
    private Text correoText;

    @FXML
    private Text telefonoText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SetUserInformation();
        SetProjectTexts();
    }

    private void SetUserInformation() {
        nameText.setText( LoginSession.GetInstance().GetEstudiante().getNombres() );
        lastNameText.setText( LoginSession.GetInstance().GetEstudiante().GetApellidos() );
        matriculaText.setText( LoginSession.GetInstance().GetEstudiante().GetMatricula() );
    }

    @FXML
    void Return( MouseEvent mouseEvent ) {
        screenChanger.ShowStudentMainMenuScreen( mouseEvent, errorText );
    }

    private void SetProjectTexts() {
        proyecto = proyectos.Read( GetUserExpediente().GetIDProyecto() );
        projectNameText.setText( proyecto.getNombre() );
        projectText.setText( proyecto.GetDescripcion() );
        cupoText.setText( Integer.toString( proyecto.getNumEstudiantesRequeridos() ) );
    }

    private void SetResponsableTexts() {
        //responsable = responsables.Read( responsablesProyectos.Read() );
    }

    private void GetResponsable() {
        int idResponsable;
    }

    private Expediente GetUserExpediente() {
        List< Expediente > expedienteList = expedientes.ReadAll();
        Expediente userExpediente = null;
        for( Expediente expediente : expedienteList ) {
            if( expediente.GetMatricula().equals( LoginSession.GetInstance().GetEstudiante().GetMatricula() ) &&
                    proyectos.Read( expediente.GetIDProyecto() ).GetEstado() == EstadoProyecto.Asignado ) {
                userExpediente = expediente;
            }
        }
        return userExpediente;
    }
}