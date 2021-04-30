package Controllers;

import Database.EstudianteDAO;
import Entities.Estudiante;
import Utilities.OutputMessages;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import sample.LoginSession;
import java.net.URL;
import java.util.ResourceBundle;

public class GestionarEstudiantes_Coordinador implements Initializable {
    private EstudianteDAO estudiantes = new EstudianteDAO();
    private OutputMessages outputMessages = new OutputMessages();

    @FXML
    private Text nameText;

    @FXML
    private Text lastNameText;

    @FXML
    private Text numeroTrabajadorText;

    @FXML
    private Text projectText;

    @FXML
    private Button chooseProjectButton;

    @FXML
    private Button returnButton;

    @FXML
    private Text errorText;

    @FXML
    private TableView< Estudiante > estudiantesTable;

    @FXML
    private TableColumn< Estudiante, String > nameColumn;

    @FXML
    private TableColumn< Estudiante, String > matriculaColumn;

    @FXML
    private Button consultarBoton;

    @FXML
    private Button modificarBoton;

    @FXML
    private Button eliminarBoton;

    @FXML
    private Button buscarBoton;

    @Override
    public void initialize( URL url, ResourceBundle resourceBundle ) {
        SetUserInformation();
        SetCellValueFactory();
        ShowStudents();
    }

    private void SetUserInformation() {
        nameText.setText( LoginSession.GetInstance().GetCoordinador().getNombres() );
        lastNameText.setText( LoginSession.GetInstance().GetCoordinador().GetApellidos() );
        numeroTrabajadorText.setText( LoginSession.GetInstance().GetCoordinador().GetNumeroPersonal() );
    }

    private void SetCellValueFactory() {
        nameColumn.setCellValueFactory( new PropertyValueFactory<>( "nombres" ) );
        matriculaColumn.setCellValueFactory( new PropertyValueFactory<>( "matricula" ) );
    }

    private void ShowStudents() {
        estudiantesTable.getItems().clear();
        for( Estudiante estudiante : estudiantes.ReadAll() ) {
            estudiantesTable.getItems().add( estudiante );
        }
    }

    @FXML
    void EliminarEstudiante( MouseEvent event ) {
        if( IsStudentSelected() ) {
            Alert deleteAlert = new Alert( Alert.AlertType.CONFIRMATION, outputMessages.DeleteDocumentConfirmation() );
            deleteAlert.showAndWait().ifPresent( response -> {
                if( response == ButtonType.OK ) {
                    estudiantes.Delete( estudiantesTable.getSelectionModel().getSelectedItem().getMatricula() );
                    ShowStudents();
                }
            } );
        }
    }

    @FXML
    void Return( MouseEvent event ) {

    }

    @FXML
    void ShowGestionarReportes( MouseEvent event ) {

    }

    private boolean IsStudentSelected() {
        boolean isSelected = false;
        if( estudiantesTable.getSelectionModel().getSelectedItem() != null ) {
            isSelected = true;
        }
        return isSelected;
    }
}