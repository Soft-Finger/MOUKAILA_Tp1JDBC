package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Document {
    private int idDocument;
    private String titreDocument;
    private String auteur;
    private String editeur;
    private Date datePublication;
    private  String genre;
    private boolean disponible;
    private List<Document> listeDocument = new ArrayList<>();

    public Document () {
    }

    public Document ( int idDocument ,
                      String titreDocment ,
                      String auteur ,
                      String editeur ,
                      Date datePublication ,
                      String genre,
                      boolean disponible ) {
        this.idDocument = idDocument;
        this.titreDocument = titreDocment;
        this.auteur = auteur;
        this.editeur = editeur;
        this.datePublication = datePublication;
        this.genre = genre;
        this.disponible = disponible;
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

    public String getGenre () {
        return genre;
    }

    public void setGenre ( String genre ) {
        this.genre = genre;
    }
}
