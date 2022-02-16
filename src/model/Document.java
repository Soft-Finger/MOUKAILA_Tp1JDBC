package model;

public class Document {

    protected int documentId;
    protected String titre;
    protected String auteur;

    public Document ( int documentId , String titre , String auteur ) {
        this.documentId = documentId;
        this.titre = titre;
        this.auteur = auteur;
    }

    public int getDocumentId () {
        return documentId;
    }

    public void setDocumentId ( int documentId ) {
        this.documentId = documentId;
    }

    public String getTitre () {
        return titre;
    }

    public void setTitre ( String titre ) {
        this.titre = titre;
    }

    public String getAuteur () {
        return auteur;
    }

    public void setAuteur ( String auteur ) {
        this.auteur = auteur;
    }

    @Override
    public String toString () {
        return "Document{" +
                "documentId=" + documentId +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }
}
