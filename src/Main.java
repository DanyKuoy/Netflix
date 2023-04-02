import org.bdd.*;
import org.compte.*;
import org.oeuvre.*;

import java.lang.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connexion connexion = new Connexion();
        connexion.creerCompte();
    }
}
