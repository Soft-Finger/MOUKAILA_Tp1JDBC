package service;

import model.Client;
import persistence.JdbcBibliothequeH2;

import java.sql.SQLException;

public class ServiceClient {
    private final JdbcBibliothequeH2 jdbcBibliotheque;

    public ServiceClient ( JdbcBibliothequeH2 jdbcBibliotheque ) {
        this.jdbcBibliotheque = jdbcBibliotheque;
    }

    public void  createDatabase() throws SQLException {
        jdbcBibliotheque.createDatabase();
    }

    public void save( Client client) {
        jdbcBibliotheque.save( client );
    }

    public Client getClient(int clientId) {
        return jdbcBibliotheque.getClient( clientId );
    }

    public void modifierClient(int id) throws SQLException {
        jdbcBibliotheque.modifierClient( id );
    }
}
