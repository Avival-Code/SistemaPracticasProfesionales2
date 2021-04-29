package Controllers;

import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ProjectDetailsController {
    private ScreenChanger screenChanger = new ScreenChanger();

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

    @FXML
    void Return( MouseEvent mouseEvent ) {
        screenChanger.ShowStudentMainMenuScreen( mouseEvent, errorText );
    }
}