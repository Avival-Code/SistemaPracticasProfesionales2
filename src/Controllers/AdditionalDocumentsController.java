package Controllers;

import Database.DocumentoDAO;
import Database.ExpedienteDAO;
import Entities.Documento;
import Entities.Expediente;
import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import sample.LoginSession;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdditionalDocumentsController implements Initializable {
    private ScreenChanger screenChanger = new ScreenChanger();
    private FileChooser fileChooser = new FileChooser();
    private DocumentoDAO documentos = new DocumentoDAO();
    private ExpedienteDAO expedientes = new ExpedienteDAO();
    private List<Documento> documentosEstudiante = new ArrayList< Documento >();

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
    private TableView< Documento > studentDocumentsTable;

    @FXML
    private TableColumn< Documento, String > nameColumn;

    @FXML
    private TableColumn< Documento, String > dateColumn;

    @FXML
    private Button uploadDocumento;

    @FXML
    private Button deleteDocument;

    @FXML
    private Button downloadDocumento;

    @Override
    public void initialize( URL url, ResourceBundle resourceBundle ) {
        SetUserInformation();
        SetCellValueFactory();
        ConfigureFileChooser();
        ShowDocumentos();
    }

    private void SetUserInformation() {
        nameText.setText( LoginSession.GetInstance().GetEstudiante().getNombres() );
        lastNameText.setText( LoginSession.GetInstance().GetEstudiante().GetApellidos() );
        matriculaText.setText( LoginSession.GetInstance().GetEstudiante().GetMatricula() );
    }

    private void SetCellValueFactory() {
        nameColumn.setCellValueFactory( new PropertyValueFactory<>( "titulo" ) );
        dateColumn.setCellValueFactory( new PropertyValueFactory<>( "fechaEntrega" ) );
    }

    private void ConfigureFileChooser() {
        fileChooser.setTitle( "Buscar Documento..." );
    }

    private void ShowDocumentos() {
        studentDocumentsTable.getItems().clear();
        documentosEstudiante = documentos.ReadAll();
        int claveExpediente = GetUserExpediente().GetClave();
        for( Documento documento : documentosEstudiante ) {
            if( documento.GetClaveExpediente() == claveExpediente ) {
                studentDocumentsTable.getItems().add( documento );
            }
        }
    }

    private Expediente GetUserExpediente() {
        List< Expediente > expedientesUsuarios = expedientes.ReadAll();
        Expediente userExpediente = null;
        for( Expediente expediente : expedientesUsuarios ) {
            if( expediente.GetMatricula().equals( LoginSession.GetInstance().GetEstudiante().GetMatricula() ) ) {
                userExpediente = expediente;
            }
        }
        return userExpediente;
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
