package org.affichage.InterfaceGraphiqueMVC;

import org.affichage.InformationFilmsMVC.ControllerInformationFilms;
import org.affichage.InformationFilmsMVC.ModelInformationFilms;
import org.affichage.InformationFilmsMVC.VueInformationFilms;
import org.affichage.InformationSeriesMVC.ControllerInformationSeries;
import org.affichage.InformationSeriesMVC.ModelInformationSeries;
import org.affichage.InformationSeriesMVC.VueInformationSeries;
import org.affichage.RechercheMVC.ControllerRecherche;
import org.affichage.RechercheMVC.ModelRecherche;
import org.affichage.RechercheMVC.VueRecherche;
import org.affichage.SeriesMVC.*;
import org.affichage.FilmsMVC.*;
import org.affichage.ConnexionMVC.*;
import org.affichage.SeriesMVC.ModelSeries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerInterface implements ActionListener {

    private VueInterface vueInterface;
    private ModelInterface modelInterface;

    public ControllerInterface(ModelInterface modelInterface, VueInterface vueInterface) {
    this.vueInterface = vueInterface;
    this.modelInterface = modelInterface;

    this.vueInterface.getBFilm().addActionListener(this);
    this.vueInterface.getBSerie().addActionListener(this);
    this.vueInterface.getBRecherche().addActionListener(this);

        for(int i=0; i<19; i++) {
            this.vueInterface.getBFilm1()[i].addActionListener(this);
        }
        for(int i=0; i<21; i++) {
            this.vueInterface.getBFilm2()[i].addActionListener(this);
        }
        for(int i=0; i<17; i++) {
            this.vueInterface.getBFilm3()[i].addActionListener(this);
        }
        for(int i=0; i<13; i++) {
            this.vueInterface.getBFilm4()[i].addActionListener(this);
        }
        for(int i=0; i<18; i++) {
            this.vueInterface.getBFilm5()[i].addActionListener(this);
        }
        for(int i=0; i<11; i++) {
            this.vueInterface.getBFilm6()[i].addActionListener(this);
        }
        for(int i=0; i<12; i++) {
            this.vueInterface.getBFilm7()[i].addActionListener(this);
        }
        for(int i=0; i<18; i++) {
            this.vueInterface.getBFilm8()[i].addActionListener(this);
        }
        for(int i=0; i<12; i++) {
            this.vueInterface.getBFilm9()[i].addActionListener(this);
        }
        for(int i=0; i<21; i++) {
            this.vueInterface.getBFilm10()[i].addActionListener(this);
        }
        for(int i=0; i<14; i++) {
            this.vueInterface.getBFilm11()[i].addActionListener(this);
        }
        for(int i=0; i<1; i++) {
            this.vueInterface.getBFilm12()[i].addActionListener(this);
        }

        this.vueInterface.getBRetourConnexion().addActionListener(this);



    }

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 40; i++) {

            if (e.getSource() == vueInterface.getBFilm1()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelInterface.getOeuvre(i,8));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm2()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelInterface.getOeuvre(i,3));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm3()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelInterface.getOeuvre(i,12));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm4()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelInterface.getSerie(i,0));
                ControllerInformationSeries controllerInformationSeries = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm5()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelInterface.getOeuvre(i,2));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm6()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelInterface.getSerie(i,5));
                ControllerInformationSeries controllerInformationSeries = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm7()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelInterface.getOeuvre(i,0));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm8()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelInterface.getSerie(i,9));
                ControllerInformationSeries controllerInformationSeries = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm9()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelInterface.getOeuvre(i,14));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm10()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelInterface.getSerie(i,7));
                ControllerInformationSeries controllerInformationSeries = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm11()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelInterface.getSerie(i,6));
                ControllerInformationSeries controllerInformationSeries = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm12()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelInterface.getOeuvre(i,6));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }
        }

        if(e.getSource() == vueInterface.getBRetourConnexion()){

            ModelConnexion modelConnexion = new ModelConnexion();
            VueConnexion vueConnexion = new VueConnexion();
            ControllerConnexion controllerConnexion = new ControllerConnexion(vueConnexion, modelConnexion);
            vueConnexion.Afficher();

            vueInterface.dispose();
        }
        else if(e.getSource() == vueInterface.getBFilm()){

            ModelFilms modelFilms = new ModelFilms(this.modelInterface.getCompte(),this.modelInterface.getProfil());
            VueFilms vueFilms = new VueFilms(this.modelInterface.getCompte(),this.modelInterface.getProfil());
            ControllerFilms controllerFilms = new ControllerFilms(modelFilms, vueFilms);
            vueFilms.Afficher();

            vueInterface.dispose();
        }
        if(e.getSource() == vueInterface.getBSerie()){

            ModelSeries modelSeries = new ModelSeries(this.modelInterface.getCompte(),this.modelInterface.getProfil());
            VueSeries vueSeries = new VueSeries(this.modelInterface.getCompte(),this.modelInterface.getProfil());
            ControllerSeries controllerSeries = new ControllerSeries(modelSeries, vueSeries);
            vueSeries.Afficher();

            vueInterface.dispose();
        }
        if(e.getSource() == vueInterface.getBRecherche()){
            ModelRecherche modelRecherche = new ModelRecherche(this.modelInterface.getCompte(),this.modelInterface.getProfil());
            VueRecherche vueRecherche = new VueRecherche(this.modelInterface.getCompte(),this.modelInterface.getProfil(),this.vueInterface.getRecherche());
            ControllerRecherche controllerRecherche = new ControllerRecherche(modelRecherche, vueRecherche);
            vueRecherche.Afficher();
        }
    }
}
