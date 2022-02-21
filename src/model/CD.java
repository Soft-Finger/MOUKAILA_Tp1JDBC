package model;

import java.util.Date;

public class CD extends Document {
    private int duree;

    public CD ( int idDocument ,
                String titreDocment ,
                String auteur ,
                String editeur ,
                Date datePublication ,
                String genre ,
                boolean disponible ,
                int duree ) {
        super( idDocument ,
                titreDocment ,
                auteur ,
                editeur ,
                datePublication ,
                genre ,
                disponible );
        this.duree = duree;
    }

    public int getDuree () {
        return duree;
    }
}
