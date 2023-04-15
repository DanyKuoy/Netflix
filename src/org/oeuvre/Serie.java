package org.oeuvre;

import java.awt.*;
import java.util.*;
import java.lang.*;

public class Serie extends Oeuvre{
    /** Attributs **/
    private int nbSaisons;
    private int idSerie;
    private ArrayList<ArrayList<Episode>> listeEpisodes;

    /** Constructeur **/
    public Serie(String nomOeuvre, int anneeOeuvre, String realisateurOeuvre, String distributionOeuvre, int classificationOeuvre, String synopsisOeuvre, Image imageOeuvre, String genreOeuvre, float noteOeuvre, int nbSaisons, int idSerie) {
        super(nomOeuvre, anneeOeuvre, realisateurOeuvre, distributionOeuvre, classificationOeuvre, synopsisOeuvre, imageOeuvre, genreOeuvre, noteOeuvre);
        this.nbSaisons = nbSaisons;
        this.idSerie = idSerie;
        this.listeEpisodes = new ArrayList<ArrayList<Episode>>();
    }

    /** Getters et setters **/
    public int getNbSaisons() {
        return nbSaisons;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public ArrayList<ArrayList<Episode>> getListeEpisodes() {
        return listeEpisodes;
    }

    public void setNbSaisons(int nbSaisons) {
        this.nbSaisons = nbSaisons;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public void setListeEpisodes(ArrayList<ArrayList<Episode>> listeEpisodes) {
        this.listeEpisodes = listeEpisodes;
    }
}
