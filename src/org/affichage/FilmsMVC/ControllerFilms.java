package org.affichage.FilmsMVC;

import org.affichage.InterfaceGraphiqueMVC.*;
import org.affichage.SeriesMVC.*;
import org.affichage.ConnexionMVC.*;
import org.affichage.InforamtionOeuvre;
import org.compte.Compte;

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

        for(int i=0; i<17; i++) {
            this.vueFilms.getBFilm1()[i].addActionListener(this);
        }
        for(int i=0; i<6; i++) {
            this.vueFilms.getBFilm3()[i].addActionListener(this);
        }


/*

            this.vueFilms.getBFilm2()[i].addActionListener(this);
            this.vueFilms.getBFilm3()[i].addActionListener(this);
            this.vueFilms.getBFilm4()[i].addActionListener(this);
            this.vueFilms.getBFilm5()[i].addActionListener(this);
            this.vueFilms.getBFilm6()[i].addActionListener(this);
            this.vueFilms.getBFilm7()[i].addActionListener(this);
            this.vueFilms.getBFilm8()[i].addActionListener(this);
            this.vueFilms.getBFilm9()[i].addActionListener(this);
            this.vueFilms.getBFilm10()[i].addActionListener(this);
            this.vueFilms.getBFilm11()[i].addActionListener(this);
            this.vueFilms.getBFilm12()[i].addActionListener(this);
            this.vueFilms.getBFilm13()[i].addActionListener(this);
            this.vueFilms.getBFilm14()[i].addActionListener(this);
            this.vueFilms.getBFilm15()[i].addActionListener(this);
            this.vueFilms.getBFilm16()[i].addActionListener(this);
        }*/

        this.vueFilms.getBRetourConnexion().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 40; i++) {

            if (e.getSource() == vueFilms.getBFilm1()[i]) {
                vueFilms.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueFilms.getBFilm2()[i]) {
                vueFilms.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueFilms.getBFilm3()[i]) {
                vueFilms.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueFilms.getBFilm4()[i]) {
                vueFilms.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueFilms.getBFilm5()[i]) {
                vueFilms.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueFilms.getBFilm6()[i]) {
                vueFilms.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueFilms.getBFilm7()[i]) {
                vueFilms.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueFilms.getBFilm8()[i]) {
                vueFilms.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueFilms.getBFilm9()[i]) {
                vueFilms.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueFilms.getBFilm10()[i]) {
                vueFilms.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueFilms.getBFilm11()[i]) {
                vueFilms.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueFilms.getBFilm12()[i]) {
                vueFilms.dispose();
                new InforamtionOeuvre();
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

            ModelInterface modelInterface = new ModelInterface();
            VueInterface vueInterface = new VueInterface(new Compte(), 1);
            ControllerInterface controllerInterface = new ControllerInterface(modelInterface, vueInterface);
            vueInterface.afficher();

            vueFilms.dispose();

        }
        if(e.getSource() == vueFilms.getBSerie()){

            ModelSeries modelSeries = new ModelSeries();
            VueSeries vueSeries = new VueSeries(new Compte(), 1);
            ControllerSeries controllerSeries = new ControllerSeries(modelSeries, vueSeries);
            vueSeries.Afficher();

            vueFilms.dispose();
        }
    }
}
