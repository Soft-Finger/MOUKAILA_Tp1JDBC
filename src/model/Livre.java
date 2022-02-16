package model;

import java.util.Date;

public class Livre extends Document {
    private String editeur;
    private Date anneeDePublication;
    private int nbDePage;


    public Livre ( int documentId , String titre , String auteur , String editeur , Date anneeDePublication , int nbDePage ) {
        super( documentId , titre , auteur );
        this.editeur = editeur;
        this.anneeDePublication = anneeDePublication;
        this.nbDePage = nbDePage;
    }

    public String getEditeur () {
        return editeur;
    }

    public void setEditeur ( String editeur ) {
        this.editeur = editeur;
    }

    public Date getAnneeDePublication () {
        return anneeDePublication;
    }

    public void setAnneeDePublication ( Date anneeDePublication ) {
        this.anneeDePublication = anneeDePublication;
    }

    public int getNbDePage () {
        return nbDePage;
    }

    public void setNbDePage ( int nbDePage ) {
        this.nbDePage = nbDePage;
    }

    @Override
    public String toString () {
        return "Livre{" +
                "documentId=" + documentId +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", anneeDePublication=" + anneeDePublication +
                ", nbDePage=" + nbDePage +
                '}';
    }
}
