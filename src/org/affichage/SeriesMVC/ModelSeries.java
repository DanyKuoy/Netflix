package org.affichage.SeriesMVC;

import org.bdd.Bibliotheque;
import org.dao.BibliothequeDAO;
import org.oeuvre.Film;
import org.oeuvre.Serie;
import org.compte.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModelSeries {

    private Compte compte;

    private Bibliotheque biblio = new Bibliotheque();

    private Map<String, ArrayList<Serie>> listeSerie;
    private Serie[][] ListeTrideSerie = new Serie[30][16];

    private String[][] liens = new String[30][30];

    private BibliothequeDAO biblioDAO = new BibliothequeDAO();

    private int profil;

    public ModelSeries(Compte compte, int profil){

        biblio.setListeSerie(biblioDAO.chargerSeries());
        //b1.setListeSerie(b.chargerSeries());

        Map<String, ArrayList<Serie>> listeTrie = new HashMap<>();

        /// Tri des films
        biblio.setTriSerie(biblio.trierSeries());

        int j=0;

        /// Affichage
        for(String cle: biblio.getTriSerie().keySet()) {
            ArrayList<Serie> listeserie = biblio.getTriSerie().get(cle);
            System.out.println("GENRE: " + cle + j);
            for(int i=0; i<listeserie.size(); i++) {
                liens[i][j] = listeserie.get(i).getNomOeuvre();
                ListeTrideSerie[i][j] = listeserie.get(i);
            }
            j++;
            System.out.println(listeserie.size());
            System.out.println("---------------------------------");
        }

        this.compte = compte;
        this.profil = profil;

    }


    public Serie getOeuvre(int i, int j){
        return ListeTrideSerie[i][j];
    }
    public Map<String, ArrayList<Serie>> getlisteFilm(){
        return listeSerie;
    }
    public Compte getCompte(){
        return compte;
    }

    public void setCompte(Compte compte){
        this.compte = compte;
    }

    public String[][] getLiens(){
        return liens;
    }

    public int getProfil(){
        return profil;
    }

}
