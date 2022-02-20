//import com.sun.security.ntlm.Client;

import model.Client;
import persistence.JdbcBibliothequeH2;
import service.ServiceClient;

import java.sql.SQLException;

public class Bibliotheque {
    public static void main(String[] args) throws SQLException {
        Client client = new Client(1, "yahaya", "Moukaila","javatown","simple",0,0,0);
        Client client2 = new Client(2, "Arthur", "Goodman","javaCity","roman",3,2,2);
        ServiceClient serviceClient = new ServiceClient(new JdbcBibliothequeH2());
        serviceClient.createDatabase();
        serviceClient.save(client);
        serviceClient.save(client2);
        Client client1 = serviceClient.getClient(2);
        System.out.println(client2);
        serviceClient.modifierClient( client1.getIdClient() );
        System.out.println(client1);
    }
}
