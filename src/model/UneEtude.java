package model;

import java.util.Date;

public class UneEtude extends Livre {

    public UneEtude ( int documentId , String titre , String auteur ,
                      String editeur , Date anneeDePublication , int nbDePage ) {
        super( documentId , titre , auteur , editeur , anneeDePublication , nbDePage );
    }
}
