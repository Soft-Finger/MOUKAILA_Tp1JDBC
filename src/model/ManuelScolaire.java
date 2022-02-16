package model;

import java.util.Date;

public class ManuelScolaire extends Livre {

    public ManuelScolaire ( int documentId , String titre , String auteur ,
                            String editeur , Date anneeDePublication , int nbDePage ) {
        super( documentId , titre , auteur , editeur , anneeDePublication , nbDePage );
    }
}
