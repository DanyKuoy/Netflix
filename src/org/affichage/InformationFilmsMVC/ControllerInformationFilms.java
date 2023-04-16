package org.affichage.InformationFilmsMVC;

import org.affichage.FilmsMVC.ModelFilms;
import org.affichage.FilmsMVC.VueFilms;
import org.affichage.InterfaceGraphiqueMVC.ModelInterface;
import org.affichage.InterfaceGraphiqueMVC.VueInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerInformationFilms implements ActionListener {

    private VueInformationFilms vueInformationFilms;
    private ModelInformationFilms modelInformationFilms;

    public ControllerInformationFilms(ModelInformationFilms modelInformationFilms, VueInformationFilms vueInformationFilms) {
    this.vueInformationFilms = vueInformationFilms;
    this.modelInformationFilms = modelInformationFilms;

    this.vueInformationFilms.getBFermerInfo().addActionListener(this);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vueInformationFilms.getBFermerInfo()){
            this.vueInformationFilms.dispose();
        }
    }
}


