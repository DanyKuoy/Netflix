package org.bdd;

import org.compte.*;
import org.oeuvre.*;

import java.lang.*;
import java.sql.*;
import java.util.*;

public class Connexion {
    /** Attributs **/
    private Compte monCompte;

    /** Constructeur **/
    public Connexion() {
        this.monCompte = null;
    }

    /** Getters et setters **/
    public Compte getMonCompte() {
        return monCompte;
    }

    public void setMonCompte(Compte monCompte) {
        this.monCompte = monCompte;
    }
}
