package org.affichage.InformationFilmsMVC;

import org.affichage.FilmsMVC.ModelFilms;
import org.affichage.FilmsMVC.VueFilms;
import org.affichage.InterfaceGraphiqueMVC.ModelInterface;
import org.affichage.InterfaceGraphiqueMVC.VueInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ControllerInformationFilms implements ActionListener {

    private VueInformationFilms vueInformationFilms;
    private ModelInformationFilms modelInformationFilms;

    public ControllerInformationFilms(ModelInformationFilms modelInformationFilms, VueInformationFilms vueInformationFilms) {
    this.vueInformationFilms = vueInformationFilms;
    this.modelInformationFilms = modelInformationFilms;

    this.vueInformationFilms.getBFermerInfo().addActionListener(this);
    this.vueInformationFilms.getBRegarder().addActionListener(this);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vueInformationFilms.getBFermerInfo()){
            this.vueInformationFilms.dispose();
        }
        if(e.getSource()== this.vueInformationFilms.getBRegarder()){
                String lienVideo1 = this.vueInformationFilms.getFilm().getLienFilm();
                String path = lienVideo1.substring(0, lienVideo1.length()-1);       // Si y'a un "?" dans le lien, mettre -3
            URI lienVideo2 = null;
            try {
                lienVideo2 = new URI(path);
                Desktop.getDesktop().browse(lienVideo2);
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}


