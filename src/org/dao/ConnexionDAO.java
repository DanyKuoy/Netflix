package org.dao;

import org.compte.*;
import org.oeuvre.*;

import java.lang.*;
import java.sql.*;
import java.util.*;

public class ConnexionDAO {
    /** Attributs **/
    private String urlBDD;
    private String usernameBDD;
    private String passwordBDD;

    /** Constructeur **/
    public ConnexionDAO() {
        this.urlBDD = "jdbc:mysql://localhost:3306/ece_(net)flix";
        this.usernameBDD = "root";
        this.passwordBDD = "";
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

    /** Méthodes **/

    /* Méthode permettant de se connecter à un compte.
    La méthode passe en paramètre l'email et le mot de passe. Elle retourne un compte */
    public Compte seConnecter(String ID, String MDP) {
        /// Creation d'objets et de variables

        boolean trouve = false;
        Compte compte = new Compte();
        do {
            try {
                /// Communication avec la base de données
                Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
                Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
                String sql = "SELECT * FROM compte";                                                                                        // Ecriture de la requête SQL
                Statement statement =  connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                /// Recherche du compte
                while(result.next()) {
                    System.out.println("Test : " + ID + MDP);
                    System.out.println(result.getString("emailCompte") + result.getString("mdpCompte"));
                    if(result.getString("emailCompte").equals(ID) && result.getString("mdpCompte").equals(MDP)) {    // Si le compte a été trouvé
                        trouve = true;
                        System.out.println("Compte trouvé");

                        /// Création du compte à retourner
                        compte.setPrenomCompte(result.getString("prenomCompte"));
                        compte.setNomCompte(result.getString("nomCompte"));
                        compte.setEmailCompte(result.getString("emailCompte"));
                        compte.setMdpCompte(result.getString("mdpCompte"));
                        compte.setStaff(result.getBoolean("staff"));
                    }
                }
                if(trouve==false) {
                    System.out.println("Erreur dans l'email ou le mot de passe!");
                }
                connection.close();             // Fermeture de la connexion à la BDD
            }
            catch(ClassNotFoundException e) {
                System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
            }
            catch(SQLException e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        }
        while(trouve==false);
        return compte;
    }

    /* Méthode permettant de créer un compte dans la base de données */
    public void creerCompte(String prenom, String nom, String email, String mdp, int isstaff) {
        Scanner clavier = new Scanner(System.in);

        try {
            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            PreparedStatement statement = connection.prepareStatement("INSERT INTO compte(prenomCompte, nomCompte, emailCompte, mdpCompte, staff) VALUES (?, ?, ?, ?, ?)");                                                                                     // Ecriture de la requête SQL
            statement.setString(1, prenom);
            statement.setString(2, nom);
            statement.setString(3, email);
            statement.setString(4, mdp);
            statement.setInt(5, isstaff);
            statement.executeUpdate();
            clavier.close();
            connection.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
}
