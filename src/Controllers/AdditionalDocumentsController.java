package Controllers;

import Database.DocumentoDAO;
import Database.ExpedienteDAO;
import Database.ReporteDAO;
import Entities.Documento;
import Entities.Expediente;
import Entities.Reporte;
import Utilities.OutputMessages;
import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import sample.LoginSession;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdditionalDocumentsController implements Initializable {
    private ScreenChanger screenChanger = new ScreenChanger();
    private FileChooser fileChooser = new FileChooser();
    private DocumentoDAO documentos = new DocumentoDAO();
    private ReporteDAO reportes = new ReporteDAO();
    private ExpedienteDAO expedientes = new ExpedienteDAO();
    private List<Documento> documentosEstudiante = new ArrayList< Documento >();
    private OutputMessages outputMessages = new OutputMessages();
    private Documento documento = null;

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
        ShowDocuments();
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

    private void ShowDocuments() {
        studentDocumentsTable.getItems().clear();
        documentosEstudiante = GetOnlyDocuments( documentos.ReadAll() );
        int claveExpediente = GetUserExpediente().GetClave();
        for( Documento documento : documentosEstudiante ) {
            if( documento.GetClaveExpediente() == claveExpediente ) {
                studentDocumentsTable.getItems().add( documento );
            }
        }
    }

    private List< Documento > GetOnlyDocuments( List< Documento > initialList ) {
        List< Reporte > reportList = reportes.ReadAll();
        for( int i = 0; i < initialList.size(); i++ ) {
            boolean removedItem = false;
            for( Reporte reporte : reportList ) {
                if( initialList.get( i ).getIdDocumento() == reporte.getIdDocumento() ) {
                    initialList.remove( i );
                    removedItem = true;
                }
            }
            if( removedItem ) {
                i--;
            }
        }
        return initialList;
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
        if( isDocumentSelected() ) {
            Alert deleteAlert = new Alert( Alert.AlertType.CONFIRMATION, outputMessages.DeleteDocumentConfirmation() );
            deleteAlert.showAndWait().ifPresent( response -> {
                if( response == ButtonType.OK ) {
                    documentos.Delete( studentDocumentsTable.getSelectionModel().getSelectedItem().getIdDocumento() );
                    ShowDocuments();
                }
            } );
        }
    }

    @FXML
    public void DownloadDocument( MouseEvent mouseEvent ) {

    }

    @FXML
    public void Return( MouseEvent mouseEvent ) { screenChanger.ShowStudentMainMenuScreen( mouseEvent, errorText ); }

    @FXML
    public void UploadDocument( MouseEvent mouseEvent ) {
        File document = GetFile( mouseEvent );
        if( documento != null && DocumentNameDoesNotExist( GetDocument( document ) ) ) {
            documentos.Create( GetDocument( document ) );
            ShowDocuments();
        }
    }

    private boolean DocumentNameDoesNotExist( Documento document ) {
        boolean nameDoesNotExist = true;
        List< Documento > listaDocumentos = documentos.ReadAll();
        for( Documento ejemplar : listaDocumentos ) {
            if( ejemplar.GetClaveExpediente() == documento.GetClaveExpediente() &&
                    ejemplar.getTitulo().equals( documento.getTitulo() ) ) {
                nameDoesNotExist = false;
                errorText.setText( outputMessages.DocumentNameAlreadyExists() );
            }
        }
        return nameDoesNotExist;
    }

    private File GetFile( MouseEvent mouseEvent ) {
        return fileChooser.showOpenDialog( ( (Node)mouseEvent.getSource() ).getScene().getWindow() );
    }

    private Documento GetDocument( File documentFile ) {
        LocalDate currentDate = LocalDate.now();
        documento = new Documento( 0 , documentFile.getName(), documentFile, currentDate.toString(),
                GetUserExpediente().GetClave() );
        return documento;
    }

    private boolean isDocumentSelected() {
        boolean isSelected = false;
        if( studentDocumentsTable.getSelectionModel().getSelectedItem() != null ) {
            isSelected = true;
        }
        return isSelected;
    }
}
