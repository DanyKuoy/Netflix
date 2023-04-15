import org.compte.*;
import org.affichage.InterfaceGraphiqueMVC.*;

import java.lang.*;

public class Main {
    public static void main(String[] args) {
        //new Mafenetre();
        //new InterfaceGraphique(new Compte(), 1);


        Compte compte = new Compte();
        int profil = 1;
        ModelInterface modelInterface = new ModelInterface();
        VueInterface vueInterface = new VueInterface(compte, profil);
        ControllerInterface controllerInterface = new ControllerInterface(modelInterface, vueInterface);
        vueInterface.afficher();


        /*
        Bibliotheque b1 = new Bibliotheque();
        BibliothequeDAO b = new BibliothequeDAO();
        b1.setListeFilm(b.chargerFilms());
        //b1.setListeSerie(b.chargerSeries());

        //Map<String, ArrayList<Film>> listeTrie = new HashMap<>();

        System.out.println(b1.getListeFilm().get(0).getNomOeuvre());

        /*
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
