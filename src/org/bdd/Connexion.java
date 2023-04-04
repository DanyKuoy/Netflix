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

    /** Méthodes **/
    /* Méthode permettant de se connecter à un compte.
    La méthode passe en paramètre l'email et le mot de passe. Elle retourne un compte */
    public Compte seConnecter(Scanner clavier) {
        /// Creation d'objets et de variables
        boolean trouve = false;
        Compte compte = new Compte();

        do {
            try {
                /// Saisie de l'utilisateur
                System.out.print("Saisir l'email: ");
                String email = clavier.nextLine();
                System.out.print("Saisir le mot de passe: ");
                String mdp = clavier.nextLine();

                /// Communication avec la base de données
                Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
                Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
                String sql = "SELECT * FROM compte";                                                                                        // Ecriture de la requête SQL
                Statement statement =  connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                /// Recherche du compte
                while(result.next()) {
                    if(result.getString("emailCompte").equals(email) && result.getString("mdpCompte").equals(mdp)) {    // Si le compte a été trouvé
                        trouve = true;

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

    public void creerCompte() {
        Scanner clavier = new Scanner(System.in);

        try {
            /// Saisie de l'utilisateur
            System.out.print("Saisir votre prenom: ");
            String prenom = clavier.nextLine();
            System.out.print("Saisir votre nom: ");
            String nom = clavier.nextLine();
            System.out.print("Saisir votre email: ");
            String email = clavier.nextLine();
            System.out.print("Saisir votre mot de passe: ");
            String mdp = clavier.nextLine();
            System.out.print("Etes-vous un membre du staff (1=OUI, 0=NON): ");
            int isstaff = clavier.nextInt();

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
