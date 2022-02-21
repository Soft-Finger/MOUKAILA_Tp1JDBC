package service;

import model.Client;
import persistence.JdbcBibliotheque;

import java.sql.SQLException;
import java.util.List;

public class ServiceClient {

    private final JdbcBibliotheque jdbcBibliotheque;

    public ServiceClient ( JdbcBibliotheque jdbcBibliotheque ) {
        this.jdbcBibliotheque = jdbcBibliotheque;
    }

    public void createDatabase () throws SQLException {
        jdbcBibliotheque.createDatabase();
    }

    public void sauvegarderClient ( Client client ) {
        jdbcBibliotheque.sauvegarderClient( client );
    }

    public Client getClient ( int clientId ) {
        return jdbcBibliotheque.getClient( clientId );
    }

    public void modifierClient ( Client client ) throws SQLException {
        jdbcBibliotheque.modifierClient( client );
    }

    public List<Client> getAllClients () {
        return jdbcBibliotheque.getAllClients();
    }

    public void supprimerClient ( int clientId ) {
        jdbcBibliotheque.supprimerClient( clientId );
    }
}
