package org.affichage.MenuStaffMVC;

import org.compte.Compte;

public class ModelStaff {

    private Compte compte;
    int profil;

public ModelStaff(Compte compte, int profil){
    this.compte = compte;
    this.profil = profil;
}

public Compte getCompte(){
    return compte;
}
    public int getProfil(){
        return profil;
    }


}
