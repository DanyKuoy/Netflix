package org.oeuvre;

import java.awt.*;
import java.net.*;
import java.util.*;

public class Oeuvre {
    /** Attributs **/
    protected String nomOeuvre;
    protected int anneeOeuvre;
    protected String realisateurOeuvre;
    protected String distributionOeuvre;
    protected int classificationOeuvre;
    protected String synopsisOeuvre;
    protected Image imageOeuvre;
    protected String genreOeuvre;
    protected float noteOeuvre;

    /** Constructeur **/
    public Oeuvre(String nomOeuvre, int anneeOeuvre, String realisateurOeuvre, String distributionOeuvre, int classificationOeuvre, String synopsisOeuvre, Image imageOeuvre, String genreOeuvre, float noteOeuvre) {
        this.nomOeuvre = nomOeuvre;
        this.anneeOeuvre = anneeOeuvre;
        this.realisateurOeuvre = realisateurOeuvre;
        this.distributionOeuvre = distributionOeuvre;
        this.classificationOeuvre = classificationOeuvre;
        this.synopsisOeuvre = synopsisOeuvre;
        this.imageOeuvre = imageOeuvre;
        this.genreOeuvre = genreOeuvre;
        this.noteOeuvre = noteOeuvre;
    }

    /** Getters et setters **/
    public String getNomOeuvre() {
        return nomOeuvre;
    }

    public int getAnneeOeuvre() {
        return anneeOeuvre;
    }

    public String getRealisateurOeuvre() {
        return realisateurOeuvre;
    }

    public String getDistributionOeuvre() {
        return distributionOeuvre;
    }

    public int getClassificationOeuvre() {
        return classificationOeuvre;
    }

    public String getSynopsisOeuvre() {
        return synopsisOeuvre;
    }

    public Image getImageOeuvre() {
        return imageOeuvre;
    }

    public String getGenreOeuvre() {
        return genreOeuvre;
    }

    public float getNoteOeuvre() {
        return noteOeuvre;
    }

    public void setNomOeuvre(String nomOeuvre) {
        this.nomOeuvre = nomOeuvre;
    }

    public void setAnneeOeuvre(int anneeOeuvre) {
        this.anneeOeuvre = anneeOeuvre;
    }

    public void setRealisateurOeuvre(String realisateurOeuvre) {
        this.realisateurOeuvre = realisateurOeuvre;
    }

    public void setDistributionOeuvre(String distributionOeuvre) {
        this.distributionOeuvre = distributionOeuvre;
    }

    public void setClassificationOeuvre(int classificationOeuvre) {
        this.classificationOeuvre = classificationOeuvre;
    }

    public void setSynopsisOeuvre(String synopsisOeuvre) {
        this.synopsisOeuvre = synopsisOeuvre;
    }

    public void setImageOeuvre(Image imageOeuvre) {
        this.imageOeuvre = imageOeuvre;
    }

    public void setGenreOeuvre(String genreOeuvre) {
        this.genreOeuvre = genreOeuvre;
    }

    public void setNoteOeuvre(float noteOeuvre) {
        this.noteOeuvre = noteOeuvre;
    }
}
