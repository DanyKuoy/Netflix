package org.compte;

import java.lang.*;
import java.sql.*;
import java.util.*;

public class Compte {
    /** Attributs **/
    private String prenomCompte;
    private String nomCompte;
    private String emailCompte;
    private String mdpCompte;
    private boolean staff;                  // True=staff, False=client
    private int nbProfil;
    private ArrayList<Profil> listeProfil;


    /** Constructeurs **/
    public Compte() {
        this.listeProfil = new ArrayList<>();
    }

    public Compte(String prenomCompte, String nomCompte, String emailCompte, String mdpCompte, boolean staff) {
        this.prenomCompte = prenomCompte;
        this.nomCompte = nomCompte;
        this.emailCompte = emailCompte;
        this.mdpCompte = mdpCompte;
        this.staff = staff;
        this.nbProfil = 0;
        this.listeProfil = new ArrayList<>();

    }

    /** Getters et setters **/
    public String getPrenomCompte() {
        return prenomCompte;
    }

    public String getNomCompte() {
        return nomCompte;
    }

    public String getEmailCompte() {
        return emailCompte;
    }

    public String getMdpCompte() {
        return mdpCompte;
    }

    public boolean getStaff() {
        return staff;
    }

    public int getNbProfil() {
        return nbProfil;
    }

    public ArrayList<Profil> getListeProfil() {
        return listeProfil;
    }

    public void setPrenomCompte(String prenomCompte) {
        this.prenomCompte = prenomCompte;
    }

    public void setNomCompte(String nomCompte) {
        this.nomCompte = nomCompte;
    }

    public void setEmailCompte(String emailCompte) {
        this.emailCompte = emailCompte;
    }

    public void setMdpCompte(String mdpCompte) {
        this.mdpCompte = mdpCompte;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }

    public void setNbProfil(int nbProfil) {
        this.nbProfil = nbProfil;
    }

    public void setListeProfil(ArrayList<Profil> listeProfil) {
        this.listeProfil = listeProfil;
    }
}
