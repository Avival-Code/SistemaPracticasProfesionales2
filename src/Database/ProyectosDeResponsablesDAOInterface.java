/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 21 - abr - 2021
 * Descripción:
 * Interfaz con los métodos necesarios para implementar
 * el patrón de Data Access Object para registrar, obtener y eliminar
 * listas de proyectos relacionados con un responsable proyecto.
 */
package Database;

import java.util.List;

/**
 * Interfaz con los métodos necesarios para implementar
 * el patrón de Data Access Object para registrar, obtener y eliminar
 * listas de proyectos relacionados con un responsable proyecto.
 */
public interface ProyectosDeResponsablesDAOInterface {
    boolean Create( int idResponsable, List< Integer > idProyectos );
    List< Integer > Read( int idResponsable );
    boolean Delete( int idProyecto );
    boolean Update( int idResponsable, List< Integer > idProyectos );
}
