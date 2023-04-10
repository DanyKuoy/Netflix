package org.bdd;

import org.compte.*;
import org.oeuvre.*;

import java.lang.*;
import java.sql.*;
import java.util.*;

public class Connexion {
    /** Attributs **/
    private String urlBDD;
    private String usernameBDD;
    private String passwordBDD;
    private Compte monCompte;

    /** Constructeur **/
    public Connexion() {
        this.urlBDD = "jdbc:mysql://localhost:3306/ece_(net)flix";
        this.usernameBDD = "root";
        this.passwordBDD = "";
        this.monCompte = null;
    }

    /** Getters et setters **/
    public String getUrlBDD() {
        return urlBDD;
    }

    public String getUsernameBDD() {
        return usernameBDD;
    }

    public String getPasswordBDD() {
        return passwordBDD;
    }

    public Compte getMonCompte() {
        return monCompte;
    }

    public void setMonCompte(Compte monCompte) {
        this.monCompte = monCompte;
    }
}
