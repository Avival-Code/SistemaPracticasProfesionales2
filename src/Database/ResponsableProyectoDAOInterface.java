/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 26 - mar - 2021
 * Descripción:
 * Interfaz con los métodos necesarios para implementar
 * el patrón de Data Access Object para la entidad ResponsableProyecto.
 */
package Database;

import Entities.ResponsableProyecto;
import java.util.List;

public interface ResponsableProyectoDAOInterface {
    boolean Create(ResponsableProyecto responsable );
    List< ResponsableProyecto > ReadAll();
    ResponsableProyecto Read( int idResponsable );
    boolean Update( ResponsableProyecto responsable );
    boolean Delete( int idResponsable );
}
