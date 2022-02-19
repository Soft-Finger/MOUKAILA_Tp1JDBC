//import com.sun.security.ntlm.Client;

import model.Client;
import persistence.JdbcBibliothequeH2;
import service.ServiceClient;

import java.sql.SQLException;

public class Bibliotheque {
    public static void main(String[] args) throws SQLException {
        Client client = new Client(1, "yahaya", "Moukaila","javatown","simple",0,0,0);
        ServiceClient serviceClient = new ServiceClient(new JdbcBibliothequeH2());
        serviceClient.createDatabase();
        serviceClient.save(client);
        Client client1 = serviceClient.getClient(1);
        System.out.println(client1);
    }
}
