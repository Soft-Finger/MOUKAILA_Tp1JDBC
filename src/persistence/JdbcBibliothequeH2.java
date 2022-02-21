package persistence;


import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JdbcBibliothequeH2 implements JdbcBibliotheque {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    //private static final String DB_URL = "jdbc:h2:~/bibliotheque";
    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/bibliotheque";

    private static final String USER = "sa";
    private static final String PASS = "";

    private static Connection conn = null;
    private static Statement stmt = null;

    static {
        try {
            Class.forName( JDBC_DRIVER );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void handleException ( Exception exception ) {
        if ( exception instanceof SQLException ) {
            SQLException sqlException = (SQLException) exception;
            System.out.println( "Error Code: " + sqlException.getErrorCode() );
            System.out.println( "SQL State: " + sqlException.getSQLState() );
        }
        System.out.println( "SQLException message: " + exception.getMessage() );
        System.out.println( "Stacktrace: " );
        exception.printStackTrace();
    }

    @Override
    public void createDatabase () {
        try {
            System.out.println( "Connecting to database..." );
            conn = DriverManager.getConnection( DB_URL , USER , PASS );

            System.out.println( "Creating table in given database..." );
            stmt = conn.createStatement();
            String sql = "CREATE TABLE CLIENT" +
                    "(id INTEGER not NULL, " +
                    " nom VARCHAR(255), " +
                    " prenom VARCHAR(255), " +
                    " adresse VARCHAR(255), " +
                    " typeClient VARCHAR(255), " +
                    " dureeMaximumPret INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate( sql );
            System.out.println( "Created table in given database..." );
            stmt.close();
            conn.close();
        } catch (Exception e) {
            handleException( e );
        } finally {
            try {
                if ( stmt != null ) stmt.close();
            } catch (SQLException ignored) {
            }
            try {
                if ( conn != null ) conn.close();
            } catch (SQLException se) {
                handleException( se );
            }
        }
        System.out.println( "Goodbye!" );
    }

    public void sauvegarderClient ( Client client ) {
        try (Connection conn = DriverManager.getConnection( DB_URL , USER , PASS ) ;
             Statement stmt = conn.createStatement()
        ) {
            System.out.println( "Inserting records into the CLIENT table..." );
            String sql = "INSERT INTO CLIENT VALUES ('" + client.getIdClient() +
                    "', '" + client.getNom() +
                    "', '" + client.getPrenom() +
                    "', '" + client.getAdresse() +
                    "', '" + client.getTypeClient() +
                    "', '" + client.getDureeMaximumPret() + "');";


            stmt.executeUpdate( sql );
            System.out.println( "Inserted records into the Client table..." );
        } catch (SQLException e) {
            handleException( e );
        }
    }

    public Client getClient ( int clientId ) {
        try (Connection conn = DriverManager.getConnection( DB_URL , USER , PASS ) ;
             PreparedStatement ps = conn.prepareStatement( "SELECT * from CLIENT WHERE ID='" + clientId + "'" )) {
            try (ResultSet rs = ps.executeQuery()) {
                if ( rs.next() ) {
                    return new Client( rs.getInt( "id" ) ,
                            rs.getString( "nom" ) ,
                            rs.getString( "prenom" ) ,
                            rs.getString( "adresse" ) ,
                            rs.getString( "typeClient" ) ,
                            rs.getInt( "dureeMaximumPret" ) );
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            handleException( e );
            return null;
        }
    }

    public void supprimerClient ( int clientId ) {
        try (Connection conn = DriverManager.getConnection( DB_URL , USER , PASS ) ;
             Statement stmt = conn.createStatement()
        ) {
            System.out.println( "deleting records from the table..." );
            String sql = "delete from CLIENT  where id='" + clientId + "'";


            stmt.executeUpdate( sql );
            System.out.println( " records deleted from the table..." );
        } catch (SQLException e) {
            handleException( e );
        }
    }

    public void modifierClient ( Client client ) throws SQLException {
        try (Connection conn = DriverManager.getConnection( DB_URL , USER , PASS ) ;
             Statement stmt = conn.createStatement()
        ) {
            System.out.println( "updating records into the table..." );
            String sql = "Update CLIENT set nom='" + client.getNom() +
                    "',prenom='" + client.getPrenom() +
                    "',adresse='" + client.getAdresse() +
                    "',typeClient='" + client.getTypeClient() +
                    "' where id='" + client.getIdClient() + "'";

            stmt.executeUpdate( sql );
            System.out.println( "updated records into the table..." );
        } catch (SQLException e) {
            handleException( e );
        }
    }

    public List<Client> getAllClients () {
        // Open a connection
        List<Client> listeClient = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection( DB_URL , USER , PASS ) ;
             PreparedStatement ps = conn.prepareStatement( "SELECT * from CLIENT" )) {
            try (ResultSet rs = ps.executeQuery()) {
                while ( rs.next() ) {
                    listeClient.add( new Client( rs.getInt( "id" ) ,
                    rs.getString( "nom" ) ,
                    rs.getString( "prenom" ) ,
                    rs.getString( "adresse" ) ,
                    rs.getString( "typeClient" ) ,
                    rs.getInt( "DureeMaximumPret" ) ) );
                }
            }

        } catch (SQLException e) {
            handleException( e );
            return null;
        }
        return listeClient;
    }
}
