package org.affichage.FilmsMVC;

import org.bdd.Bibliotheque;
import org.oeuvre.Film;

import java.util.ArrayList;
import java.util.Map;

public class ModelFilms {

    private Bibliotheque biblio = new Bibliotheque();

    private Map<String, ArrayList<Film>> listeFilm;

    private ArrayList<Film> Action;
    private ArrayList<Film> Comedie;
    private ArrayList<Film> SciFi;
    private ArrayList<Film> Fantastique;
    private ArrayList<Film> Francais;
    private ArrayList<Film> Policier;
    private ArrayList<Film> Horreur;

    public ModelFilms(){

    }

}
