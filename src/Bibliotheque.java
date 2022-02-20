//import com.sun.security.ntlm.Client;

import model.Client;
import persistence.JdbcBibliothequeH2;
import service.ServiceClient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    public static List<Client> listeClient=new ArrayList<>();

    public static void main(String[] args) throws SQLException {

        ServiceClient serviceClient = new ServiceClient(new JdbcBibliothequeH2());

        //        AJOUT AUTOMATIQUE DE 5 ADHERENT
        Client a1 = new Client(95, "slama", "khairi", "javatown, sousse", "habitant", 2);
        Client a2 = new Client(96, "slama", "khalil", "Borjine, bar", "Visiteur", 1);
        Client a3 = new Client(97, "zaatir", "Mounir", "Bohsina, saoul", "Visiteur", 3);
        Client a4 = new Client(98, "rouis", "houssem", "javatown, sousse", "habitant", 1);
        Client a5 = new Client(99, "smida", "ghada", "Chott mariem", "Visiteur", 2);

        serviceClient.createDatabase();
        serviceClient.sauvegarderClient( a1 );
        serviceClient.sauvegarderClient(a2);
        serviceClient.sauvegarderClient(a3);
        serviceClient.sauvegarderClient(a4);
        serviceClient.sauvegarderClient(a5);
        // Lecture
        listeClient=serviceClient.getAllClients();
        System.out.println("liste des clients");
        for(Client c:listeClient){

            System.out.println(c);
        }

        //modofication
        a4.setNom("OLAEWE");
        a4.setType("payant");
        serviceClient.modifierClient(a4);
        System.out.println("modification effectuée");
        System.out.println(serviceClient.getClient(98));
        //Suppression
        serviceClient.supprimerClient(96);

        System.out.println("suppression effectuée");

        listeClient=serviceClient.getAllClients();
        System.out.println("liste des clients");
        for(Client c:listeClient){
            System.out.println(c);
        }

    }
}
