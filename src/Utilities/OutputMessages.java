/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 31 - mar - 2021
 * Descripción:
 * Clase que contiene todos los mensajes dirigidos al usuario
 * por el sistema.
 */
package Utilities;

/**
 * Clase que contiene todos los mensajes dirigidos al usuario
 * por el sistema.
 */
public class OutputMessages {
    /**
     * Mensaje mostrado en caso de no encontrar el archivo FXML de la pantalla
     * Registro_Estudiante
     * @return una cadena con el mensaje de error
     */
    public String RegistryScreenMissing() { return "No se encontró el archivo FXML de pantalla Registro."; }

    /**
     * Mensaje mostrado en caso de no encontrar el archivo FXML de la pantalla
     * IniciarSesión
     * @return una cadena con el mensaje de error
     */
    public String LoginScreenMissing() { return "No se encontró el archivo FXML de pantalla Login."; }

    /**
     * Mensaje mostrado en caso de no encontrar el archivo fxml del menú principal
     * de Estudiantes
     * @return una cadena con el mensaje de error
     */
    public String StudentMainMenuMissing() { return "No se encontró el archivo FXML del menú principal de estudiante"; }

    /**
     * Mensaje mostrado en caso de no encontrar el archivo fxml de la pantalla
     * EscogerProyectos_Estudiante
     * @return una cadena con el mensaje de error
     */
    public String ChooseProjectsMissing() { return "No se encontró el archivo FXML de la pantalla Escoger Proyectos."; }

    /**
     * Mensaje mostrado cuando se intenta cambiar a la pantalla EscogerProyectos_Estudiante
     * y el usuario ya ha seleccionado 3 proyectos
     * @return una cadena con el mensjae de error
     */
    public String AlreadyChoseProjects() { return "Ya seleccionaste 3 proyectos para asignación."; }

    /**
     * Mensaje mostrado cuando se intenta agregar un proyecto a la lista de proyectos seleccionados
     * en la pantalla EscogerProyectos_Estudiantes.
     * @return una cadena con el mensaje de error
     */
    public String AlreadySelectedMaxAmountProjects() { return "Ya tienes 3 proyectos seleccionados."; }

    /**
     * Mensaje mostrado cuando se intenta mandar una selección de proyectos sin tener
     * 3 proyectos seleccionados en la pantalla EscogerProyectos_Estudiante
     * @return una cadena con el mensaje de error
     */
    public String NotEnoughProjectsSelected() { return "No has seleccionado 3 proyectos."; }

    /**
     * Mensaje mostrado cuando se realiza la selección de proyectos por parte del
     * Estudiante de manera exitosa.
     * @return una cadena con el mensaje de éxito
     */
    public String ProjectSelectionSuccessful() { return "Selección de proyectos se realizó con éxito."; }

    /**
     * Mensaje mostrado en caso de no encontrar el archivo FXML de la pantalla
     * Reportes_Estudiante
     * @return una cadena con el mensaje de error
     */
    public String StudentReportScreenMissing() { return "No se encontró el archivo FXML de la pantalla Reportes_Estudiante."; }

    /**
     * Mensaje mostrado cuando se registra un nuevo Estudiante a la
     * base de datos de manera exitosa.
     * @return una cadena con el mensaje de éxito
     */
    public String RegistrationSuccessful() { return "Registro Exitoso"; }

    /**
     * Mensaje mostrado cuando ocurre un error en la base de datos
     * @return una cadena con el mensaje de error
     */
    public String DatabaseConnectionFailed() { return "No hay conexión a la base de datos. Intente más tarde."; }

    /**
     * Mensaje mostrado cuando ya existe un Estudiante en base de datos
     * @return una cadena con el mensaje de error
     */
    public String StudentAlreadyExists() { return "Ya existe un registro con esa información"; }

    /**
     * Mensaje mostrado cuando se quiere acceder a funcionalidad que requiere tener
     * un proyecto asigando.
     * @return una cadena con el mensaje de error
     */
    public String ProjectNotAssigned() { return "Aún no te han asignado un proyecto."; }

    /**
     * Mensaje mostrado cuando se intenta entregar un reporte con
     * que tiene el mismo nombre que otro el el expediente del estudiante
     * @return una cadena con el mensaje de error
     */
    public String ReportNameAlreadyExists() { return "Ya existe un reporte con ese nombre en tu expediente."; }

    /**
     * mensaje mostrado cuando se introduce información de login que no
     * existe en la base de datos
     * @return una cadena con el mensaje de error
     */
    public String InvalidLoginInformation() { return "El usuario o contraseña es incorrecta."; }

    /**
     * Mensaje mostrado cuando los nombres introducidos por el usuario
     * son inválidos
     * @return una cadena con el mensaje de error
     */
    public String InvalidNames() { return "Los nombres no son validos."; }

    /**
     * Mensaje mostrado cuando los apellidos introducidos por el usuario
     * son inválidos
     * @return una cadena con el mensaje de error
     */
    public String InvalidLastNames() { return "Los apellidos no son validos."; }

    /**
     * Mensaje mostrado cuando el correo electrónico introducido por el usuario
     * es inválido
     * @return una cadena con el mensaje de error
     */
    public String InvalidEmail() { return "El correo electrónico no es valido"; }

    /**
     * Mensaje mostrado cuando la matrícula introducida por el usuario
     * es inválida
     * @return una cadena con el mensaje de error
     */
    public String InvalidMatricula() { return "La matrícula no es valida."; }

    /**
     * Mensaje mostrado cuando el NRC introducido por el usuario
     * es inválido
     * @return una cadena con el mensaje de error
     */
    public String InvalidNRC() { return "El nrc no es vlido."; }

    /**
     * Mensaje mostrado cuando el teléfono introducido por el usuario
     * es inválido
     * @return una cadena con el mensaje de error
     */
    public String InvalidTelephone() { return "El teléfono no es valido."; }

    /**
     * Mensaje mostrado cuando la contraseña introducida por el usuario
     * es inválida
     * @return una cadena con el mensaje de error
     */
    public String InvalidPassword() { return "La contraseña no es valida."; }

    /**
     * Mensaje mostrado el nombre de usuario introducido en la pantalla InicioSesión
     * no es valido.
     * @return una cadena con el mensaje de error
     */
    public String InvalidUsername() { return "El número personal o matrícula no es valida."; }

    /**
     * Mensaje mostrado cuando las contraseñas introducidas por el usuario
     * son inválidas
     * @return una cadena con el mensaje de error
     */
    public String PasswordsDontMatch() { return "Las contraseñas no coinciden."; }
}