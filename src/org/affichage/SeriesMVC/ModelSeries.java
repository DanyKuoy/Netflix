package org.affichage.SeriesMVC;

import org.bdd.Bibliotheque;
import org.dao.BibliothequeDAO;
import org.oeuvre.Film;
import org.oeuvre.Serie;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModelSeries {

    private Bibliotheque biblio = new Bibliotheque();
    private BibliothequeDAO biblioDAO = new BibliothequeDAO();

    public ModelSeries(){
        biblio.setListeSerie(biblioDAO.chargerSeries());
        Map<String, ArrayList<Serie>> map = new HashMap<>();
        map = biblio.trierSeries();
        biblio.setTriSerie(map);
    }

    public Bibliotheque getBiblio(){
        return biblio;
    }


}
