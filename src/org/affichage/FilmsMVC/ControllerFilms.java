package org.affichage.FilmsMVC;

import org.affichage.InformationFilmsMVC.ControllerInformationFilms;
import org.affichage.InformationFilmsMVC.ModelInformationFilms;
import org.affichage.InformationFilmsMVC.VueInformationFilms;
import org.affichage.InterfaceGraphiqueMVC.*;
import org.affichage.SeriesMVC.*;
import org.affichage.ConnexionMVC.*;
import org.affichage.InformationFilmsMVC.InforamtionOeuvre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerFilms implements ActionListener {

    private VueFilms vueFilms;
    private ModelFilms modelFilms;

    public ControllerFilms(ModelFilms modelInterface, VueFilms vueInterface) {
        this.vueFilms = vueInterface;
        this.modelFilms = modelInterface;

        this.vueFilms.getBMenu().addActionListener(this);
        this.vueFilms.getBSerie().addActionListener(this);
        this.vueFilms.getBRecherche().addActionListener(this);

        for(int i=0; i<12; i++) {
            this.vueFilms.getBFilm7()[i].addActionListener(this);
        }
        for(int i=0; i<22; i++) {
            this.vueFilms.getBFilm11()[i].addActionListener(this);
        }
        for(int i=0; i<18; i++) {
            this.vueFilms.getBFilm3()[i].addActionListener(this);
        }
        for(int i=0; i<21; i++) {
            this.vueFilms.getBFilm6()[i].addActionListener(this);
        }
        for(int i=0; i<15; i++) {
            this.vueFilms.getBFilm15()[i].addActionListener(this);
        }
        for(int i=0; i<16; i++) {
            this.vueFilms.getBFilm16()[i].addActionListener(this);
        }
        for(int i=0; i<1; i++) {
            this.vueFilms.getBFilm8()[i].addActionListener(this);
        }
        for(int i=0; i<12; i++) {
            this.vueFilms.getBFilm5()[i].addActionListener(this);
        }
        for(int i=0; i<19; i++) {
            this.vueFilms.getBFilm1()[i].addActionListener(this);
        }
        for(int i=0; i<13; i++) {
            this.vueFilms.getBFilm14()[i].addActionListener(this);
        }
        for(int i=0; i<13; i++) {
            this.vueFilms.getBFilm10()[i].addActionListener(this);
        }
        for(int i=0; i<5; i++) {
            this.vueFilms.getBFilm12()[i].addActionListener(this);
        }
        for(int i=0; i<12; i++) {
            this.vueFilms.getBFilm9()[i].addActionListener(this);
        }
        for(int i=0; i<10; i++) {
            this.vueFilms.getBFilm4()[i].addActionListener(this);
        }

        this.vueFilms.getBRetourConnexion().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 25; i++) {

            if (e.getSource() == vueFilms.getBFilm1()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,8));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm2()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,8));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm3()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,2));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm4()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,15));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm5()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,7));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm6()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,3));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm7()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,0));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm8()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,6));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm9()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,14));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm10()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,10));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm11()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,1));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm12()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,12));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm13()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,11));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm14()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,9));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm15()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i,4));
                ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                vueInformationFilms.Afficher();
            }

            else if (e.getSource() == vueFilms.getBFilm16()[i]) {
                ModelInformationFilms modelInformationFilms = new ModelInformationFilms();
                if(i<5) {
                    VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i, 5));
                    ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                    vueInformationFilms.Afficher();
                }
                else{
                    VueInformationFilms vueInformationFilms = new VueInformationFilms(this.modelFilms.getOeuvre(i+4, 13));
                    ControllerInformationFilms controllerInformationFilms = new ControllerInformationFilms(modelInformationFilms, vueInformationFilms);
                    vueInformationFilms.Afficher();
                }
            }
        }

        if(e.getSource() == vueFilms.getBRetourConnexion()){

            ModelConnexion modelConnexion = new ModelConnexion();
            VueConnexion vueConnexion = new VueConnexion();
            ControllerConnexion controllerConnexion = new ControllerConnexion(vueConnexion, modelConnexion);
            vueConnexion.Afficher();

            vueFilms.dispose();
        }
        else if(e.getSource() == vueFilms.getBMenu()){

            ModelInterface modelInterface = new ModelInterface(this.modelFilms.getCompte(),this.modelFilms.getProfil());
            VueInterface vueInterface = new VueInterface(this.modelFilms.getCompte(),this.modelFilms.getProfil());
            ControllerInterface controllerInterface = new ControllerInterface(modelInterface, vueInterface);
            vueInterface.afficher();

            vueFilms.dispose();

        }
        if(e.getSource() == vueFilms.getBSerie()){

            ModelSeries modelSeries = new ModelSeries(this.modelFilms.getCompte(),this.modelFilms.getProfil());
            VueSeries vueSeries = new VueSeries(this.modelFilms.getCompte(),this.modelFilms.getProfil());
            ControllerSeries controllerSeries = new ControllerSeries(modelSeries, vueSeries);
            vueSeries.Afficher();

            vueFilms.dispose();
        }
    }
}
