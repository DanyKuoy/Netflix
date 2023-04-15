package org.affichage.RechercheMVC;

import org.affichage.InterfaceGraphiqueMVC.ModelInterface;
import org.affichage.InterfaceGraphiqueMVC.VueInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerRecherche implements ActionListener {

    private VueRecherche vueRecherche;
    private ModelRecherche modelRecherche;

    public ControllerRecherche(ModelRecherche modelRecherche,VueRecherche vueRecherche){
        this.vueRecherche = vueRecherche;
        this.modelRecherche = modelRecherche;

    }
    public void actionPerformed(ActionEvent e) {

    }
}
