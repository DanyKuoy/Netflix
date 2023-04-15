package org.oeuvre;

import java.awt.*;
import java.util.*;
import java.lang.*;

public class Film extends Oeuvre{
    /** Attributs **/
    private int dureeFilm;
    private int idFilm;
    private String lienFilm;

    /** Constructeur **/
    public Film(String nomOeuvre, int anneeOeuvre, String realisateurOeuvre, String distributionOeuvre, int classificationOeuvre, String synopsisOeuvre, String genreOeuvre, float noteOeuvre, int dureeFilm, int idFilm, String lienFilm) {
        super(nomOeuvre, anneeOeuvre, realisateurOeuvre, distributionOeuvre, classificationOeuvre, synopsisOeuvre, genreOeuvre, noteOeuvre);
        this.dureeFilm = dureeFilm;
        this.idFilm = idFilm;
        this.lienFilm = lienFilm;
    }

    /** Getters et Setters **/
    public int getDureeFilm() {
        return dureeFilm;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public String getLienFilm() {
        return lienFilm;
    }

    public void setDureeFilm(int dureeFilm) {
        this.dureeFilm = dureeFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public void setLienFilm(String lienFilm) {
        this.lienFilm = lienFilm;
    }


}
