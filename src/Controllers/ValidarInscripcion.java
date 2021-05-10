package Controllers;

import Entities.Estudiante;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ValidarInscripcion implements Initializable {
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbApellidos;
    @FXML
    private Label lbCedulaProfesional;
    @FXML
    private Text errorText;
    @FXML
    private Label lbPeriodo;
    @FXML
    private Label lbFecha;
    @FXML
    private TableView< Estudiante > tbvEstudiantes;
    @FXML
    private TableColumn< Estudiante, String > tcNombre;
    @FXML
    private TableColumn< Estudiante, String> tcMatricula;
    @FXML
    private TableColumn< Estudiante, CheckBox> tcValidar;
    @FXML
    private TableColumn< Estudiante, CheckBox> tcDepurar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}