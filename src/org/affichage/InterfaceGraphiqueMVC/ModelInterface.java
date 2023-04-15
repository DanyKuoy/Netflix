package org.affichage.InterfaceGraphiqueMVC;

import org.bdd.Bibliotheque;
import org.oeuvre.Film;
import org.oeuvre.Serie;

import java.util.ArrayList;
import java.util.Map;

public class ModelInterface {

    private Bibliotheque biblio = new Bibliotheque();

    private Map<String, ArrayList<Film>> listeFilm;
    private Map<String, ArrayList<Serie>> listeSerie;

    private ArrayList<Film> Action;
    private ArrayList<Film> Comedie;
    private ArrayList<Film> SciFi;
    private ArrayList<Film> Fantastique;
    private ArrayList<Film> Francais;
    private ArrayList<Film> Policier;
    private ArrayList<Film> Horreur;

    public ModelInterface(){

    }

}
