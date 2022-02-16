package model;

import java.util.Date;

public class Magazine extends Livre{
    public Magazine ( int documentId , String titre , String auteur , String editeur , Date anneeDePublication , int nbDePage ) {
        super( documentId , titre , auteur , editeur , anneeDePublication , nbDePage );
    }
}
