/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 21 - abr - 2021
 * Descripción:
 * Interfaz con los métodos necesarios para implementar
 * el patrón de Data Access Object para registrar, obtener y eliminar
 * listas de responsables proyectos por organizacion vinculada.
 */
package Database;

import java.util.List;

/**
 * Interfaz con los métodos necesarios para implementar
 * el patrón de Data Access Object para registrar, obtener y eliminar
 * listas de responsables proyectos por organizacion vinculada.
 */
public interface ResponsablesOrganizacionDAOInterface {
    boolean Create( int idOrganizacion, List< Integer > idResponsablesProyecto );
    List< Integer > Read( int idOrganizacion );
    boolean Delete( int idOrganizacion );
    boolean Update( int idOrganizacion, List< Integer > idResponsablesProyecto );
}
