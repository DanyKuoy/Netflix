package org.compte;

import java.lang.*;

public class Compte {
    /** Attributs **/
    private String prenomCompte;
    private String nomCompte;
    private String emailCompte;
    private String mdpCompte;
    private boolean staff;                  // True=staff, False=client

    /** Constructeur **/
    public Compte(String prenomCompte, String nomCompte, String emailCompte, String mdpCompte, boolean staff) {
        this.prenomCompte = prenomCompte;
        this.nomCompte = nomCompte;
        this.emailCompte = emailCompte;
        this.mdpCompte = mdpCompte;
        this.staff = staff;
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
}
