package org.bdd;

import org.oeuvre.*;

import java.util.*;
import java.lang.*;

public class Bibliotheque {
    /** Attributs **/
    private ArrayList<Film> listeFilm;
    private ArrayList<Serie> listeSerie;
    private Map<String, ArrayList<Film>> triFilm;
    private Map<String, ArrayList<Serie>> triSerie;

    /** Constructeur **/
    public Bibliotheque() {
        this.listeFilm = new ArrayList<>();
        this.listeSerie = new ArrayList<>();
        this.triFilm =  new HashMap<>();
        this.triSerie = new HashMap<>();
    }

    /** Getters et setters **/
    public ArrayList<Film> getListeFilm() {
        return listeFilm;
    }

    public ArrayList<Serie> getListeSerie() {
        return listeSerie;
    }

    public Map<String, ArrayList<Film>> getTriFilm() {
        return triFilm;
    }

    public Map<String, ArrayList<Serie>> getTriSerie() {
        return triSerie;
    }

    public void setListeFilm(ArrayList<Film> listeFilm) {
        this.listeFilm = listeFilm;
    }

    public void setListeSerie(ArrayList<Serie> listeSerie) {
        this.listeSerie = listeSerie;
    }

    public void setTriFilm(Map<String, ArrayList<Film>> triFilm) {
        this.triFilm = triFilm;
    }

    public void setTriSerie(Map<String, ArrayList<Serie>> triSerie) {
        this.triSerie = triSerie;
    }

    /** Méthodes **/

    /* Méthodes permettant de trier les films selon le genre */
    public Map<String, ArrayList<Film>> trierFilms() {
        /// Déclaration de variables
        Map<String, ArrayList<Film>> listeTrie = new HashMap<>();

        /// Tri des films
        for(int i=0; i<this.getListeFilm().size(); i++) {
            /// Récupération des genres du film
            String[] genres = this.getListeFilm().get(i).getGenreOeuvre().split(", ");
            for(String genre: genres) {
                if(!listeTrie.containsKey(genre)) {                     // Si le genre n'a pas encore été créé, on créé une liste pour le genre
                    listeTrie.put(genre, new ArrayList<>());
                }
                listeTrie.get(genre).add(this.getListeFilm().get(i));
            }
        }
        return listeTrie;
    }

    /* Méthodes permettant de trier les series selon le genre */
    public Map<String, ArrayList<Serie>> trierSeries() {
        /// Déclaration de variables
        Map<String, ArrayList<Serie>> listeTrie = new HashMap<>();

        /// Tri des séries
        for(int i=0; i<this.getListeSerie().size(); i++) {
            /// Récupération des genres du séries
            String[] genres = this.getListeSerie().get(i).getGenreOeuvre().split(", ");
            for(String genre: genres) {
                if(!listeTrie.containsKey(genre)) {                     // Si le genre n'a pas encore été créé, on créé une liste pour le genre
                    listeTrie.put(genre, new ArrayList<>());
                }
                listeTrie.get(genre).add(this.getListeSerie().get(i));
            }
        }
        return listeTrie;
    }

    /* Méthode permettant de réaliser une recherche d'oeuvre par son titre */
    public ArrayList<Oeuvre> rechercheTitre(String nom) {
        /// Déclaration de variable
        ArrayList<Oeuvre> listeRecherche = new ArrayList<>();

        /// Recherche dans la liste des films
        for(int i=0; i<this.getListeFilm().size(); i++) {
            if(this.getListeFilm().get(i).getNomOeuvre().toLowerCase().contains(nom.toLowerCase())) {
                listeRecherche.add(this.getListeFilm().get(i));
            }
        }

        /*
        /// Recherche dans la liste des series
        for(int j=0; j<this.getListeSerie().size(); j++) {
            if(this.getListeSerie().get(j).getNomOeuvre().toLowerCase().contains(nom.toLowerCase())) {
                listeRecherche.add(this.getListeSerie().get(j));
            }
        }
        */

        return listeRecherche;
    }

