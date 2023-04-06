package org.bdd;

import org.bdd.*;
import org.compte.*;
import org.oeuvre.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.lang.*;

public class Bibliotheque {
    /** Attributs **/
    private ArrayList<Film> listeFilm;
    private ArrayList<Serie> listeSerie;
    private Map<String, ArrayList<Film>> triFilm;
    private Map<String, ArrayList<Serie>> triSerie;

    /** Constructeur **/
    public Bibliotheque() {
        this.listeFilm = new ArrayList<>();
        this.listeSerie = new ArrayList<>();
        this.triFilm =  new HashMap<>();
        this.triSerie = new HashMap<>();
    }

    /** Getters et setters **/
    public ArrayList<Film> getListeFilm() {
        return listeFilm;
    }

    public ArrayList<Serie> getListeSerie() {
        return listeSerie;
    }

    public Map<String, ArrayList<Film>> getTriFilm() {
        return triFilm;
    }

    public Map<String, ArrayList<Serie>> getTriSerie() {
        return triSerie;
    }

    public void setListeFilm(ArrayList<Film> listeFilm) {
        this.listeFilm = listeFilm;
    }

    public void setListeSerie(ArrayList<Serie> listeSerie) {
        this.listeSerie = listeSerie;
    }

    public void setTriFilm(Map<String, ArrayList<Film>> triFilm) {
        this.triFilm = triFilm;
    }

    public void setTriSerie(Map<String, ArrayList<Serie>> triSerie) {
        this.triSerie = triSerie;
    }

    /** Méthodes **/

    /* Méthode permettant de récupérer l'ensemble de la table film et qui retourne une ArrayList de films */
    public ArrayList<Film> chargerFilms() {
        /// Déclaration de variables
        ArrayList<Film> liste = new ArrayList<>();

        try {
            /// Communication avec la base de données
            String urlBDD = "jdbc:mysql://localhost:3306/ece_(net)flix";
            String usernameBDD = "root";
            String passwordBDD = "";
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(urlBDD, usernameBDD, passwordBDD);        // Etablissement de la connexion avec la BDD
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
            String urlBDD = "jdbc:mysql://localhost:3306/ece_(net)flix";
            String usernameBDD = "root";
            String passwordBDD = "";
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                         // Chargement du pilote JDBC
            Connection connection = DriverManager.getConnection(urlBDD, usernameBDD, passwordBDD);        // Etablissement de la connexion avec la BDD
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

    /* Méthodes permettant de trier les films selon le genre */
    public Map<String, ArrayList<Film>> trierFilms() {
        /// Déclaration de variables
        Map<String, ArrayList<Film>> listeTrie = new HashMap<>();

        /// Tri des films
        for(int i=0; i<this.getListeFilm().size(); i++) {
            /// Récupération des genres du film
            String[] genres = this.getListeFilm().get(i).getGenreOeuvre().split(", ");
            for(String genre: genres) {
                if(!listeTrie.containsKey(genre)) {                     // Si le genre n'a pas encore été créé, on créé une liste pour le genre
                    listeTrie.put(genre, new ArrayList<>());
                }
                listeTrie.get(genre).add(this.getListeFilm().get(i));
            }
        }
        return listeTrie;
    }

    /* Méthodes permettant de trier les series selon le genre */
    public Map<String, ArrayList<Serie>> trierSeries() {
        /// Déclaration de variables
        Map<String, ArrayList<Serie>> listeTrie = new HashMap<>();

        /// Tri des séries
        for(int i=0; i<this.getListeSerie().size(); i++) {
            /// Récupération des genres du séries
            String[] genres = this.getListeSerie().get(i).getGenreOeuvre().split(", ");
            for(String genre: genres) {
                if(!listeTrie.containsKey(genre)) {                     // Si le genre n'a pas encore été créé, on créé une liste pour le genre
                    listeTrie.put(genre, new ArrayList<>());
                }
                listeTrie.get(genre).add(this.getListeSerie().get(i));
            }
        }
        return listeTrie;
    }
}
