package org.dao;

import org.oeuvre.*;

import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * La classe BibliothequeDAO permet de gérer l'accès à la base de données de la récupération des films et séries
 */
public class BibliothequeDAO {
    /** Attributs **/
    private String urlBDD;
    private String usernameBDD;
    private String passwordBDD;

    /** Constructeur **/
    public BibliothequeDAO() {
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
     *  Méthode permettant de récupérer l'ensemble de la table film et qui retourne une ArrayList de films
     *
     *  @return L'ArrayList de films récupérée depuis la table film de la BDD
     *  */
    public ArrayList<Film> chargerFilms() {
        /// Déclaration de variables
        ArrayList<Film> liste = new ArrayList<>();

        try {
            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql = "SELECT * FROM film";                                                                                        // Ecriture de la requête SQL
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            /// Récupération des données
            while (result.next()) {
                int idFilm = result.getInt("idFilm");
                int dureeFilm = result.getInt("dureeFilm");
                String lienFilm = result.getString("lienFilm");
                String nomOeuvre = result.getString("nomOeuvre");
                int anneeOeuvre = result.getInt("anneeOeuvre");
                String realisateurOeuvre = result.getString("realisateurOeuvre");
                String distributionOeuvre = result.getString("distributionOeuvre");
                int classificationOeuvre = result.getInt("classificationOeuvre");
                String synopsisOeuvre = result.getString("synopsisOeuvre");
                String genreOeuvre = result.getString("genreOeuvre");
                float noteOeuvre = result.getFloat("noteOeuvre");

                /// Création de l'objet et ajout dans la liste
                Film newFilm = new Film(nomOeuvre, anneeOeuvre, realisateurOeuvre, distributionOeuvre, classificationOeuvre, synopsisOeuvre, genreOeuvre, noteOeuvre, dureeFilm, idFilm, lienFilm);
                liste.add(newFilm);
            }
            connection.close();             // Fermeture de la connexion à la BDD
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        } catch (SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
        return liste;
    }

    /**
     *  Méthode permettant de récupérer l'ensemble de la table serie et qui retourne une ArrayList de séries
     *
     *  @return L'ArrayList de films récupérée depuis la table serie de la BDD
     *  */
    public ArrayList<Serie> chargerSeries() {
        /// Déclaration de variables
        ArrayList<Serie> liste = new ArrayList<>();

        try {
            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql = "SELECT * FROM serie";                                                                                        // Ecriture de la requête SQL
            Statement statement =  connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            /// Récupération des données
            while(result.next()) {
                int nbSaisons = result.getInt("nbSaisons");
                int idSerie = result.getInt("idSerie");
                String nomOeuvre = result.getString("nomOeuvre");
                int anneeOeuvre = result.getInt("anneeOeuvre");
                String realisateurOeuvre = result.getString("realisateurOeuvre");
                String distributionOeuvre = result.getString("distributionOeuvre");
                int classificationOeuvre = result.getInt("classificationOeuvre");
                String synopsisOeuvre = result.getString("synopsisOeuvre");
                String genreOeuvre = result.getString("genreOeuvre");
                float noteOeuvre = result.getFloat("noteOeuvre");

                /// Récupération des saisons et épisodes
                ArrayList<ArrayList<Episode>> listeEpisodes = new ArrayList<ArrayList<Episode>>();
                for(int i=0; i<nbSaisons; i++) {
                    ArrayList<Episode> saison = new ArrayList<>();
                    String sql2 = "SELECT * FROM episode";                                                                                        // Ecriture de la requête SQL
                    Statement statement2 =  connection.createStatement();
                    ResultSet result2 = statement2.executeQuery(sql2);

                    /// Recherche du compte
                    while(result2.next()) {
                        if(result2.getInt("idSerie")==idSerie && result2.getInt("numeroSaison")==(i+1)) {    // Si le compte a été trouvé

                            /// Création de l'episode
                            int idSerie2 = result2.getInt("idSerie");
                            int numeroSaison = result2.getInt("numeroSaison");
                            int numeroEpisode = result2.getInt("numeroEpisode");
                            int dureeEpisode = result2.getInt("dureeEpisode");
                            String lienEpisode = result2.getString("lienEpisode");
                            String titreEpisode = result2.getString("titreEpisode");

                            /// Ajout de l'épisode dans la saison
                            Episode episode = new Episode(idSerie2, numeroSaison, numeroEpisode, dureeEpisode, lienEpisode, titreEpisode);
                            //System.out.println(episode.getTitreEpisode());
                            saison.add(episode);
                        }
                    }
                    listeEpisodes.add(saison);
                }

                /// Création de l'objet et ajout dans la liste
                Serie newSerie = new Serie(nomOeuvre, anneeOeuvre, realisateurOeuvre, distributionOeuvre, classificationOeuvre, synopsisOeuvre, genreOeuvre, noteOeuvre, nbSaisons, idSerie);
                newSerie.setListeEpisodes(listeEpisodes);
                liste.add(newSerie);
            }
            connection.close();             // Fermeture de la connexion à la BDD
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
        return liste;
    }

    /**
     * Méthode permettant de supprimer un film
     * @param nom Le titre exact du film
     * @return Un booléen disant que le film est trouvé ou non
     */
    public boolean supprimerFilm(String nom) {
        /// Déclaration de variable
        boolean trouve = false;

        try {
            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql2 = "SELECT * FROM film";                                                                                        // Ecriture de la requête SQL
            Statement statement2 =  connection.createStatement();
            ResultSet result2 = statement2.executeQuery(sql2);

            /// Recherche du compte
            while(result2.next()) {
                if(result2.getString("nomOeuvre").equals(nom)) {    // Si le compte a été trouvé
                    PreparedStatement statement3 = connection.prepareStatement("DELETE FROM film WHERE nomOeuvre = ?");
                    statement3.setString(1, nom);
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

    /**
     * Méthode permettant de supprimer une serie
     * @param nom Le titre exact de la serie
     * @return Un booléen disant que la serie est trouvée ou non
     */
    public boolean supprimerSerie(String nom) {
        /// Déclaration de variable
        boolean trouve = false;

        try {
            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql2 = "SELECT * FROM serie";                                                                                        // Ecriture de la requête SQL
            Statement statement2 =  connection.createStatement();
            ResultSet result2 = statement2.executeQuery(sql2);

            /// Recherche du compte
            while(result2.next()) {
                if(result2.getString("nomOeuvre").equals(nom)) {    // Si le compte a été trouvé
                    PreparedStatement statement3 = connection.prepareStatement("DELETE FROM serie WHERE nomOeuvre = ?");
                    statement3.setString(1, nom);
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