    /* Méthode permettant de réaliser une recherche d'oeuvre par son titre */
    public boolean rechercheTitre(String nom, ArrayList<Oeuvre> listeRecherche) {
        /// Déclaration de variable
        int nbOeuvre = 0;

        /// Recherche dans la liste des films
        for(int i=0; i<this.getListeFilm().size(); i++) {
            if(this.getListeFilm().get(i).getNomOeuvre().toLowerCase().contains(nom.toLowerCase())) {
                listeRecherche.add(this.getListeFilm().get(i));
                nbOeuvre++;
            }
        }

        /// Recherche dans la liste des series
        for(int j=0; j<this.getListeSerie().size(); j++) {
            if(this.getListeSerie().get(j).getNomOeuvre().toLowerCase().contains(nom.toLowerCase())) {
                listeRecherche.add(this.getListeSerie().get(j));
                nbOeuvre++;
            }
        }

        /// Retourner un booléen selon le nombre d'oeuvres trouvé
        if(nbOeuvre==0) {
            return true;
        }
        else {
            return false;
        }
    }

    /* Méthode permettant de réaliser une recherche d'oeuvre par son réalisateur*/
    public boolean rechercheRealisateur(String nom, ArrayList<Oeuvre> listeRecherche) {
        /// Déclaration de variable
        int nbOeuvre = 0;

        /// Recherche dans la liste des films
        for(int i=0; i<this.getListeFilm().size(); i++) {
            if(this.getListeFilm().get(i).getRealisateurOeuvre().toLowerCase().contains(nom.toLowerCase())) {
                listeRecherche.add(this.getListeFilm().get(i));
                nbOeuvre++;
            }
        }

        /// Recherche dans la liste des series
        for(int j=0; j<this.getListeSerie().size(); j++) {
            if(this.getListeSerie().get(j).getRealisateurOeuvre().contains(nom.toLowerCase())) {
                listeRecherche.add(this.getListeSerie().get(j));
                nbOeuvre++;
            }
        }

        /// Retourner un booléen selon le nombre d'oeuvres trouvé
        if(nbOeuvre==0) {
            return true;
        }
        else {
            return false;
        }
    }

    /* Méthode permettant de réaliser une recherche d'oeuvre selon un acteur/une actrice*/
    public boolean rechercheActeur(String nom, ArrayList<Oeuvre> listeRecherche) {
        /// Déclaration de variable
        int nbOeuvre = 0;

        /// Recherche dans la liste des films
        for(int i=0; i<this.getListeFilm().size(); i++) {
            /// Récupération des acteurs/actrices du film
            String[] distribution1 = this.getListeFilm().get(i).getDistributionOeuvre().split(", ");
            for(String acteur: distribution1) {
                if(acteur.toLowerCase().contains(nom.toLowerCase())) {
                    listeRecherche.add(this.getListeFilm().get(i));
                    nbOeuvre++;
                }
            }
        }

        /// Recherche dans la liste des series
        for(int j=0; j<this.getListeSerie().size(); j++) {
            /// Récupération des acteurs/actrices du film
            String[] distribution2 = this.getListeSerie().get(j).getDistributionOeuvre().split(", ");
            for(String acteur: distribution2) {
                if(acteur.toLowerCase().contains(nom.toLowerCase())) {
                    listeRecherche.add(this.getListeSerie().get(j));
                    nbOeuvre++;
                }
            }
        }

        /// Retourner un booléen selon le nombre d'oeuvres trouvé
        if(nbOeuvre==0) {
            return true;
        }
        else {
            return false;
        }
    }

    /* Méthode permettant de rechercher des oeuvres selon un genre donné */
    public boolean rechercheGenre(String nom, ArrayList<Oeuvre> listeRecherche) {
        /// Déclaration de variable
        int nbOeuvre = 0;

        /// Recherche dans la map des films


        /// Recherche dans la map des series


        /// Retourner un booléen selon le nombre d'oeuvres trouvé
        if(nbOeuvre==0) {
            return true;
        }
        else {
            return false;
        }
    }
}
