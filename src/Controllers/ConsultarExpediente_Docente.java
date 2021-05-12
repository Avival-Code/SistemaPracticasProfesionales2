package Controllers;

import Database.ExpedienteDAO;
import Database.ProyectoDAO;
import Entities.ArchivoConsulta;
import Entities.Documento;
import Entities.Estudiante;
import Utilities.LoginSession;
import Utilities.OutputMessages;
import Utilities.ScreenChanger;
import Utilities.SelectionContainer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsultarExpediente_Docente implements Initializable {
    ScreenChanger screenChanger = new ScreenChanger();
    OutputMessages outputMessages = new OutputMessages();
    Estudiante estudianteSeleccionado = SelectionContainer.GetInstance().getEstudianteElegido();
    ExpedienteDAO expedienteDAO = new ExpedienteDAO();
    ProyectoDAO proyectoDAO = new ProyectoDAO();

    @FXML
    private Label lbNombre;
    @FXML
    private Label lbApellidos;
    @FXML
    private Label lbCedulaProfesional;
    @FXML
    private Text errorText;
    @FXML
    private Text confirmationText;
    @FXML
    private Label lbNombreEstudiante;
    @FXML
    private Label lbNombreProyecto;
    @FXML
    private TableView< Documento > tbvDocumentosSubidos;
    @FXML
    private TableColumn< Documento, String > tcNombre;
    @FXML
    private TableColumn< Documento, String > tcDescripcion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SetUsuario();
        MostrarInfoEstudiante();
    }

    /**
     * Muestra en pantalla la informacion del expediente del estudiante elegido
     * y su expediente
     */
    private void MostrarInfoEstudiante() {
        lbNombreEstudiante.setText( estudianteSeleccionado.getNombreCompleto() );
        lbNombreProyecto.setText( proyectoDAO.Read( expedienteDAO.ReadByStudent(
                estudianteSeleccionado.getMatricula() ).GetIDProyecto() ).getNombre() );
        ConfigurarColumnasTabla();
        RecuperarArchivos
        MostrarArchivosSubidos();
    }

    private void MostrarArchivosSubidos() {
        tbvDocumentosSubidos.getItems().clear();
        for (Documento documento : archivoConsultas) {
            tbvArchivosSubidos.getItems().add(archivoConsulta);
        }
    }

    private void ConfigurarColumnasTabla() {
        tcNombre.setCellValueFactory( new PropertyValueFactory<>( "nombre" ) );
        tcDescripcion.setCellValueFactory( new PropertyValueFactory<>( "descripcionArchivo" ) );
    }

    /**
     * Coloca la informacion del usuario actual en las etiquetas. Se coloca nombres, apellidos,
     * y numero personal.
     */
    public void SetUsuario() {
        lbNombre.setText(LoginSession.GetInstance().GetDocente().getNombres());
        lbApellidos.setText(LoginSession.GetInstance().GetDocente().GetApellidos());
        lbCedulaProfesional.setText(LoginSession.GetInstance().GetDocente().GetNumeroPersonal());
    }
}
