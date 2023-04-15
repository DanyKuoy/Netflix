package org.affichage.RechercheMVC;

import org.compte.Compte;

public class ModelRecherche {

    private Compte compte;

    public ModelRecherche(){

    }

    public Compte getCompte(){
        return compte;
    }

    public void setCompte(Compte compte){
        this.compte = compte;
    }

}
