package org.compte;

import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class Compte {
    /** Attributs **/
    private String prenomCompte;
    private String nomCompte;
    private String emailCompte;
    private String mdpCompte;
    private boolean staff;                  // True=staff, False=client
    private int nbProfil;
    private ArrayList<Profil> listeProfil;

    /** Constructeurs **/
    public Compte() {
        this.listeProfil = new ArrayList<>();
    }

    public Compte(String prenomCompte, String nomCompte, String emailCompte, String mdpCompte, boolean staff) {
        this.prenomCompte = prenomCompte;
        this.nomCompte = nomCompte;
        this.emailCompte = emailCompte;
        this.mdpCompte = mdpCompte;
        this.staff = staff;
        this.nbProfil = 0;
        this.listeProfil = new ArrayList<>();
    }

    /** Getters et setters **/
    public String getPrenomCompte() {
        return prenomCompte;
    }

    public String getNomCompte() {
        return nomCompte;
    }

    public String getEmailCompte() {
        return emailCompte;
    }

    public String getMdpCompte() {
        return mdpCompte;
    }

    public boolean getStaff() {
        return staff;
    }

    public int getNbProfil() {
        return nbProfil;
    }

    public void setPrenomCompte(String prenomCompte) {
        this.prenomCompte = prenomCompte;
    }

    public void setNomCompte(String nomCompte) {
        this.nomCompte = nomCompte;
    }

    public void setEmailCompte(String emailCompte) {
        this.emailCompte = emailCompte;
    }

    public void setMdpCompte(String mdpCompte) {
        this.mdpCompte = mdpCompte;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }

    public void setNbProfil(int nbProfil) {
        this.nbProfil = nbProfil;
    }

    /** Méthodes **/

    /* Méthode permettant d'ajouter un profil dans un compte */
    public void ajouterProfil(String email) {
        Scanner clavier = new Scanner(System.in);

        try {
            /// Saisie de l'utilisateur
            System.out.print("Saisir votre prenom: ");
            String prenom = clavier.nextLine();
            System.out.print("Restriction d'age (1=OUI, 0=NON): ");
            int restrictionAge = clavier.nextInt();
            System.out.print("Reprise video (1=OUI, 0=NON): ");
            clavier.nextLine();
            int repriseVideo = clavier.nextInt();
            System.out.print("Saisir la qualite video (720, 1080, 1440, 2180): ");
            clavier.nextLine();
            int qualiteVideo = clavier.nextInt();
            System.out.print("Saisir le language des sous-titres parmi ceux proposes (Francais, Anglais, Espagnol, Chinois, Allemand, Portugais, Italien, Coreen): ");
            clavier.nextLine();
            String sousTitres= clavier.nextLine();

            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            String urlBDD = "jdbc:mysql://localhost:3306/ece_(net)flix";
            String usernameBDD = "root";
            String passwordBDD = "";
            Connection connection = DriverManager.getConnection(urlBDD, usernameBDD, passwordBDD);        // Etablissement de la connexion avec la BDD
            PreparedStatement statement = connection.prepareStatement("INSERT INTO profil(prenomProfil, emailProfil, restrictionAge, repriseVideo, qualiteVideo, sousTitres) VALUES (?, ?, ?, ?, ?, ?)");                                                                                     // Ecriture de la requête SQL
            statement.setString(1, prenom);
            statement.setString(2, email);
            statement.setInt(3, restrictionAge);
            statement.setInt(4, repriseVideo);
            statement.setInt(5, qualiteVideo);
            statement.setString(6, sousTitres);
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
