package org.affichage.SeriesMVC;

import org.affichage.ConnexionMVC.*;
import org.affichage.FilmsMVC.*;
import org.affichage.InterfaceGraphiqueMVC.*;
import org.affichage.InforamtionOeuvre;
import org.compte.Compte;

import javax.swing.*;
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


        for(int i=0; i<30; i++) {


            /*  if(this.modelSeries.getBiblio().getTriSerie().get("Comédie").get(i).getImageOeuvre()!=null) {
                this.vueSeries.getBFilm1()[i].setIcon((Icon) this.modelSeries.getBiblio().getTriSerie().get("Comédie").get(i).getImageOeuvre());
            }
            else{
                this.vueSeries.remove(this.vueSeries.getBFilm1()[i]);
            }*/

            this.vueSeries.getBFilm1()[i].addActionListener(this);
            this.vueSeries.getBFilm2()[i].addActionListener(this);
            this.vueSeries.getBFilm3()[i].addActionListener(this);
            this.vueSeries.getBFilm4()[i].addActionListener(this);
            this.vueSeries.getBFilm5()[i].addActionListener(this);
            this.vueSeries.getBFilm6()[i].addActionListener(this);
            this.vueSeries.getBFilm7()[i].addActionListener(this);
            this.vueSeries.getBFilm8()[i].addActionListener(this);
            this.vueSeries.getBFilm9()[i].addActionListener(this);
            this.vueSeries.getBFilm10()[i].addActionListener(this);
            this.vueSeries.getBFilm11()[i].addActionListener(this);
            this.vueSeries.getBFilm12()[i].addActionListener(this);
            this.vueSeries.getBFilm13()[i].addActionListener(this);
            this.vueSeries.getBFilm14()[i].addActionListener(this);
            this.vueSeries.getBFilm15()[i].addActionListener(this);
            this.vueSeries.getBFilm16()[i].addActionListener(this);
        }

        this.vueSeries.getBRetourConnexion().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 40; i++) {

            if (e.getSource() == vueSeries.getBFilm1()[i]) {
                vueSeries.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueSeries.getBFilm2()[i]) {
                vueSeries.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueSeries.getBFilm3()[i]) {
                vueSeries.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueSeries.getBFilm4()[i]) {
                vueSeries.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueSeries.getBFilm5()[i]) {
                vueSeries.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueSeries.getBFilm6()[i]) {
                vueSeries.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueSeries.getBFilm7()[i]) {
                vueSeries.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueSeries.getBFilm8()[i]) {
                vueSeries.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueSeries.getBFilm9()[i]) {
                vueSeries.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueSeries.getBFilm10()[i]) {
                vueSeries.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueSeries.getBFilm11()[i]) {
                vueSeries.dispose();
                new InforamtionOeuvre();
            }

            else if (e.getSource() == vueSeries.getBFilm12()[i]) {
                vueSeries.dispose();
                new InforamtionOeuvre();
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

            ModelInterface modelInterface = new ModelInterface();
            VueInterface vueInterface = new VueInterface(new Compte(), 1);
            ControllerInterface controllerInterface = new ControllerInterface(modelInterface, vueInterface);
            vueInterface.afficher();

            vueSeries.dispose();

        }
        if(e.getSource() == vueSeries.getBFilms()){

            ModelFilms modelFilms = new ModelFilms();
            VueFilms vueFilms = new VueFilms(new Compte(), 1);
            ControllerFilms controllerFilms = new ControllerFilms(modelFilms, vueFilms);
            vueFilms.Afficher();

            vueSeries.dispose();
        }
    }
}
