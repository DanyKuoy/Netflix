package org.affichage.InformationSeriesMVC;

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

public class ControllerInformationSeries implements ActionListener {

    private VueInformationSeries vueInformationSeries;
    private ModelInformationSeries modelInformationSeries;

    public ControllerInformationSeries(ModelInformationSeries modelInformationSeries, VueInformationSeries vueInformationSeries) {
        this.vueInformationSeries = vueInformationSeries;
        this.modelInformationSeries = modelInformationSeries;

        this.vueInformationSeries.getBFermerInfo().addActionListener(this);
        for(int i=0;i<this.vueInformationSeries.getSeries().getNbSaisons();i++) {
            for(int j=0;j<this.vueInformationSeries.getSeries().getListeEpisodes().get(i).size();j++) {
                this.vueInformationSeries.getBRegarder(i, j).addActionListener(this);
            }
        }
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vueInformationSeries.getBFermerInfo()){
            this.vueInformationSeries.dispose();
        }
        for(int i=0;i<6;i++) {
            for (int j = 0; j < 30; j++) {
                if (e.getSource() == this.vueInformationSeries.getBRegarder(i,j)) {
                    String lienVideo1 = this.vueInformationSeries.getSeries().getListeEpisodes().get(i).get(j).getLienEpisode();
                    String path = lienVideo1.substring(0, lienVideo1.length() - 1);       // Si y'a un "?" dans le lien, mettre -3
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
    }
}


