package org.affichage.InterfaceGraphiqueMVC;

import org.bdd.Bibliotheque;
import org.dao.BibliothequeDAO;
import org.oeuvre.Film;
import org.oeuvre.Serie;
import org.compte.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModelInterface {

    private Compte compte;

    private Bibliotheque biblio = new Bibliotheque();

    private Map<String, ArrayList<Film>> listeFilm;
    private Film[][] ListeTrideFilms = new Film[30][20];
    private Map<String, ArrayList<Serie>> listeSerie;
    private Serie[][] ListeTrideSerie = new Serie[30][15];

    private String[][] liens = new String[30][30];
    private String[][] liensSerie = new String[30][30];

    private BibliothequeDAO biblioDAO = new BibliothequeDAO();

    private int profil;

    public ModelInterface(Compte compte, int profil){

        biblio.setListeFilm(biblioDAO.chargerFilms());

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

        biblio.setListeSerie(biblioDAO.chargerSeries());
        biblio.setTriSerie(biblio.trierSeries());
        j=0;
        for(String cle: biblio.getTriSerie().keySet()) {
            ArrayList<Serie> listeserie = biblio.getTriSerie().get(cle);
            System.out.println("GENRE: " + cle + j);
            for(int i=0; i<listeserie.size(); i++) {
                liensSerie[i][j] = listeserie.get(i).getNomOeuvre();
                ListeTrideSerie[i][j] = listeserie.get(i);
            }
            j++;
        }

        this.compte = compte;
        this.profil = profil;

    }


    public Film getOeuvre(int i, int j){
        return ListeTrideFilms[i][j];
    }
    public Serie getSerie(int i, int j){return ListeTrideSerie[i][j];}
    public Map<String, ArrayList<Film>> getlisteFilm(){
        return listeFilm;
    }
    public Map<String, ArrayList<Serie>> getlisteSerie(){
        return listeSerie;
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
    public String[][] getLiensSerie(){
        return liensSerie;
    }

    public int getProfil(){
        return profil;
    }
}
