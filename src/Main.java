import org.affichage.*;
import org.bdd.*;
import org.compte.*;
import org.oeuvre.*;
import org.dao.*;

import java.lang.*;
import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Mafenetre fenetre = new Mafenetre();

        /*
        Bibliotheque b1 = new Bibliotheque();
        BibliothequeDAO b = new BibliothequeDAO();
        b1.setListeFilm(b.chargerFilms());
        b1.setListeSerie(b.chargerSeries());

        Map<String, ArrayList<Film>> listeTrie = new HashMap<>();

        /// Tri des films
        b1.setTriFilm(b1.trierFilms());

        /// Affichage
        for(String cle: b1.getTriFilm().keySet()) {
            ArrayList<Film> listefilm = b1.getTriFilm().get(cle);
            System.out.println("GENRE: " + cle);
            for(int i=0; i<listefilm.size(); i++) {
                System.out.println(listefilm.get(i).getNomOeuvre());
                System.out.println("");
            }
            System.out.println("------------------------------------------");
        }


        ArrayList<Oeuvre> recherche = b1.rechercheTitre("le");
        if(recherche.size()==0) {
            System.out.println("Aucune oeuvre trouvée");
        }
        else {
            for(int t=0; t<recherche.size(); t++) {
                System.out.println(recherche.get(t).getNomOeuvre());
                System.out.println("");
            }
        }

        */
    }
}
