package model;

public class Client {
    private int idClient;
    private String nom;
    private String prenom;
    private String adresse;
    private String type;
    private int nbMaxPrets;
    private int nbPret;
    private int nbPretTotal;

    public Client ( int idClient , String nom , String prenom , String adresse ,
                    String type , int nbMaxPrets , int nbPret , int nbPretTotal ) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.type = type;
        this.nbMaxPrets = nbMaxPrets;
        this.nbPret = nbPret;
        this.nbPretTotal = nbPretTotal;
    }

    public Client () {
    }

    public int getIdClient () {
        return idClient;
    }

    public void setIdClient ( int idClient ) {
        this.idClient = idClient;
    }

    public String getNom () {
        return nom;
    }

    public void setNom ( String nom ) {
        this.nom = nom;
    }

    public String getPrenom () {
        return prenom;
    }

    public void setPrenom ( String prenom ) {
        this.prenom = prenom;
    }

    public String getAdresse () {
        return adresse;
    }

    public void setAdresse ( String adresse ) {
        this.adresse = adresse;
    }

    public String getType () {
        return type;
    }

    public void setType ( String type ) {
        this.type = type;
    }

    public int getNbMaxPrets () {
        return nbMaxPrets;
    }

    public void setNbMaxPrets ( int nbMaxPrets ) {
        this.nbMaxPrets = nbMaxPrets;
    }

    public int getNbPret () {
        return nbPret;
    }

    public void setNbPret ( int nbPret ) {
        this.nbPret = nbPret;
    }

    public int getNbPretTotal () {
        return nbPretTotal;
    }

    public void setNbPretTotal ( int nbPretTotal ) {
        this.nbPretTotal = nbPretTotal;
    }


    public void ajouterClient(Client client) {

    }

    public void supprimerClientParId(int id) {

    }

    public void modifierClient(int id) {

    }

    public void rechercherClient(String nom, String prenom) {

    }



    @Override
    public String toString () {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", type='" + type + '\'' +
                ", nbMaxPrets=" + nbMaxPrets +
                ", nbPret=" + nbPret +
                ", nbPretTotal=" + nbPretTotal +
                '}';
    }
}
