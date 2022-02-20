package model;

import java.util.Date;

public class Livre extends Document {
    private int nbDePages;

    public Livre ( int idDocument ,
                   String titreDocment ,
                   String auteur ,
                   String editeur ,
                   Date datePublication ,
                   String genre ,
                   boolean disponible ,
                   int nbDePages ) {
        super( idDocument ,
                titreDocment ,
                auteur ,
                editeur ,
                datePublication ,
                genre ,
                disponible );
        this.nbDePages = nbDePages;
    }

    public int getNbDePages () {
        return nbDePages;
    }

    public void setNbDePages ( int nbDePages ) {
        this.nbDePages = nbDePages;
    }
}
