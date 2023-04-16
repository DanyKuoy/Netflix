package org.affichage.SeriesMVC;

import org.affichage.ConnexionMVC.*;
import org.affichage.FilmsMVC.*;
import org.affichage.InformationSeriesMVC.ControllerInformationSeries;
import org.affichage.InformationSeriesMVC.ModelInformationSeries;
import org.affichage.InformationSeriesMVC.VueInformationSeries;
import org.affichage.InterfaceGraphiqueMVC.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerSeries implements ActionListener {

    private VueSeries vueSeries;
    private ModelSeries modelSeries;

    public ControllerSeries(ModelSeries modelSeries, VueSeries vueSeries) {
        this.vueSeries = vueSeries;
        this.modelSeries = modelSeries;

        this.vueSeries.getBMenu().addActionListener(this);
        this.vueSeries.getBFilms().addActionListener(this);
        this.vueSeries.getBRecherche().addActionListener(this);



        for(int i=0; i<11; i++) {
            this.vueSeries.getBFilm1()[i].addActionListener(this);
        }
        for(int i=0; i<0; i++) {
            this.vueSeries.getBFilm2()[i].addActionListener(this);
        }
        for(int i=0; i<18; i++) {
            this.vueSeries.getBFilm3()[i].addActionListener(this);
        }
        for(int i=0; i<10; i++) {
            this.vueSeries.getBFilm4()[i].addActionListener(this);
        }
        for(int i=0; i<14; i++) {
            this.vueSeries.getBFilm5()[i].addActionListener(this);
        }
        for(int i=0; i<21; i++) {
            this.vueSeries.getBFilm6()[i].addActionListener(this);
        }
        for(int i=0; i<13; i++) {
            this.vueSeries.getBFilm7()[i].addActionListener(this);
        }
        for(int i=0; i<3; i++) {
            this.vueSeries.getBFilm8()[i].addActionListener(this);
        }
        for(int i=0; i<10; i++) {
            this.vueSeries.getBFilm9()[i].addActionListener(this);
        }
        for(int i=0; i<11; i++) {
            this.vueSeries.getBFilm10()[i].addActionListener(this);
        }



        this.vueSeries.getBRetourConnexion().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 40; i++) {

            if (e.getSource() == vueSeries.getBFilm1()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelSeries.getOeuvre(i,5));
                ControllerInformationSeries controllerInformationFilms = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueSeries.getBFilm2()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelSeries.getOeuvre(i,1));
                ControllerInformationSeries controllerInformationFilms = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueSeries.getBFilm3()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelSeries.getOeuvre(i,9));
                ControllerInformationSeries controllerInformationFilms = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueSeries.getBFilm4()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelSeries.getOeuvre(i,3));
                ControllerInformationSeries controllerInformationFilms = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueSeries.getBFilm5()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelSeries.getOeuvre(i,6));
                ControllerInformationSeries controllerInformationFilms = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueSeries.getBFilm6()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelSeries.getOeuvre(i,7));
                ControllerInformationSeries controllerInformationFilms = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueSeries.getBFilm7()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelSeries.getOeuvre(i,0));
                ControllerInformationSeries controllerInformationFilms = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueSeries.getBFilm8()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelSeries.getOeuvre(i,1));
                ControllerInformationSeries controllerInformationFilms = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueSeries.getBFilm9()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelSeries.getOeuvre(i,4));
                ControllerInformationSeries controllerInformationFilms = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

            else if (e.getSource() == vueSeries.getBFilm10()[i]) {
                ModelInformationSeries modelInformationSeries = new ModelInformationSeries();
                VueInformationSeries vueInformationSeries = new VueInformationSeries(this.modelSeries.getOeuvre(i,2));
                ControllerInformationSeries controllerInformationFilms = new ControllerInformationSeries(modelInformationSeries, vueInformationSeries);
                vueInformationSeries.Afficher();
            }

        }

        if(e.getSource() == vueSeries.getBRetourConnexion()){

            ModelConnexion modelConnexion = new ModelConnexion();
            VueConnexion vueConnexion = new VueConnexion();
            ControllerConnexion controllerConnexion = new ControllerConnexion(vueConnexion, modelConnexion);
            vueConnexion.Afficher();

            vueSeries.dispose();
        }
        else if(e.getSource() == vueSeries.getBMenu()){

            ModelInterface modelInterface = new ModelInterface(this.modelSeries.getCompte(),this.modelSeries.getProfil());
            VueInterface vueInterface = new VueInterface(this.modelSeries.getCompte(),this.modelSeries.getProfil());
            ControllerInterface controllerInterface = new ControllerInterface(modelInterface, vueInterface);
            vueInterface.afficher();

            vueSeries.dispose();

        }
        if(e.getSource() == vueSeries.getBFilms()){

            ModelFilms modelFilms = new ModelFilms(this.modelSeries.getCompte(),this.modelSeries.getProfil());
            VueFilms vueFilms = new VueFilms(this.modelSeries.getCompte(),this.modelSeries.getProfil());
            ControllerFilms controllerFilms = new ControllerFilms(modelFilms, vueFilms);
            vueFilms.Afficher();

            vueSeries.dispose();
        }
    }
}
