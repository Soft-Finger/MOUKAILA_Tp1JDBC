package persistence;


import model.Client;

import java.sql.SQLException;
import java.util.List;

public interface JdbcBibliotheque {
    void createDatabase () throws SQLException;

    void sauvegarderClient ( Client client );

    Client getClient ( int clientId );

    void supprimerClient ( int clientId );

    List<Client> getAllClients ();

    void modifierClient ( Client client ) throws SQLException;
}
