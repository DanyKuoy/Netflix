package org.affichage;

import org.bdd.Bibliotheque;
import org.compte.*;
import org.oeuvre.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class InterfaceGraphique extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JPanel panelBandeau = new JPanel();
    private JPanel panelInfoFilm = new JPanel();
    private JPanel panelFilm1 = new JPanel();
    private JPanel panelFilm2 = new JPanel();
    private JPanel panelFilm3 = new JPanel();
    private JPanel panelFilm4 = new JPanel();
    private JPanel espaceFilm1 = new JPanel();
    private JPanel espaceFilm2 = new JPanel();
    private JPanel espaceFilm3 = new JPanel();
    private JPanel espaceFilm4 = new JPanel();
    private JPanel image = new JPanel();
    private JPanel description = new JPanel();

    //*Création des JScrollPane pour chaque genre de film*/
    private JScrollPane scrollPage = new JScrollPane(panel);
    private JScrollPane scrollFilm1 = new JScrollPane(panelFilm1);
    private JScrollPane scrollFilm2 = new JScrollPane(panelFilm2);
    private JScrollPane scrollFilm3 = new JScrollPane(panelFilm3);
    private JScrollPane scrollFilm4 = new JScrollPane(panelFilm4);

    private JLabel genre1 = new JLabel("Genre 1 :                                                  ");
    private JLabel genre2 = new JLabel("Genre 2 :                                                  ");
    private JLabel genre3 = new JLabel("Genre 3 :                                                  ");
    private JLabel genre4 = new JLabel("Genre 4 :                                                  ");

    private JButton BFilm = new JButton("Film");
    private JButton BSerie = new JButton("Serie");
    private JButton BRecherche = new JButton("Recherche");
    private JButton[] BFilm1 = new JButton[45];
    private JButton[] BFilm2 = new JButton[45];
    private JButton[] BFilm3 = new JButton[45];
    private JButton[] BFilm4 = new JButton[45];
    private JButton BFermerInfo = new JButton();
    private JButton BRetourConnexion = new JButton("RETOUR");

    private JTextField recherche = new JTextField(15);

    private Dimension dim = new Dimension(200, 50);
    private Dimension esp = new Dimension(1440,50);

    private Bibliotheque biblio = new Bibliotheque();

    private Map<String, ArrayList<Film>> listeFilm;
    private Map<String, ArrayList<Serie>> listeSerie;

    public InterfaceGraphique(Compte compte, int profil) {

        setSize(1440, 720);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        InitInterface();

        setContentPane(scrollPage);
        setLocationRelativeTo(null);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void InitInterface() {
        panelBandeau.setPreferredSize(new Dimension(1350, 75));
        panelBandeau.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(140, 2000));
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel espace = new JPanel();
        espace.setPreferredSize(new Dimension(300, 75));

        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        BFilm.setPreferredSize(dim);
        BSerie.setPreferredSize(dim);
        BRecherche.setPreferredSize(new Dimension(100, 25));

        constraints.gridx = 0;
        BFilm.addActionListener(this);
        panelBandeau.add(BFilm, constraints);
        constraints.gridx = 1;
        BSerie.addActionListener(this);
        panelBandeau.add(BSerie, constraints);

        panelBandeau.add(espace);

        constraints.gridx = 3;
        panelBandeau.add(recherche, constraints);
        constraints.gridx = 4;
        BRecherche.addActionListener(this);
        panelBandeau.add(BRecherche, constraints);
        constraints.gridx = 5;
        BRetourConnexion.addActionListener(this);
        panelBandeau.add(BRetourConnexion, constraints);

        panel.add(panelBandeau);

        scrollFilm1.setPreferredSize(new Dimension(1350, 150));
        scrollFilm2.setPreferredSize(new Dimension(1350, 150));
        scrollFilm3.setPreferredSize(new Dimension(1350, 150));
        scrollFilm4.setPreferredSize(new Dimension(1350, 150));

        scrollFilm1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        panelFilm1.setLayout(new GridLayout(1, 10));
        panelFilm2.setLayout(new GridLayout(1, 10));
        panelFilm3.setLayout(new GridLayout(1, 10));
        panelFilm4.setLayout(new GridLayout(1, 10));

        for (int i = 0; i < 30; i++) {
            BFilm1[i] = new JButton("Film " + i);
            BFilm2[i] = new JButton("Film " + i);
            BFilm3[i] = new JButton("Film " + i);
            BFilm4[i] = new JButton("Film " + i);

            BFilm1[i].addActionListener(this);
            BFilm2[i].addActionListener(this);
            BFilm3[i].addActionListener(this);
            BFilm4[i].addActionListener(this);

            panelFilm1.add(BFilm1[i]);
            panelFilm2.add(BFilm2[i]);
            panelFilm3.add(BFilm3[i]);
            panelFilm4.add(BFilm4[i]);
        }

        espaceFilm1.setPreferredSize(esp);
        panel.add(espaceFilm1);
        panel.add(genre1);
        panel.add(scrollFilm1);

        espaceFilm2.setPreferredSize(esp);
        panel.add(espaceFilm2);
        panel.add(genre2);
        panel.add(scrollFilm2);

        espaceFilm3.setPreferredSize(esp);
        panel.add(espaceFilm3);
        panel.add(genre3);
        panel.add(scrollFilm3);

        espaceFilm4.setPreferredSize(esp);
        panel.add(espaceFilm4);
        panel.add(genre4);
        panel.add(scrollFilm4);

        scrollPage.setViewportView(panel);
        scrollPage.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    }

    public void InitInfoFilm(/*Oeuvre oeuvre*/){
        panelInfoFilm.setPreferredSize(new Dimension(1440,720));
        BFermerInfo.setPreferredSize(new Dimension(30,30));

        image.setPreferredSize(new Dimension(1300,300));
        image.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

        description.setPreferredSize(new Dimension(900,150));
        description.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

        panelInfoFilm.add(BFermerInfo);
        panelInfoFilm.add(image);
        panelInfoFilm.add(description);
        getContentPane().add(panelInfoFilm,BorderLayout.CENTER);
        panelInfoFilm.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

  for(int i=0;i<40;i++) {
      if (e.getSource() == BFilm1[i]) {
          System.out.println("Film : " + BFilm1[i].getText());
          // Icon icon = BFilm1[i].getIcon();
          // Image image1 = ((ImageIcon) icon).getImage(); //Récupération de l'image du bouton
          // Image image2;
          // while(!image1.equals(image2)){
          // image2 = Récupération de l'image dans la base de donnée
          //}
          // Oeuvre oeuvre = Récupération de l'oeuvre
          InitInfoFilm();
          scrollPage.add(panelInfoFilm, BorderLayout.CENTER);

          i=50;
      } else if (e.getSource() == BFilm2[i]) {
          System.out.println("Film : " + BFilm1[i].getText());
          //Icon icon = BFilm2[i].getIcon();
          //Image image1 = ((ImageIcon) icon).getImage();
      } else if (e.getSource() == BFilm3[i]) {
          System.out.println("Film : " + BFilm1[i].getText());
          //Icon icon = BFilm3[i].getIcon();
          //Image image1 = ((ImageIcon) icon).getImage();
      }
  }
    if (e.getSource() == BFermerInfo){
        panelInfoFilm.setVisible(false);
    }
    if(e.getSource() == BRetourConnexion){
        this.dispose();
        new Mafenetre();
    }
}
}