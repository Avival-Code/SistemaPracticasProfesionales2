package Controllers;

import Database.ArchivoConsultaDAO;
import Database.DocenteDAO;
import Database.RegistroGrupoDAO;
import Entities.ArchivoConsulta;
import Entities.Docente;
import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import sample.LoginSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentFormatsController implements Initializable{
    private ScreenChanger screenChanger = new ScreenChanger();
    private ArchivoConsultaDAO archivos = new ArchivoConsultaDAO();
    private RegistroGrupoDAO registros = new RegistroGrupoDAO();
    private DocenteDAO docentes = new DocenteDAO();
    private DirectoryChooser directoryChooser = new DirectoryChooser();

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
    private TableView< ArchivoConsulta > formatosTable;

    @FXML
    private TableColumn< ArchivoConsulta, String > nameColumn;

    @FXML
    private Button entregarReporte;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SetUserInformation();
        SetCellValueFactory();
        ShowFiles();
    }

    /**
     * Coloca la información del usuario actual en los campos de texto
     * nameText, lastNameText y matriculaText
     */
    private void SetUserInformation() {
        nameText.setText( LoginSession.GetInstance().GetEstudiante().getNombres() );
        lastNameText.setText( LoginSession.GetInstance().GetEstudiante().GetApellidos() );
        matriculaText.setText( LoginSession.GetInstance().GetEstudiante().getMatricula() );
    }

    /**
     * Configura las columnas de la tabla mostrada en esta pantalla
     */
    private void SetCellValueFactory() {
        nameColumn.setCellValueFactory( new PropertyValueFactory<>( "titulo" ) );
    }

    /**
     * Muestra todos los reportes almacenados en la base de datos del estudiante
     * actual
     */
    private void ShowFiles() {
        formatosTable.getItems().clear();
        for( ArchivoConsulta archivo : archivos.ReadAll() )
        {
            if( archivo.GetNumeroPersonal().equals( GetNumeroPersonal() ) ) {
                formatosTable.getItems().add( archivo );
            }
        }
    }

    private String GetNumeroPersonal() {
        String numeroPersonal = "";
        String nrcEstudiante = LoginSession.GetInstance().GetEstudiante().getNrc();
        for( Docente docente : docentes.ReadAll() ) {
            if( docente != null && docente.GetNrc().equals( nrcEstudiante ) ) {
                numeroPersonal = docente.GetNumeroPersonal();
            }
        }
        return numeroPersonal;
    }

    @FXML
    void DownloadFormat( MouseEvent mouseEvent ) {
        if( IsFileSelected() ) {
            File directoryFile = GetDirectory( mouseEvent );
            CopyFile( archivos.Read( formatosTable.getSelectionModel().getSelectedItem().GetId() ).GetDescripcion(),
                    directoryFile );
        }
    }

    @FXML
    void Return( MouseEvent mouseEvent ) {
        screenChanger.ShowStudentMainMenuScreen( mouseEvent, errorText );
    }

    private boolean IsFileSelected() {
        boolean isSelected = false;
        if( formatosTable.getSelectionModel().getSelectedItem() != null ) {
            isSelected = true;
        }
        return isSelected;
    }

    private File GetDirectory( MouseEvent mouseEvent ) {
        return directoryChooser.showDialog( ( (Node)mouseEvent.getSource() ).getScene().getWindow() );
    }

    /**
     * Copia un archivo recuperado de la base de datos a la máquina local del
     * usuario.
     * @param dataBaseFile el archivo recuperado de la base de datos
     * @param directoryFile el archivo que contiene el path de la máquina local donde se desea almacenar el archivo
     */
    private void CopyFile( File dataBaseFile, File directoryFile ) {
        try {
            FileInputStream input = new FileInputStream( dataBaseFile );
            File outputFile = new File( FixFilePath( directoryFile.getAbsolutePath() + "\\" + dataBaseFile.getName() ) );
            FileOutputStream output = new FileOutputStream( outputFile );
            CreateFile( outputFile );
            int inputValue;

            while( ( inputValue = input.read() ) != -1 ) {
                output.write( inputValue );
            }
            input.close();
            output.close();
        } catch( IOException exception ) {
            exception.printStackTrace();
        }
    }

    /**
     * Agrega characteres necesarios para poder almacenar un archivo en un path
     * en específico. (Windows)
     * @param targetString la cadena inicial
     * @return una cadena modificada
     */
    private String FixFilePath( String targetString ) {
        for( int i = 0; i < targetString.length(); i++ ) {
            if( targetString.charAt( i ) == 92 ) {
                targetString = targetString.substring( 0, i ) + "\\" + targetString.substring( i );
                i++;
            }
        }
        return targetString;
    }

    /**
     * Crea un archivo en la máquina local del usuario en caso de no existir previamente
     * @param targetFile el archivo que se desea crear
     * @throws IOException
     */
    private void CreateFile( File targetFile ) throws IOException {
        if( !targetFile.exists() ) {
            targetFile.createNewFile();
        }
    }
}
