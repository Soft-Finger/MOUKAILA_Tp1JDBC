package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PretDocument {
    private Date dateDebutPret;
    private Date dateFinPret;

    private Client client;
    private Document document;
    private List<Client> listePretsDocuments = new ArrayList<>();

    public PretDocument () {
    }

    public PretDocument ( Date dateDebutPret ,
                          Date dateFinPret ,
                          Client client ,
                          Document document ) {
        this.dateDebutPret = dateDebutPret;
        this.dateFinPret = dateFinPret;
        this.client = client;
        this.document = document;
    }

    public Date getDateDebutPret () {
        return dateDebutPret;
    }

    public void setDateDebutPret ( Date dateDebutPret ) {
        this.dateDebutPret = dateDebutPret;
    }

    public Date getDateFinPret () {
        return dateFinPret;
    }

    public void setDateFinPret ( Date dateFinPret ) {
        this.dateFinPret = dateFinPret;
    }

    public Client getClient () {
        return client;
    }

    public void setClient ( Client client ) {
        this.client = client;
    }

    public Document getDocument () {
        return document;
    }

    public void setDocument ( Document document ) {
        this.document = document;
    }

    public List<Client> getListePretsDocuments () {
        return listePretsDocuments;
    }

    public void setListePretsDocuments ( List<Client> listePretsDocuments ) {
        this.listePretsDocuments = listePretsDocuments;
    }

    public void calculerDateRetour(){
        Calendar calendrier = Calendar.getInstance();
        calendrier.setTime(getDateDebutPret());
        calendrier.add(Calendar.DATE, getClient().getDureeMaximumPret());
        setDateFinPret(calendrier.getTime());
    }

}
