package Controllers;

import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class AdditionalDocumentsController {
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

    @FXML
    void DeleteDocument( MouseEvent mouseEvent ) {

    }

    @FXML
    void DownloadDocument( MouseEvent mouseEvent ) {

    }

    @FXML
    void Return( MouseEvent mouseEvent ) { screenChanger.ShowStudentMainMenuScreen( mouseEvent, errorText ); }

    @FXML
    void UploadDocument( MouseEvent mouseEvent ) {

    }
}
