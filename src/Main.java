import org.affichage.ConnexionMVC.ControllerConnexion;
import org.affichage.ConnexionMVC.ModelConnexion;
import org.affichage.ConnexionMVC.VueConnexion;
import org.affichage.InformationFilmsMVC.ModelInformationFilms;
import org.affichage.MenuStaffMVC.ControllerStaff;
import org.affichage.MenuStaffMVC.ModelStaff;
import org.affichage.MenuStaffMVC.VueStaff;
import org.affichage.RechercheMVC.ControllerRecherche;
import org.affichage.RechercheMVC.ModelRecherche;
import org.affichage.RechercheMVC.VueRecherche;
import org.compte.*;
import org.affichage.InterfaceGraphiqueMVC.*;
import org.dao.*;
import org.oeuvre.*;
import org.bdd.*;


import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        ModelConnexion modelConnexion = new ModelConnexion();
        VueConnexion vueConnexion = new VueConnexion();
        ControllerConnexion controllerConnexion = new ControllerConnexion(vueConnexion, modelConnexion);
        vueConnexion.Afficher();
/*
        ModelStaff modelStaff = new ModelStaff(new Compte(),1);
        VueStaff vueStaff = new VueStaff();
        ControllerStaff controllerStaff = new ControllerStaff(modelStaff, vueStaff);
        vueStaff.afficher();

*/
/*
        ModelInterface modelInterface = new ModelInterface(new Compte(),1);
        VueInterface vueInterface = new VueInterface(new Compte(),1);
        ControllerInterface controllerInterface = new ControllerInterface(modelInterface, vueInterface);
        vueInterface.afficher();
/*

        /*
        Bibliotheque b1 = new Bibliotheque();
        BibliothequeDAO b = new BibliothequeDAO();
        //b1.setListeFilm(b.chargerFilms());
        b1.setListeSerie(b.chargerSeries());
        */

        /*
        Map<String, ArrayList<Film>> listeTrie = new HashMap<>();

        /// Tri des films
        b1.setTriFilm(b1.trierFilms());

        /// Affichage des films
        for(String cle: b1.getTriFilm().keySet()) {
            ArrayList<Film> listefilm = b1.getTriFilm().get(cle);
            System.out.println("GENRE: " + cle);
            for(int i=0; i<listefilm.size(); i++) {
                System.out.println(listefilm.get(i).getNomOeuvre());
                System.out.println("");
            }
            System.out.println("------------------------------------------");
        }
        */

        /*
        /// Affichage des séries
        for(int j=0; j<b1.getListeSerie().size(); j++) {
            System.out.println("SERIE: " + b1.getListeSerie().get(j).getNomOeuvre());
            Serie serie = b1.getListeSerie().get(j);
            for(int i=0; i<serie.getNbSaisons(); i++) {
                System.out.println("SAISON " + (i+1) + " :");
                System.out.println("");
                ArrayList<Episode> saison = serie.getListeEpisodes().get(i);
                for(int l=0; l<saison.size(); l++) {
                    System.out.println(saison.get(l).getTitreEpisode());
                }
            }
            System.out.println("------------------------------------------");
        }
        */

        /*
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
/*
        ModelRecherche modelRecherche = new ModelRecherche(new Compte(),1);
        VueRecherche vueRecherche = new VueRecherche(new Compte(),1, "Le");
        ControllerRecherche controllerRecherche = new ControllerRecherche(modelRecherche, vueRecherche);
        vueRecherche.Afficher();

*/

        /*
        /// Renvoyer vers la page web de la vidéo de l'oeuvre
        try {
            String lienVideo1 = b1.getListeFilm().get(0).getLienFilm();
            String path = lienVideo1.substring(0, lienVideo1.length()-2);       // Si y'a un "?" dans le lien, mettre -3
            URI lienVideo2 = new URI(path);
            Desktop.getDesktop().browse(lienVideo2);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        */





    }
}
