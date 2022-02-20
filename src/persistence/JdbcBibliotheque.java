package persistence;


import model.Client;

import java.sql.SQLException;

public interface JdbcBibliotheque {
    public void createDatabase() throws SQLException;
    public void save( Client client);
    public Client getClient(int clientId);
    public void modifierClient ( int id ) throws SQLException;
}
