package Controllers;

import Entities.Estudiante;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import sample.LoginSession;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionarEstudiantes_Coordinador implements Initializable {
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

    @FXML
    void EliminarEstudiante( MouseEvent event ) {

    }

    @FXML
    void Return( MouseEvent event ) {

    }

    @FXML
    void ShowGestionarReportes( MouseEvent event ) {

    }
}
