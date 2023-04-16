package org.dao;

import org.compte.*;
import org.oeuvre.*;

import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 *  Cette classe permet la gestion des comptes et des profils rattachés dans la BDD
 */
public class CompteDAO {
    /** Attributs **/
    private String urlBDD;
    private String usernameBDD;
    private String passwordBDD;

    /** Constructeur **/
    public CompteDAO() {
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

    /**
     *  Méthode permettant d'ajouter un profil dans un compte
     */
    public void ajouterProfil(String prenom, String email, int restrictionAge, int repriseVideo, int qualiteVideo, String sousTitres) {
        try {

            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            PreparedStatement statement = connection.prepareStatement("INSERT INTO profil(prenomProfil, emailCompte, restrictionAge, repriseVideo, qualiteVideo, sousTitres) VALUES (?, ?, ?, ?, ?, ?)");                                                                                     // Ecriture de la requête SQL
            statement.setString(1, prenom);
            statement.setString(2, email);
            statement.setInt(3, restrictionAge);
            statement.setInt(4, repriseVideo);
            statement.setInt(5, qualiteVideo);
            statement.setString(6, sousTitres);
            statement.executeUpdate();
            PreparedStatement statement2 = connection.prepareStatement("UPDATE compte SET nbProfil = nbProfil+1 WHERE emailCompte = ?");
            statement2.setString(1, email);
            statement2.executeUpdate();
            connection.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    /**
     *  Méthode permettant de supprimer un profil
     */
    public void supprimerProfil(String email, String prenom) {
        /// Saisie de l'utilisateur

        /// Communication avec la base de données
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql = "SELECT * FROM profil";                                                                                        // Ecriture de la requête SQL
            Statement statement =  connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println("Boucle");
            System.out.println(email + " " + prenom);
            /// Vérification si le profil existe et appartient au compte
            while(result.next()) {
                if(result.getString("emailCompte").equals(email) && result.getString("prenomProfil").equals(prenom)) {    // Si un profil a été trouvé
                    System.out.println("Profil trouvé");
                    PreparedStatement statement3 = connection.prepareStatement("UPDATE compte SET nbProfil = nbProfil-1 WHERE emailCompte = ?");
                    statement3.setString(1, email);
                    statement3.executeUpdate();
                    PreparedStatement statement2 = connection.prepareStatement("DELETE FROM profil WHERE emailCompte = ? AND prenomProfil = ? ");                                                                                        // Ecriture de la requête SQL
                    statement2.setString(1, email);
                    statement2.setString(2, prenom);
                    statement2.executeUpdate();
                }
            }
            connection.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    /**
     *  Méthode permettant de charger les profils d'un compte
     *
     * @return L'ArrayList de profil rattaché au compte
     *  */
    public ArrayList<Profil> chargerProfils(String email) {
        ///Déclaration de variables
        ArrayList<Profil> listeProfil = new ArrayList<>();

        /// Communication avec la base de données
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql = "SELECT * FROM profil";                                                                                        // Ecriture de la requête SQL
            Statement statement =  connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            /// Vérification si le profil existe et appartient au compte
            while(result.next()) {
                if(result.getString("emailCompte").equals(email)) {    // Si le compte a été trouvé
                    /// Création du profil
                    String prenom = result.getString("prenomProfil");
                    String emailCompte = result.getString("emailCompte");
                    boolean restriction = result.getBoolean("restrictionAge");
                    boolean reprise = result.getBoolean("repriseVideo");
                    int qualite = result.getInt("qualiteVideo");
                    String sousTitres = result.getString("sousTitres");

                    /// Ajout du profil dans le compte
                    Profil profil = new Profil(prenom, emailCompte, restriction, reprise, qualite, sousTitres);
                    listeProfil.add(profil);
                }
            }
            connection.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
        return listeProfil;
    }

    /**
     *  Méthode permettant de verifier si un compte est dans la BDD.
     *  @param ID l'adresse mail
     *  @param MDP le mot de passe
     *  @return un booléen
     */
    public boolean verifierCompte(String ID, String MDP) {
        /// Creation d'objets et de variables
        boolean trouve = false;

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
                    System.out.println("Compte trouvé");
                    return true;
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
        return false;
    }

    /**
     *  Méthode permettant de verifier si l'email existe déjà dans la BDD
     *  @param ID l'adresse mail
     *  @return un booléen
     */
    public boolean verifierCreerCompte(String ID) {
        try {
            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql = "SELECT * FROM compte";                                                                                        // Ecriture de la requête SQL
            Statement statement =  connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            /// Recherche du compte
            while(result.next()) {
                System.out.println(result.getString("emailCompte") + result.getString("mdpCompte"));
                if(result.getString("emailCompte").equals(ID)) {    // Si le compte a été trouvé
                    System.out.println("Email déjà existant");
                    return true;
                }
            }
            connection.close();             // Fermeture de la connexion à la BDD
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
        return false;
    }

    /**
     *  Méthode permettant de charger un compte selon le mail et le mot de passe renseigné
     *  @param ID l'adresse mail
     *  @param MDP le mot de passe
     *  @return un booléen
     */
    public Compte chargerCompte(String ID, String MDP) {
        /// Creation d'objets et de variables
        Compte compte = new Compte();

        try {
            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql = "SELECT * FROM compte";                                                                                        // Ecriture de la requête SQL
            Statement statement =  connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            /// Recherche du compte
            while(result.next()) {
                if(result.getString("emailCompte").equals(ID) && result.getString("mdpCompte").equals(MDP)) {    // Si le compte a été trouvé
                    System.out.println("Compte trouvé");

                    /// Création du compte à retourner
                    compte.setPrenomCompte(result.getString("prenomCompte"));
                    compte.setNomCompte(result.getString("nomCompte"));
                    compte.setEmailCompte(result.getString("emailCompte"));
                    compte.setMdpCompte(result.getString("mdpCompte"));
                    compte.setStaff(result.getBoolean("staff"));
                    compte.setNbProfil(result.getInt("nbProfil"));

                    /// Chargement des profils
                    ArrayList<Profil> listeProfil = new ArrayList<>();
                    listeProfil = this.chargerProfils(result.getString("emailCompte"));
                    compte.setListeProfil(listeProfil);
                }
            }
            connection.close();             // Fermeture de la connexion à la BDD
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
        return compte;
    }

    /**
     *  Méthode permettant de recharger le compte, apres avoir ajouté un profil
     *  @param ID l'adresse mail
     *  @return un booléen
     */
    public Compte rechargerCompte(String ID) {
        /// Creation d'objets et de variables
        Compte compte = new Compte();

        try {
            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql = "SELECT * FROM compte";                                                                                        // Ecriture de la requête SQL
            Statement statement =  connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            /// Recherche du compte
            while(result.next()) {
                if(result.getString("emailCompte").equals(ID)) {    // Si le compte a été trouvé

                    /// Création du compte à retourner
                    compte.setPrenomCompte(result.getString("prenomCompte"));
                    compte.setNomCompte(result.getString("nomCompte"));
                    compte.setEmailCompte(result.getString("emailCompte"));
                    compte.setMdpCompte(result.getString("mdpCompte"));
                    compte.setStaff(result.getBoolean("staff"));
                    compte.setNbProfil(result.getInt("nbProfil"));

                    /// Chargement des profils
                    ArrayList<Profil> listeProfil = new ArrayList<>();
                    listeProfil = this.chargerProfils(result.getString("emailCompte"));
                    compte.setListeProfil(listeProfil);
                }
            }
            connection.close();             // Fermeture de la connexion à la BDD
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
        return compte;
    }

    /**
     *  Méthode permettant de créer un compte dans la base de données
     *  @param prenom le prenom
     *  @param nom le nom
     *  @param email l'email
     *  @param mdp le mot de passe
     *  @param isstaff un booléen qui dit si on est un membre du staff ou pas
     */
    public void creerCompte(String prenom, String nom, String email, String mdp, int isstaff) {
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
            connection.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    /* Méthode permettant de modifier un compte */
    /**
     *  Méthode permettant de modifier un compte
     *  @param prenom le prenom
     *  @param nom le nom
     *  @param mdp le mot de passe
     *  @param staff un booléen qui dit si on est un membre du staff ou pas
     * @return un booléen
     */
    public boolean modifierCompte(String prenom, String nom, String mdp, boolean staff, String emailCompte) {
        /// Déclaration de variable
        boolean trouve = false;

        try {
            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql2 = "SELECT * FROM compte";                                                                                        // Ecriture de la requête SQL
            Statement statement2 =  connection.createStatement();
            ResultSet result2 = statement2.executeQuery(sql2);

            /// Recherche du compte
            while(result2.next()) {
                if(result2.getString("emailCompte").equals(emailCompte)) {    // Si le compte a été trouvé
                    PreparedStatement statement3 = connection.prepareStatement("UPDATE compte SET prenomCompte = ?, nomCompte = ?, mdpCompte = ?, staff = ? WHERE emailCompte = ?");
                    statement3.setString(1, prenom);
                    statement3.setString(2, nom);
                    statement3.setString(3, mdp);
                    statement3.setBoolean(4, staff);
                    statement3.setString(5, emailCompte);
                    statement3.executeUpdate();
                    trouve = true;
                }
            }
            connection.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
        return trouve;
    }

    /**
     * Méthode permettant de supprimer un compte
     * @param email l'email rattaché au compte
     * @return Un booléen disant que le compte est trouvé ou non
     */
    public boolean supprimerCompte(String email) {
        /// Déclaration de variable
        boolean trouve = false;

        try {
            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql2 = "SELECT * FROM compte";                                                                                        // Ecriture de la requête SQL
            Statement statement2 =  connection.createStatement();
            ResultSet result2 = statement2.executeQuery(sql2);

            /// Recherche du compte
            while(result2.next()) {
                if(result2.getString("emailCompte").equals(email)) {    // Si le compte a été trouvé
                    PreparedStatement statement3 = connection.prepareStatement("DELETE FROM compte WHERE emailCompte = ?");
                    statement3.setString(1, email);
                    statement3.executeUpdate();
                    trouve = true;
                }
            }
            connection.close();             // Fermeture de la connexion à la BDD
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
        return trouve;
    }
}
