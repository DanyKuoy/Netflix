package org.oeuvre;

import java.awt.*;
import java.util.*;

public class Oeuvre {
    /** Attributs **/
    protected String nomOeuvre;
    protected int anneeOeuvre;
    protected Personne realisateurOeuvre;
    protected ArrayList<Personne> distributionOeuvre;
    protected int classificationOeuvre;
    protected String synopsisOeuvre;
    protected Image imageOeuvre;
    protected String typeOeuvre;                    // Film, Serie, Documentaire
    protected String genreOeuvre;

    /** Constructeur **/
    public Oeuvre(String nomOeuvre, int anneeOeuvre, Personne realisateurOeuvre, int classificationOeuvre, String synopsisOeuvre, Image imageOeuvre, String typeOeuvre, String genreOeuvre) {
        this.nomOeuvre = nomOeuvre;
        this.anneeOeuvre = anneeOeuvre;
        this.realisateurOeuvre = realisateurOeuvre;
        this.classificationOeuvre = classificationOeuvre;
        this.synopsisOeuvre = synopsisOeuvre;
        this.imageOeuvre = imageOeuvre;
        this.typeOeuvre = typeOeuvre;
        this.genreOeuvre = genreOeuvre;
        this.distributionOeuvre = new ArrayList<>();
    }

    /** Getters et setters **/
    public String getNomOeuvre() {
        return nomOeuvre;
    }

    public int getAnneeOeuvre() {
        return anneeOeuvre;
    }

    public Personne getRealisateurOeuvre() {
        return realisateurOeuvre;
    }

    public ArrayList<Personne> getDistributionOeuvre() {
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

    public String getTypeOeuvre() {
        return typeOeuvre;
    }

    public String getGenreOeuvre() {
        return genreOeuvre;
    }

    public void setNomOeuvre(String nomOeuvre) {
        this.nomOeuvre = nomOeuvre;
    }

    public void setAnneeOeuvre(int anneeOeuvre) {
        this.anneeOeuvre = anneeOeuvre;
    }

    public void setRealisateurOeuvre(Personne realisateurOeuvre) {
        this.realisateurOeuvre = realisateurOeuvre;
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

    public void setTypeOeuvre(String typeOeuvre) {
        this.typeOeuvre = typeOeuvre;
    }

    /** Méthodes **/

    /* Méthode permettant d'ajouter une personne à la distribution d'une oeuvre. */
    public void ajouterDistributionOeuvre(Personne personne) {
        this.getDistributionOeuvre().add(personne);
    }

}
