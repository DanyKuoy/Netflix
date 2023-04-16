package org.affichage.RechercheMVC;

import org.bdd.Bibliotheque;
import org.compte.Compte;
import org.dao.BibliothequeDAO;
import org.oeuvre.Film;
import org.oeuvre.Oeuvre;
import org.oeuvre.Serie;

import java.util.ArrayList;
import java.util.Map;

public class ModelRecherche{

    private Compte compte;

    private int profil;
    Bibliotheque biblio = new Bibliotheque();
    BibliothequeDAO biblioDAO = new BibliothequeDAO();

    public ModelRecherche(Compte compte, int profil){

        biblio.setListeFilm(biblioDAO.chargerFilms());
        biblio.setListeSerie(biblioDAO.chargerSeries());

        this.compte = compte;
        this.profil = profil;

    }


    public Bibliotheque getBiblio(){
        return biblio;
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

