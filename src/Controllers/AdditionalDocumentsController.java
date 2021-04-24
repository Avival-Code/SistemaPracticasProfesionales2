package Controllers;

import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import sample.LoginSession;

import java.net.URL;
import java.util.ResourceBundle;

public class AdditionalDocumentsController implements Initializable {
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
    private TableView<?> studentDocumentsTable;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> keyColumn;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private Button uploadDocumento;

    @FXML
    private Button deleteDocument;

    @FXML
    private Button downloadDocumento;

    @Override
    public void initialize( URL url, ResourceBundle resourceBundle ) {
        SetUserInformation();
    }

    private void SetUserInformation() {
        nameText.setText( LoginSession.GetInstance().GetEstudiante().getNombres() );
        lastNameText.setText( LoginSession.GetInstance().GetEstudiante().GetApellidos() );
        matriculaText.setText( LoginSession.GetInstance().GetEstudiante().GetMatricula() );
    }

    @FXML
    public void DeleteDocument( MouseEvent mouseEvent ) {

    }

    @FXML
    public void DownloadDocument( MouseEvent mouseEvent ) {

    }

    @FXML
    public void Return( MouseEvent mouseEvent ) { screenChanger.ShowStudentMainMenuScreen( mouseEvent, errorText ); }

    @FXML
    public void UploadDocument( MouseEvent mouseEvent ) {

    }
}
