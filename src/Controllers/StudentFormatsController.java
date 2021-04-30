package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class StudentFormatsController {

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
    private TableView<?> formatosTable;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private Button entregarReporte;

    @FXML
    void DownloadFormat( MouseEvent event ) {

    }

    @FXML
    void Return( MouseEvent event ) {

    }
}
