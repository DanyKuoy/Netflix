package org.affichage.InterfaceGraphiqueMVC;

import org.affichage.InformationFilmsMVC.ControllerInformationFilms;
import org.affichage.InformationFilmsMVC.ModelInformationFilms;
import org.affichage.InformationFilmsMVC.VueInformationFilms;
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
        for(int i=0; i<30; i++) {
            this.vueInterface.getBFilm4()[i].addActionListener(this);
        }
        for(int i=0; i<18; i++) {
            this.vueInterface.getBFilm5()[i].addActionListener(this);
        }
        for(int i=0; i<30; i++) {
            this.vueInterface.getBFilm6()[i].addActionListener(this);
        }
        for(int i=0; i<12; i++) {
            this.vueInterface.getBFilm7()[i].addActionListener(this);
        }
        for(int i=0; i<30; i++) {
            this.vueInterface.getBFilm8()[i].addActionListener(this);
        }
        for(int i=0; i<12; i++) {
            this.vueInterface.getBFilm9()[i].addActionListener(this);
        }
        for(int i=0; i<30; i++) {
            this.vueInterface.getBFilm10()[i].addActionListener(this);
        }
        for(int i=0; i<30; i++) {
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
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelInterface.getOeuvre(i,11));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm4()[i]) {
            }

            else if (e.getSource() == vueInterface.getBFilm5()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelInterface.getOeuvre(i,2));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm6()[i]) {
            }

            else if (e.getSource() == vueInterface.getBFilm7()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelInterface.getOeuvre(i,0));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm8()[i]) {
            }

            else if (e.getSource() == vueInterface.getBFilm9()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelInterface.getOeuvre(i,14));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueInterface.getBFilm10()[i]) {
            }

            else if (e.getSource() == vueInterface.getBFilm11()[i]) {
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
    }
}
