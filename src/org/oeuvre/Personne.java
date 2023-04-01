package org.oeuvre;

import java.lang.*;

public class Personne {
    /** Attributs **/
    private String nomPersonne;
    private String prenomPersonne;

    /** Constructeur **/
    public Personne(String nomPersonne, String prenomPersonne) {
        this.nomPersonne = nomPersonne;
        this.prenomPersonne = prenomPersonne;
    }

    /** Getters et setters **/
    public String getNomPersonne() {
        return nomPersonne;
    }

    public String getPrenomPersonne() {
        return prenomPersonne;
    }

    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    public void setPrenomPersonne(String prenomPersonne) {
        this.prenomPersonne = prenomPersonne;
    }
}
