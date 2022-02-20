package persistence;


import model.Client;

import java.sql.SQLException;
import java.util.List;

public interface JdbcBibliotheque {
    public void createDatabase() throws SQLException;
    public void sauvegarderClient ( Client client);
    public Client getClient(int clientId);
    public void supprimerClient ( int clientId);
    public List<Client> getAllClients();
    public void modifierClient ( Client client ) throws SQLException;
}
