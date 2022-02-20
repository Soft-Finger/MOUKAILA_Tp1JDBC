package persistence;


import model.Client;

import java.sql.*;


public class JdbcBibliothequeH2 implements JdbcBibliotheque {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/bibliotheque";

    private static final String USER = "sa";
    private static final String PASS = "";

    private static Connection conn = null;
    private static Statement stmt = null;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createDatabase() {
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "CREATE TABLE CLIENT" +
                    "(id INTEGER not NULL, " +
                    " nom VARCHAR(255), " +
                    " prenom VARCHAR(255), " +
                    " adresse VARCHAR(255), " +
                    " type VARCHAR(255), " +
                    " nbMaxPrets INTEGER, " +
                    " nbPret INTEGER, " +
                    " nbPretTotal INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

            stmt.close();
            conn.close();
        } catch(Exception e) {
            handleException(e);
        } finally {
            try{
                if(stmt != null) stmt.close();
            } catch(SQLException ignored) {
            }
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                handleException(se);
            }
        }
        System.out.println("Goodbye!");
    }



    public void save( Client client) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()
        ) {
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO CLIENT VALUES ('" + client.getIdClient() +
                    "', '" + client.getNom() +
                    "', '" + client.getPrenom() +
                    "', '" + client.getAdresse() +
                    "', '" + client.getType() +
                    "', '" + client.getNbMaxPrets() +
                    "', '" + client.getNbPret() +
                    "', '" + client.getNbPretTotal()+"');";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            handleException(e);
        }
    }

    private static void handleException(Exception exception) {
        if (exception instanceof SQLException) {
            SQLException sqlException = (SQLException) exception;
            System.out.println("Error Code: " + sqlException.getErrorCode());
            System.out.println("SQL State: " + sqlException.getSQLState());
        }
        System.out.println("SQLException message: " + exception.getMessage());
        System.out.println("Stacktrace: ");
        exception.printStackTrace();
    }


    public Client getClient(int clientId) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS) ;
            PreparedStatement ps = conn.prepareStatement("SELECT * from CLIENT WHERE ID='"+clientId+"'") ) {

            try (ResultSet rs = ps.executeQuery()) {
                if ( rs.next()) {
                    return new Client(rs.getInt("id"), rs.getString("nom"),
                            rs.getString("prenom"),rs.getString("adresse"),
                            rs.getString("type"),rs.getInt("nbMaxPrets"),
                            rs.getInt("nbPret"),rs.getInt("nbPretTotal"));
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            handleException(e);
            return null;
        }
    }

    public void modifierClient(int id) throws SQLException {
        Connection connexion = DriverManager.getConnection(DB_URL, USER, PASS) ;
            String sql = "UPDATE  CLIENT SET nom = 'Mykerinos'WHERE id = 1";
            Statement statement = connexion.createStatement();
            int rows = statement.executeUpdate( sql );

            if ( rows > 0 ) {
                System.out.println("client modifier avec succes");
            }

    }

}
