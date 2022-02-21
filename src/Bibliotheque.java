//import com.sun.security.ntlm.Client;

import model.Client;
import persistence.JdbcBibliothequeH2;
import service.ServiceClient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    public static List<Client> listeClient = new ArrayList<>();

    public static void main ( String[] args ) throws SQLException {

        ServiceClient serviceClient = new ServiceClient( new JdbcBibliothequeH2() );
        serviceClient.createDatabase();

        //        AJOUT AUTOMATIQUE DE 5 ADHERENT
        Client client1 = new Client( 95 , "Magnus" , "Carlsen" , "javatown, Nord" , "habitant" , 2 );
        Client client2 = new Client( 96 , "Garry" , "Kasparow" , "26 rue Petersburg, bar" , "Visiteur" , 1 );
        Client client3 = new Client( 97 , "Fabiano" , "Caruana" , "Bohsina, saoul" , "Visiteur" , 3 );
        Client client4 = new Client( 98 , "Levon" , "Aronian" , "javatown, sousse" , "habitant" , 1 );
        Client client5 = new Client( 99 , "Maxim" , "Vachier-Lagrave" , "Chott mariem" , "Visiteur" , 2 );

        serviceClient.sauvegarderClient( client1 );
        serviceClient.sauvegarderClient( client2 );
        serviceClient.sauvegarderClient( client3 );
        serviceClient.sauvegarderClient( client4 );
        serviceClient.sauvegarderClient( client5 );
        // Lecture
        listeClient = serviceClient.getAllClients();
        System.out.println( "liste des clients" );
        for ( Client c : listeClient ) {
            System.out.println( c );
        }

        //modification
        client4.setNom( "Smith" );
        client4.setTypeClient( "Visiteur" );
        serviceClient.modifierClient( client4 );
        System.out.println( "modification effectuée" );
        System.out.println( serviceClient.getClient( 98 ) );
        //Suppression
        serviceClient.supprimerClient( 96 );

        System.out.println( "suppression effectuée" );

        listeClient = serviceClient.getAllClients();
        System.out.println( "liste des clients" );
        for ( Client c : listeClient ) {
            System.out.println( c );
        }

    }
}
