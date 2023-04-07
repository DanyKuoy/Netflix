package org.dao;

import org.oeuvre.Episode;
import org.oeuvre.Film;
import org.oeuvre.Serie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

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

    /* Méthode permettant de récupérer l'ensemble de la table film et qui retourne une ArrayList de films */
    public ArrayList<Film> chargerFilms() {
        /// Déclaration de variables
        ArrayList<Film> liste = new ArrayList<>();

        try {
            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql = "SELECT * FROM film";                                                                                        // Ecriture de la requête SQL
            Statement statement =  connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            /// Récupération des données
            while(result.next()) {
                int idFilm = result.getInt("idFilm");
                int dureeFilm = result.getInt("dureeFilm");
                String lienFilm = result.getString("lienFilm");
                String nomOeuvre = result.getString("nomOeuvre");
                int anneeOeuvre = result.getInt("anneeOeuvre");
                String realisateurOeuvre = result.getString("realisateurOeuvre");
                String distributionOeuvre = result.getString("distributionOeuvre");
                int classificationOeuvre = result.getInt("classificationOeuvre");
                String synopsisOeuvre = result.getString("synopsisOeuvre");
                String typeOeuvre = result.getString("typeOeuvre");
                String genreOeuvre = result.getString("genreOeuvre");
                float noteOeuvre = result.getFloat("noteOeuvre");

                /// Récupération et conversion de l'image
                Blob blobFilm = result.getBlob("imageOeuvre");
                byte[] imageBytes = blobFilm.getBytes(1, (int) blobFilm.length());
                InputStream is = new ByteArrayInputStream(imageBytes);
                Image imageOeuvre = ImageIO.read(is);

                /// Création de l'objet et ajout dans la liste
                Film newFilm = new Film(nomOeuvre, anneeOeuvre, realisateurOeuvre, distributionOeuvre, classificationOeuvre, synopsisOeuvre, imageOeuvre, typeOeuvre, genreOeuvre, noteOeuvre, dureeFilm, idFilm, lienFilm);
                liste.add(newFilm);
            }
            connection.close();             // Fermeture de la connexion à la BDD
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return liste;
    }

    /* Méthode permettant de récupérer l'ensemble de la table serie et qui retourne une ArrayList de séries */
    public ArrayList<Serie> chargerSeries() {
        /// Déclaration de variables
        ArrayList<Serie> liste = new ArrayList<>();

        try {
            /// Communication avec la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(this.getUrlBDD(), this.getUsernameBDD(), this.getPasswordBDD());        // Etablissement de la connexion avec la BDD
            String sql = "SELECT * FROM film";                                                                                        // Ecriture de la requête SQL
            Statement statement =  connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            /// Récupération des données
            while(result.next()) {
                int nbSaisons = result.getInt("nbSaisons");
                int idSerie = result.getInt("idSerie");
                String lienSerie = result.getString("lienSerie");
                String nomOeuvre = result.getString("nomOeuvre");
                int anneeOeuvre = result.getInt("anneeOeuvre");
                String realisateurOeuvre = result.getString("realisateurOeuvre");
                String distributionOeuvre = result.getString("distributionOeuvre");
                int classificationOeuvre = result.getInt("classificationOeuvre");
                String synopsisOeuvre = result.getString("synopsisOeuvre");
                String typeOeuvre = result.getString("typeOeuvre");
                String genreOeuvre = result.getString("genreOeuvre");
                float noteOeuvre = result.getFloat("noteOeuvre");

                /// Récupération et conversion de l'image
                Blob blobFilm = result.getBlob("imageOeuvre");
                byte[] imageBytes = blobFilm.getBytes(1, (int) blobFilm.length());
                InputStream is = new ByteArrayInputStream(imageBytes);
                Image imageOeuvre = ImageIO.read(is);

                /// Récupération des saisons et épisodes
                ArrayList<ArrayList<Episode>> listeEpisodes = new ArrayList<ArrayList<Episode>>();
                for(int i=0; i<nbSaisons; i++) {
                    ArrayList<Episode> saison = new ArrayList<>();
                    String sql2 = "SELECT * FROM episode";                                                                                        // Ecriture de la requête SQL
                    Statement statement2 =  connection.createStatement();
                    ResultSet result2 = statement2.executeQuery(sql2);

                    /// Recherche du compte
                    while(result2.next()) {
                        if(result2.getString("idSerie").equals(idSerie) && result2.getString("numeroSaison").equals(i+1)) {    // Si le compte a été trouvé
                            /// Création de l'episode
                            int idSerie2 = result2.getInt("idSerie2");
                            int numeroSaison = result2.getInt("numeroSaison");
                            int numeroEpisode = result2.getInt("numeroEpisode");
                            int dureeEpisode = result2.getInt("dureeEpisode");
                            String lienEpisode = result2.getString("lienEpisode");
                            String titreEpisode = result2.getString("titreEpisode");

                            /// Ajout de l'épisode dans la saison
                            Episode episode = new Episode(idSerie2, numeroSaison, numeroEpisode, dureeEpisode, lienEpisode, titreEpisode);
                            saison.add(episode);
                        }
                    }
                    listeEpisodes.add(saison);
                }

                /// Création de l'objet et ajout dans la liste
                Serie newSerie = new Serie(nomOeuvre, anneeOeuvre, realisateurOeuvre, distributionOeuvre, classificationOeuvre, synopsisOeuvre, imageOeuvre, typeOeuvre, genreOeuvre, noteOeuvre, nbSaisons, idSerie);
                liste.add(newSerie);
            }
            connection.close();             // Fermeture de la connexion à la BDD
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erreur: le pilote JDBC n'a pas ete trouve!");
        }
        catch(SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return liste;
    }
}
