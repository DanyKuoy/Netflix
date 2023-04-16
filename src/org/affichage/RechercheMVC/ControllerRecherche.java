package org.affichage.RechercheMVC;

import org.affichage.ConnexionMVC.ControllerConnexion;
import org.affichage.ConnexionMVC.ModelConnexion;
import org.affichage.ConnexionMVC.VueConnexion;
import org.affichage.FilmsMVC.ControllerFilms;
import org.affichage.FilmsMVC.ModelFilms;
import org.affichage.FilmsMVC.VueFilms;
import org.affichage.InformationFilmsMVC.ControllerInformationFilms;
import org.affichage.InformationFilmsMVC.ModelInformationFilms;
import org.affichage.InformationFilmsMVC.VueInformationFilms;
import org.affichage.InformationSeriesMVC.ControllerInformationSeries;
import org.affichage.InformationSeriesMVC.ModelInformationSeries;
import org.affichage.InformationSeriesMVC.VueInformationSeries;
import org.affichage.InterfaceGraphiqueMVC.ControllerInterface;
import org.affichage.InterfaceGraphiqueMVC.ModelInterface;
import org.affichage.InterfaceGraphiqueMVC.VueInterface;
import org.affichage.SeriesMVC.ControllerSeries;
import org.affichage.SeriesMVC.ModelSeries;
import org.affichage.SeriesMVC.VueSeries;
import org.oeuvre.Film;
import org.oeuvre.Oeuvre;
import org.oeuvre.Serie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControllerRecherche implements ActionListener {

    private VueRecherche vueRecherche;
    private ModelRecherche modelRecherche;

    public ControllerRecherche(ModelRecherche modelRecherche,VueRecherche vueRecherche) {
        this.vueRecherche = vueRecherche;
        this.modelRecherche = modelRecherche;

        vueRecherche.getBRecherche().addActionListener(this);
        vueRecherche.getBRetourConnexion().addActionListener(this);
        vueRecherche.getBSerie().addActionListener(this);
        vueRecherche.getBFilms().addActionListener(this);

        for(int i=0;i<this.vueRecherche.getListeOeuvre().size();i++){
            vueRecherche.getBAffichage(i).addActionListener(this);
        }
    }


    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 100; i++) {

            if (e.getSource() == vueRecherche.getBAffichage(i)) {
                ArrayList<Oeuvre> ListeOeuvre = this.vueRecherche.getListeOeuvre();
                if(vueRecherche.getTab()[i] == true){
                    ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                    VueInformationFilms vueInformationFilms = new VueInformationFilms((Film) ListeOeuvre.get(i));
                    ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                    vueInformationFilms.Afficher();
                }
                else{
                    ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                    VueInformationSeries vueInformationSeries = new VueInformationSeries((Serie) ListeOeuvre.get(i));
                    ControllerInformationSeries controllerInformationFilms = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                    vueInformationSeries.Afficher();
                }
            }
        }

        if(e.getSource() == vueRecherche.getBRetourConnexion()){

            ModelConnexion modelConnexion = new ModelConnexion();
            VueConnexion vueConnexion = new VueConnexion();
            ControllerConnexion controllerConnexion = new ControllerConnexion(vueConnexion, modelConnexion);
            vueConnexion.Afficher();

            vueRecherche.dispose();
        }
        else if(e.getSource() == vueRecherche.getBSerie()){

            ModelSeries modelSeries = new ModelSeries(this.modelRecherche.getCompte(),this.modelRecherche.getProfil());
            VueSeries vueSeries = new VueSeries(this.modelRecherche.getCompte(),this.modelRecherche.getProfil());
            ControllerSeries controllerSeries = new ControllerSeries(modelSeries, vueSeries);
            vueSeries.Afficher();

            vueRecherche.dispose();

        }
        if(e.getSource() == vueRecherche.getBFilms()){

            ModelFilms modelFilms = new ModelFilms(this.modelRecherche.getCompte(),this.modelRecherche.getProfil());
            VueFilms vueFilms = new VueFilms(this.modelRecherche.getCompte(),this.modelRecherche.getProfil());
            ControllerFilms controllerFilms = new ControllerFilms(modelFilms, vueFilms);
            vueFilms.Afficher();

            vueRecherche.dispose();
        }
        if(e.getSource() == vueRecherche.getBRecherche()){
            vueRecherche.dispose();

            ModelRecherche modelRecherche = new ModelRecherche(this.modelRecherche.getCompte(),this.modelRecherche.getProfil());
            VueRecherche vueRecherche = new VueRecherche(this.modelRecherche.getCompte(),this.modelRecherche.getProfil(),this.vueRecherche.getRecherche());
            ControllerRecherche controllerRecherche = new ControllerRecherche(modelRecherche, vueRecherche);
            vueRecherche.Afficher();
        }
    }
}
