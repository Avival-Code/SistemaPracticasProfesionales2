package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    //@FXML
    //private TableView< TableCell, String > tbvEstudiantes;
    @FXML
    private TableColumn tcNombre;
    @FXML
    private TableColumn tcMatricula;
    @FXML
    private TableColumn tcValidar;
    @FXML
    private TableColumn tc

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}

class CellChoser {

}
