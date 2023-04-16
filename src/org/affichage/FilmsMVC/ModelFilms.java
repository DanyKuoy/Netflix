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
    private Film[][] ListeTrideFilms = new Film[30][16];

    private String[][] liens = new String[30][30];

    private BibliothequeDAO biblioDAO = new BibliothequeDAO();

    private int profil;

    public ModelFilms(Compte compte, int profil){

        biblio.setListeFilm(biblioDAO.chargerFilms());
        //b1.setListeSerie(b.chargerSeries());

        Map<String, ArrayList<Film>> listeTrie = new HashMap<>();

        /// Tri des films
        biblio.setTriFilm(biblio.trierFilms());

        int j=0;

        /// Affichage
        for(String cle: biblio.getTriFilm().keySet()) {
            ArrayList<Film> listefilm = biblio.getTriFilm().get(cle);
            System.out.println("GENRE: " + cle + j);
            for(int i=0; i<listefilm.size(); i++) {
                liens[i][j] = listefilm.get(i).getNomOeuvre();
                ListeTrideFilms[i][j] = listefilm.get(i);
            }
            j++;
            System.out.println(listefilm.size());
            System.out.println("---------------------------------");
        }

        this.compte = compte;
        this.profil = profil;

    }


    public Film getOeuvre(int i, int j){
        return ListeTrideFilms[i][j];
    }
    public Map<String, ArrayList<Film>> getlisteFilm(){
        return listeFilm;
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

    public int getProfil(){
        return profil;
    }

}
