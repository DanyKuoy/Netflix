package org.oeuvre;

import java.awt.*;
import java.util.*;
import java.lang.*;

public class Episode {
    /** Attributs **/
    private String idSerie;
    private int numeroSaison;
    private int numeroEpisode;
    private int dureeEpisode;
    private String lienEpisode;
    private String titreEpisode;

    /** Constructeur **/
    public Episode(String idSerie, int numeroSaison, int numeroEpisode, int dureeEpisode, String lienEpisode, String titreEpisode) {
        this.idSerie = idSerie;
        this.numeroSaison = numeroSaison;
        this.numeroEpisode = numeroEpisode;
        this.dureeEpisode = dureeEpisode;
        this.lienEpisode = lienEpisode;
        this.titreEpisode = titreEpisode;
    }

    /** Getters et setters **/
    public String getIdSerie() {
        return idSerie;
    }

    public int getNumeroSaison() {
        return numeroSaison;
    }

    public int getNumeroEpisode() {
        return numeroEpisode;
    }

    public int getDureeEpisode() {
        return dureeEpisode;
    }

    public String getLienEpisode() {
        return lienEpisode;
    }

    public String getTitreEpisode() {
        return titreEpisode;
    }

    public void setIdSerie(String idSerie) {
        this.idSerie = idSerie;
    }

    public void setNumeroSaison(int numeroSaison) {
        this.numeroSaison = numeroSaison;
    }

    public void setNumeroEpisode(int numeroEpisode) {
        this.numeroEpisode = numeroEpisode;
    }

    public void setDureeEpisode(int dureeEpisode) {
        this.dureeEpisode = dureeEpisode;
    }

    public void setLienEpisode(String lienEpisode) {
        this.lienEpisode = lienEpisode;
    }

    public void setTitreEpisode(String titreEpisode) {
        this.titreEpisode = titreEpisode;
    }
}
