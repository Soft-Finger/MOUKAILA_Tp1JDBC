package model;

import java.util.Date;

public class Document {
    private int idDocument;
    private String titreDocument;
    private String auteur;
    private String editeur;
    private Date datePublication;
    private int nbPretTotal;
    private int nbExemplaires;
    private String localisation;
    private  String genre;

    public Document () {
    }

    public Document ( int idDocument , String titreDocment , String auteur , String editeur , Date datePublication ,
                      int nbPretTotal , int nbExemplaires , String localisation , String genre ) {
        this.idDocument = idDocument;
        this.titreDocument = titreDocment;
        this.auteur = auteur;
        this.editeur = editeur;
        this.datePublication = datePublication;
        this.nbPretTotal = nbPretTotal;
        this.nbExemplaires = nbExemplaires;
        this.localisation = localisation;
        this.genre = genre;
    }

    public int getIdDocument () {
        return idDocument;
    }

    public void setIdDocument ( int idDocument ) {
        this.idDocument = idDocument;
    }

    public String getTitreDocument () {
        return titreDocument;
    }

    public void setTitreDocument ( String titreDocument ) {
        this.titreDocument = titreDocument;
    }

    public String getAuteur () {
        return auteur;
    }

    public void setAuteur ( String auteur ) {
        this.auteur = auteur;
    }

    public String getEditeur () {
        return editeur;
    }

    public void setEditeur ( String editeur ) {
        this.editeur = editeur;
    }

    public Date getDatePublication () {
        return datePublication;
    }

    public void setDatePublication ( Date datePublication ) {
        this.datePublication = datePublication;
    }

    public int getNbPretTotal () {
        return nbPretTotal;
    }

    public void setNbPretTotal ( int nbPretTotal ) {
        this.nbPretTotal = nbPretTotal;
    }

    public int getNbExemplaires () {
        return nbExemplaires;
    }

    public void setNbExemplaires ( int nbExemplaires ) {
        this.nbExemplaires = nbExemplaires;
    }

    public String getLocalisation () {
        return localisation;
    }

    public void setLocalisation ( String localisation ) {
        this.localisation = localisation;
    }

    public String getGenre () {
        return genre;
    }

    public void setGenre ( String genre ) {
        this.genre = genre;
    }
}
