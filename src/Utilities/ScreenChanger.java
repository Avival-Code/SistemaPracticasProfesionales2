/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 30 - mar - 2021
 * Descripción:
 * Clase encargada de realizar los cambios de pantallas de
 * la aplicación.
 */
package Utilities;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Clase encargada de realizar los cambios de pantallas de
 * la aplicación.
 */
public class ScreenChanger {
    private OutputMessages outputMessages = new OutputMessages();
    private String loginScreen = "../Resources/LoginScreen.fxml";
    private String registryScreen = "../Resources/RegistryScreen.fxml";
    private String studentMainMenu = "../Resources/StudentMainMenuScreen.fxml";
    private String chooseProjectsScreen = "../Resources/SelectProjectsScreen.fxml";
    private String studentReportsScreen = "../Resources/StudentReports.fxml";

    /**
     * Hace el cambio de pantalla a la pantalla de IniciarSesión.
     * @param mouseEvent el evento de mouse que inicio el cambio
     * @param errorText el campo de texto donde se coloca un mensaje en caso de error
     */
    public void ShowLoginScreen( MouseEvent mouseEvent, Text errorText ) {
        try {
            SetScene( mouseEvent, loginScreen );
        } catch( IOException exception ) {
            errorText.setText( outputMessages.LoginScreenMissing() );
        }
    }

    /**
     * Hace el cambio de pantalla a la pantalla de Registro_Estudiante.
     * @param mouseEvent el evento de mouse que inicio el cambio
     * @param errorText el campo de texto donde se coloca un mensaje en caso de error
     */
    public void ShowRegistryScreen( MouseEvent mouseEvent, Text errorText ) {
        try {
            SetScene( mouseEvent, registryScreen );
        } catch( IOException exception ) {
            errorText.setText( outputMessages.RegistryScreenMissing() );
        }
    }

    /**
     * Hace el cambio de pantalla a la pantalla del menú principal de
     * estudiante
     * @param mouseEvent el evento de mouse que inicio el cambio
     * @param errorText el campo de texto donde se coloca un mensaje en caso de error
     */
    public void ShowStudentMainMenuScreen( MouseEvent mouseEvent, Text errorText ) {
        try {
            SetScene( mouseEvent, studentMainMenu );
        } catch( IOException exception ) {
            errorText.setText( outputMessages.StudentMainMenuMissing() );
            exception.printStackTrace();
        }
    }

    /**
     * Hace el cambio de pantalla a la pantalla EscogerProyectos_Estudiante
     * @param mouseEvent el evento de mouse que inicio el cambio
     * @param errorText el campo de texto donde se coloca un mensaje en caso de error
     */
    public void ShowChooseProjectsScreen( MouseEvent mouseEvent, Text errorText ) {
        try {
            SetScene( mouseEvent, chooseProjectsScreen );
        } catch( IOException exception ) {
            errorText.setText( outputMessages.ChooseProjectsMissing() );
            exception.printStackTrace();
        }
    }

    /**
     * Hace el cambio de pantalla a la pantalla Reportes_Estudiante
     * @param mouseEvent el evento de mouse que inicio el cambio
     * @param errorText el campo de texto donde se coloca un mensaje en caso de error
     */
    public void ShowStudentReportsScreen( MouseEvent mouseEvent, Text errorText ) {
        try {
            SetScene( mouseEvent, studentReportsScreen );
        } catch( IOException exception ) {
            errorText.setText( outputMessages.StudentReportScreenMissing() );
            exception.printStackTrace();
        }
    }

    /**
     * Método utiliado en todos los cambios de pantalla.
     * @param mouseEvent el evento de mouse utilizado para conseguir la ventana actual
     * @param resourceName el nombre del archivo FXML de la pantalla deseada
     * @throws IOException ocurre cuando no se encuentra el archivo
     */
    private void SetScene( MouseEvent mouseEvent, String resourceName ) throws IOException {
        try {
            Parent newView = FXMLLoader.load( getClass().getResource( resourceName ) );
            Scene sceneView = new Scene( newView );
            Stage window = ( Stage )( ( Node )mouseEvent.getSource() ).getScene().getWindow();
            window.setScene( sceneView );
            window.show();
            window.setX( ( Screen.getPrimary().getBounds().getWidth() - window.getWidth() ) / 2 );
            window.setY( ( Screen.getPrimary().getBounds().getHeight() - window.getHeight() ) / 2 );
        } catch( IOException exception ) {
            throw exception;
        }
    }
}