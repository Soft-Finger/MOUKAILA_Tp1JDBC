package model;

import javax.print.Doc;
import java.util.Date;

public class Dvd extends Document {
    private int duree;

    public Dvd ( int idDocument ,
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
}
