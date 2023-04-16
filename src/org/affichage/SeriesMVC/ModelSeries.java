package org.affichage.SeriesMVC;

import org.bdd.Bibliotheque;
import org.dao.BibliothequeDAO;
import org.oeuvre.Film;
import org.oeuvre.Serie;
import org.compte.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModelSeries {

    private Compte compte;
    private int profil;
    private Bibliotheque biblio = new Bibliotheque();
    private BibliothequeDAO biblioDAO = new BibliothequeDAO();

    public ModelSeries(Compte compte, int profil){
        biblio.setListeSerie(biblioDAO.chargerSeries());
        Map<String, ArrayList<Serie>> map = new HashMap<>();
        map = biblio.trierSeries();
        biblio.setTriSerie(map);
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
