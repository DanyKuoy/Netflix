package org.affichage.FilmsMVC;

import org.bdd.Bibliotheque;
import org.compte.Compte;
import org.dao.BibliothequeDAO;
import org.oeuvre.Film;
import org.oeuvre.Serie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModelFilms {

    private Compte compte;

    private Bibliotheque biblio = new Bibliotheque();

    private Map<String, ArrayList<Film>> listeFilm;

    private String[][] liens = new String[30][30];

    private BibliothequeDAO biblioDAO = new BibliothequeDAO();

    public ModelFilms(){

        biblio.setListeFilm(biblioDAO.chargerFilms());
        //b1.setListeSerie(b.chargerSeries());

        Map<String, ArrayList<Film>> listeTrie = new HashMap<>();

        /// Tri des films
        biblio.setTriFilm(biblio.trierFilms());

        int j=0;

        /// Affichage
        for(String cle: biblio.getTriFilm().keySet()) {
            ArrayList<Film> listefilm = biblio.getTriFilm().get(cle);
            System.out.println("GENRE: " + cle);
            for(int i=0; i<listefilm.size(); i++) {
                liens[i][j] = listefilm.get(i).getNomOeuvre();
                System.out.println(liens[i][j]);
            }
            j++;
            System.out.println("------------------------------------------");
        }

    }



    public Compte getCompte(){
        return compte;
    }

    public void setCompte(Compte compte){
        this.compte = compte;
    }

    public String[][] getLiens(){
        return liens;
    }

}
