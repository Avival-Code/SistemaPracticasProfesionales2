/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 3 - mar - 2021
 * Descripción:
 * Clase que contiene la información del responsable del proyecto
 */
package Entities;

/**
 * Clase que contiene la información del responsable del proyecto
 */
public class ResponsableProyecto {
    private int idResponsableProyecto;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String telefono;

    /**
     * Constructor sin parametros de ResponsableProyecto. Crea una instancia
     * con un ID = 0 y cadenas vacías.
     */
    public ResponsableProyecto() {
        idResponsableProyecto = 0;
        nombres = "";
        apellidos = "";
        correoElectronico = "";
        telefono = "";
    }

    /**
     * Constructor de la clase ResponsableProyecto. Crea una nueva
     * instancia de ResponsableProyecto a partir de una instancia existente.
     * @param original la instancia existente de ResponsableProyecto
     */
    public ResponsableProyecto( ResponsableProyecto original ) {
        this( original.idResponsableProyecto, original.nombres, original.apellidos, original.correoElectronico,
                original.telefono );
    }

    /**
     * Constructor de la clase ResponsableProyecto. Crea una insancia con
     * los valores introducidos.
     * @param idResponsableIn
     * @param nombresIn los nombres del ResponsableProyecto.
     * @param apellidosIn los apellidos del ResponsableProyecto.
     * @param correoIn el correo electrónico del ResponsableProyecto.
     * @param telefonoIn el teléfono del ResponsableProyecto.
     */
    public ResponsableProyecto( int idResponsableIn, String nombresIn, String apellidosIn,
                                String correoIn, String telefonoIn ) {
        idResponsableProyecto = idResponsableIn;
        nombres = nombresIn;
        apellidos = apellidosIn;
        correoElectronico = correoIn;
        telefono = telefonoIn;
    }

    /**
     * Regresa los nombres del ResponsableProyecto
     * @return
     */
    public String GetNombres() {
        return nombres;
    }

    /**
     * Regresa los apellidos del ResponsableProyecto
     * @return
     */
    public String GetApellidos() {
        return apellidos;
    }

    /**
     * Regresa el correo electrónico del ResponsableProyecto
     * @return
     */
    public String GetCorreo() {
        return correoElectronico;
    }

    /**
     * Regresa el teléfono del ResponsableProyecto
     * @return
     */
    public String GetTelefono() {
        return telefono;
    }

    /**
     * Cambia los nombres del ResponsableProyecto por el valor introducido
     * @param nombresIn
     */
    public void SetNombres( String nombresIn ) {
        nombres = nombresIn;
    }

    /**
     * Cambia los apellidos del ResponsableProyecto por el valor introducido
     * @param apellidosIn
     */
    public void SetApellidos( String apellidosIn ) {
        apellidos = apellidosIn;
    }

    /**
     * Cambia el correo electrónico del ResponsableProyecto por el valor introducido
     * @param correoIn
     */
    public void SetCorreo( String correoIn ) {
        correoElectronico = correoIn;
    }

    /**
     * Cambia el teléfono del ResponsableProyecto por el valor introducido
     * @param telefonoIn
     */
    public void SetTelefono( String telefonoIn ) {
        telefono = telefonoIn;
    }
}