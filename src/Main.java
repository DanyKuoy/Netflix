import org.bdd.*;
import org.compte.*;
import org.oeuvre.*;

import java.lang.*;
import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connexion connexion = new Connexion();
        Scanner clavier = new Scanner(System.in);
        Compte compte = connexion.seConnecter(clavier);
        connexion.setMonCompte(compte);
        connexion.getMonCompte().supprimerProfil(clavier, connexion.getMonCompte().getEmailCompte());
        clavier.close();
    }
}
