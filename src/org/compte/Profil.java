package org.compte;

import org.oeuvre.*;

import java.lang.*;
import java.util.*;

public class Profil {
    /** Attributs **/
    private String prenomProfil;
    private boolean restrictionAge;
    private boolean repriseVideo;
    private int qualiteVideo;
    private String sousTitres;
    private ArrayList<Oeuvre> listeReprise;
    private ArrayList<Oeuvre> listeFavoris;
    private Stack<Oeuvre> historique;

    /** Constructeur **/
    public Profil(String prenomProfil, boolean restrictionAge, boolean repriseVideo, int qualiteVideo, String sousTitres) {
        this.prenomProfil = prenomProfil;
        this.restrictionAge = restrictionAge;
        this.repriseVideo = repriseVideo;
        this.qualiteVideo = qualiteVideo;
        this.sousTitres = sousTitres;
        this.listeReprise = new ArrayList<>();
        this.listeFavoris = new ArrayList<>();
        this.historique = new Stack<>();
    }

    /** Getters et setters **/
    public String getPrenomProfil() {
        return prenomProfil;
    }

    public boolean getRestrictionAge() {
        return restrictionAge;
    }

    public boolean getRepriseVideo() {
        return repriseVideo;
    }

    public int getQualiteVideo() {
        return qualiteVideo;
    }

    public String getSousTitres() {
        return sousTitres;
    }

    public ArrayList<Oeuvre> getListeReprise() {
        return listeReprise;
    }

    public ArrayList<Oeuvre> getListeFavoris() {
        return listeFavoris;
    }

    public Stack<Oeuvre> getHistorique() {
        return historique;
    }

    public void setPrenomProfil(String prenomProfil) {
        this.prenomProfil = prenomProfil;
    }

    public void setRestrictionAge(boolean restrictionAge) {
        this.restrictionAge = restrictionAge;
    }

    public void setRepriseVideo(boolean repriseVideo) {
        this.repriseVideo = repriseVideo;
    }

    public void setQualiteVideo(int qualiteVideo) {
        this.qualiteVideo = qualiteVideo;
    }

    public void setSousTitres(String sousTitres) {
        this.sousTitres = sousTitres;
    }

    /** Méthodes **/

    /* Méthode permettant d'ajouter une oeuvre à la liste de reprise de lecture.
    Avec le polymorphisme, on peut passer en paramètre un objet de la classe Film, Serie ou Documentaire. */
    public void ajouterListeReprise(Oeuvre newOeuvre) {
        this.getListeReprise().add(newOeuvre);
    }


    /* Méthode permettant d'ajouter une oeuvre à la liste de favoris de lecture.
    Avec le polymorphisme, on peut passer en paramètre un objet de la classe Film, Serie ou Documentaire. */
    public void ajouterListeFavoris(Oeuvre newOeuvre) {
        this.getListeFavoris().add(newOeuvre);
    }

    /* Méthode permettant de supprimer une oeuvre à la liste de reprise de lecture. */
    public void supprimerListeReprise(Oeuvre newOeuvre) {
        /// Parcours de la liste
        for(int i=0; i<this.getListeReprise().size(); i++) {
            if(this.getListeReprise().get(i).getNomOeuvre().equals(newOeuvre)) {
                this.getListeReprise().remove(i);
            }
        }
    }

    /* Méthode permettant de supprimer une oeuvre à la liste de favoris de lecture. */
    public void supprimerListeFavoris(Oeuvre newOeuvre) {
        /// Parcours de la liste
        for(int i=0; i<this.getListeFavoris().size(); i++) {
            if(this.getListeFavoris().get(i).getNomOeuvre().equals(newOeuvre)) {
                this.getListeFavoris().remove(i);
            }
        }
    }

}
