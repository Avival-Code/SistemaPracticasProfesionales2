package Database;

import Entities.RegistroGrupo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GrupoDAO implements GrupoDAOInterface{
    @Override
    public boolean Create( RegistroGrupo registro ) {
        boolean wasCreated = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "INSERT INTO Grupo( NRC, Identificador ) " +
                    "VALUES ( ?, ? );";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setString( 1, registro.getNRC() );
            statement.setString( 2, registro.getIdentificador() );
            statement.executeUpdate();
            wasCreated = true;
        } catch ( Exception exception ) {
            exception.printStackTrace();
        }
        connection.StartConnection();
        return wasCreated;
    }

    @Override
    public List< RegistroGrupo > ReadAll() {
        List< RegistroGrupo > registros = new ArrayList<>();
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "SELECT * FROM Grupo;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.executeQuery();
            ResultSet result = statement.getResultSet();

            while( result.next() ) {
                registros.add( new RegistroGrupo( result.getString( 1 ), result.getString( 2 ) ) );
            }

            result.close();
            statement.close();
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return registros;
    }

    @Override
    public boolean Update( RegistroGrupo registro ) {
        boolean updated = Delete( registro.getIdentificador() );
        updated = Create( registro );
        return updated;
    }

    @Override
    public boolean Delete( String Identificador ) {
        boolean deleted = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "DELETE FROM Grupo WHERE Identificador = ?;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setString( 1, Identificador );
            statement.executeUpdate();
            deleted = true;
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return deleted;
    }
}
