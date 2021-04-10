/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 4 - abr - 2021
 * Descripción:
 * Clase encargada de manejar los eventos de la pantalla
 * Student Main Menu Screen.
 */
package Controllers;

import Enumerations.EstadoEstudiante;
import Utilities.OutputMessages;
import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import sample.LoginSession;
import java.net.URL;
import java.util.ResourceBundle;

public class EstudianteMainMenuController implements Initializable {
    private ScreenChanger screenChanger = new ScreenChanger();
    private OutputMessages outputMessages = new OutputMessages();

    @FXML
    private Text nameText;

    @FXML
    private Text lastNameText;

    @FXML
    private Text matriculaText;

    @FXML
    private Text projectText;

    @FXML
    private Text errorText;

    @FXML
    private Button reportButton;

    @FXML
    private Button DocumentsButton;

    @FXML
    private Button formButton;

    @FXML
    private Button projectButton;

    @FXML
    private Button chooseProjectButton;

    @FXML
    private Button logoutButton;

    @Override
    public void initialize( URL location, ResourceBundle resources ) {
        nameText.setText( LoginSession.GetInstance().GetEstudiante().GetNombres() );
        lastNameText.setText( LoginSession.GetInstance().GetEstudiante().GetApellidos() );
        matriculaText.setText( LoginSession.GetInstance().GetEstudiante().GetMatricula() );
    }

    public void ShowReports( MouseEvent mouseEvent ){
        if( DoesStudentHaveProjectAssigned() ) {
            screenChanger.ShowStudentReportsScreen(mouseEvent, errorText);
        } else {
            errorText.setText( outputMessages.ProjectNotAssigned() );
        }
    }

    public void ShowAdditionalDocuments() {

    }

    public void ShowFormats() {

    }

    public void ShowAssignedProject() {

    }

    public void ShowChooseProjects( MouseEvent mouseEvent ) {
        if( !HasStudentChosenProjects() ) {
            screenChanger.ShowChooseProjectsScreen( mouseEvent, errorText );
        } else {
            errorText.setText( outputMessages.AlreadyChoseProjects() );
        }
    }

    public void Logout( MouseEvent mouseEvent ) {
        LoginSession.GetInstance().Logout();
        screenChanger.ShowLoginScreen( mouseEvent, errorText );
    }

    private boolean HasStudentChosenProjects() {
        return LoginSession.GetInstance().GetEstudiante().GetEstado() == EstadoEstudiante.AsignacionPendiente ||
                LoginSession.GetInstance().GetEstudiante().GetEstado() == EstadoEstudiante.ProyectoAsignado ||
                LoginSession.GetInstance().GetEstudiante().GetEstado() == EstadoEstudiante.Evaluado;
    }

    private boolean DoesStudentHaveProjectAssigned() {
        return LoginSession.GetInstance().GetEstudiante().GetEstado() == EstadoEstudiante.ProyectoAsignado ||
                LoginSession.GetInstance().GetEstudiante().GetEstado() == EstadoEstudiante.Evaluado;
    }
}