import org.bdd.*;
import org.compte.*;
import org.oeuvre.*;

import java.lang.*;
import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connexion connexion = new Connexion();
        connexion.seConnecter();
        Scanner clavier2 = new Scanner(System.in);
        int choix = 0;
        do {
            System.out.print("1=Ajouter, 0=Quitter ? ");
            choix = clavier2.nextInt();
            if(choix==1) {
                connexion.getMonCompte().ajouterProfil(connexion.getMonCompte().getEmailCompte());
            }
        }
        while(choix==0);
        clavier2.close();
    }
}
