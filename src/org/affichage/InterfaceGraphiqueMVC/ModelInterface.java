package org.affichage.InterfaceGraphiqueMVC;

import org.bdd.Bibliotheque;
import org.oeuvre.Film;
import org.oeuvre.Serie;
import org.compte.*;

import java.util.ArrayList;
import java.util.Map;

public class ModelInterface {

    private Bibliotheque biblio = new Bibliotheque();

    private Map<String, ArrayList<Film>> listeFilm;
    private Map<String, ArrayList<Serie>> listeSerie;

    private Compte compte;

    private int profil;

    public ModelInterface(Compte compte, int profil){
        this.compte = compte;
        this.profil = profil;
    }

    public Compte getCompte(){
        return compte;
    }

    public void setCompte(Compte compte){
        this.compte = compte;
    }

    public int getProfil(){
        return profil;
    }
}
