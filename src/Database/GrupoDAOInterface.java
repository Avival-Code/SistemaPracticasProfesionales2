package Database;

import Entities.RegistroGrupo;
import java.util.List;

public interface GrupoDAOInterface {
    boolean Create( RegistroGrupo registro );
    List< RegistroGrupo > ReadAll();
    boolean Delete( String Identificador );
    boolean Update( RegistroGrupo registro );
}
