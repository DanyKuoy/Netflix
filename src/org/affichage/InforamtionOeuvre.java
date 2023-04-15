package org.affichage;

import org.oeuvre.*;
import org.compte.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InforamtionOeuvre extends JFrame implements ActionListener {

    private JPanel panelInfoFilm = new JPanel();
    private JPanel image = new JPanel();
    private JPanel description = new JPanel();

    private JButton BFermerInfo = new JButton();

    public InforamtionOeuvre(/*Oeuvre oeuvre, Compte compte, int profil*/){

        setSize(720,1440);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        InitInfoFilm();
        setLocationRelativeTo(null);
        getContentPane().add(panelInfoFilm, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void InitInfoFilm(){

        panelInfoFilm.setPreferredSize(new Dimension(1440,720));
        panelInfoFilm.setBackground(Color.WHITE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 0;
        constraints.gridx = 0;

        BFermerInfo.setPreferredSize(new Dimension(30,30));
        BFermerInfo.addActionListener(this);

        panelInfoFilm.add(BFermerInfo,constraints);

        constraints.gridy = 1;
        image.setPreferredSize(new Dimension(1300,300));
        image.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        panelInfoFilm.add(image, constraints);

        constraints.gridy = 2;
        description.setPreferredSize(new Dimension(900,150));
        description.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        panelInfoFilm.add(description, constraints);
    }

    private void AffichageInfoFilm() {
        panelInfoFilm.setVisible(true);
        this.getContentPane().add(panelInfoFilm);
        revalidate();
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BFermerInfo){
            this.dispose();
            //new InterfaceGraphique(new Compte(),1);
        }
    }
}
