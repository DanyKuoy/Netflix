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
    private JPanel panelFilm5 = new JPanel();
    private JPanel panelFilm6 = new JPanel();
    private JPanel panelFilm7 = new JPanel();
    private JPanel panelFilm8 = new JPanel();
    private JPanel panelFilm9 = new JPanel();
    private JPanel panelFilm10 = new JPanel();
    private JPanel panelFilm11 = new JPanel();
    private JPanel panelFilm12 = new JPanel();
    private JPanel espaceFilm1 = new JPanel();
    private JPanel espaceFilm2 = new JPanel();
    private JPanel espaceFilm3 = new JPanel();
    private JPanel espaceFilm4 = new JPanel();
    private JPanel espaceFilm5 = new JPanel();
    private JPanel espaceFilm6 = new JPanel();
    private JPanel espaceFilm7 = new JPanel();
    private JPanel espaceFilm8 = new JPanel();
    private JPanel espaceFilm9 = new JPanel();
    private JPanel espaceFilm10 = new JPanel();
    private JPanel espaceFilm11 = new JPanel();
    private JPanel espaceFilm12 = new JPanel();
    private JPanel image = new JPanel();
    private JPanel description = new JPanel();

    //*Création des JScrollPane pour chaque genre de film*/
    private JScrollPane scrollPage = new JScrollPane(panel);
    private JScrollPane scrollFilm1 = new JScrollPane(panelFilm1);
    private JScrollPane scrollFilm2 = new JScrollPane(panelFilm2);
    private JScrollPane scrollFilm3 = new JScrollPane(panelFilm3);
    private JScrollPane scrollFilm4 = new JScrollPane(panelFilm4);
    private JScrollPane scrollFilm5 = new JScrollPane(panelFilm5);
    private JScrollPane scrollFilm6 = new JScrollPane(panelFilm6);
    private JScrollPane scrollFilm7 = new JScrollPane(panelFilm7);
    private JScrollPane scrollFilm8 = new JScrollPane(panelFilm8);
    private JScrollPane scrollFilm9 = new JScrollPane(panelFilm9);
    private JScrollPane scrollFilm10 = new JScrollPane(panelFilm10);
    private JScrollPane scrollFilm11 = new JScrollPane(panelFilm11);
    private JScrollPane scrollFilm12 = new JScrollPane(panelFilm12);

    private JLabel genre1 = new JLabel("Films Comiques                                                                                                                                                               ");
    private JLabel genre2 = new JLabel("Films d'Actions et d'Aventures                                                                                                                                       ");
    private JLabel genre3 = new JLabel("Films Dramatiques                                                                                                                                                           ");
    private JLabel genre4 = new JLabel("Séries pour ados                                                                                                                                                              ");
    private JLabel genre5 = new JLabel("Films Fantastiques                                                                                                                                                           ");
    private JLabel genre6 = new JLabel("Séries Dramatiques                                                                                                                                                          ");
    private JLabel genre7 = new JLabel("Films Primés                                                                                                                                                                    ");
    private JLabel genre8 = new JLabel("Séries Comiques                                                                                                                                                              ");
    private JLabel genre9 = new JLabel("Films d'Horreur                                                                                                                                                                ");
    private JLabel genre10 = new JLabel("Séries de Science-Fiction                                                                                                                                                ");
    private JLabel genre11 = new JLabel("Séries Documentaires                                                                                                                                                       ");
    private JLabel genre12 = new JLabel("Films Romantiques                                                                                                                                                           ");

    private JButton BFilm = new JButton("Films");
    private JButton BSerie = new JButton("Séries");
    private JButton BRecherche = new JButton("Recherche");
    private JButton[] BFilm1 = new JButton[45];
    private JButton[] BFilm2 = new JButton[45];
    private JButton[] BFilm3 = new JButton[45];
    private JButton[] BFilm4 = new JButton[45];
    private JButton[] BFilm5 = new JButton[45];
    private JButton[] BFilm6 = new JButton[45];
    private JButton[] BFilm7 = new JButton[45];
    private JButton[] BFilm8 = new JButton[45];
    private JButton[] BFilm9 = new JButton[45];
    private JButton[] BFilm10 = new JButton[45];
    private JButton[] BFilm11 = new JButton[45];
    private JButton[] BFilm12 = new JButton[45];
    private JButton BFermerInfo = new JButton();
    private JButton BRetourConnexion = new JButton("DECONNEXION");

    private JTextField recherche = new JTextField(15);

    private Dimension dim = new Dimension(200, 50);
    private Dimension esp = new Dimension(1440,10);

    private Bibliotheque biblio = new Bibliotheque();

    private Map<String, ArrayList<Film>> listeFilm;
    private Map<String, ArrayList<Serie>> listeSerie;

    private ArrayList<Film> Action;
    private ArrayList<Film> Comedie;
    private ArrayList<Film> SciFi;
    private ArrayList<Film> Fantastique;
    private ArrayList<Film> Francais;
    private ArrayList<Film> Policier;
    private ArrayList<Film> Horreur;

    public InterfaceGraphique(Compte compte, int profil) {

        listeFilm = biblio.getTriFilm();
        listeSerie = biblio.getTriSerie();

        Action = listeFilm.get("Action");
        Comedie = listeFilm.get("Comedie");
        SciFi = listeFilm.get("SF");
        Fantastique = listeFilm.get("Fantastique");
        Francais = listeFilm.get("Français");
        Policier = listeFilm.get("Policier");
        Horreur = listeFilm.get("Horreur");

        setSize(1440, 720);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        InitInterface();

        setContentPane(scrollPage);
        setLocationRelativeTo(null);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void InitInterface() {

        panel.setBackground(Color.DARK_GRAY);
        panelBandeau.setBackground(Color.DARK_GRAY);
        espaceFilm1.setBackground(Color.DARK_GRAY);
        espaceFilm2.setBackground(Color.DARK_GRAY);
        espaceFilm3.setBackground(Color.DARK_GRAY);
        espaceFilm4.setBackground(Color.DARK_GRAY);
        espaceFilm5.setBackground(Color.DARK_GRAY);
        espaceFilm6.setBackground(Color.DARK_GRAY);
        espaceFilm7.setBackground(Color.DARK_GRAY);
        espaceFilm8.setBackground(Color.DARK_GRAY);
        espaceFilm9.setBackground(Color.DARK_GRAY);
        espaceFilm10.setBackground(Color.DARK_GRAY);
        espaceFilm11.setBackground(Color.DARK_GRAY);
        espaceFilm12.setBackground(Color.DARK_GRAY);

        panelBandeau.setPreferredSize(new Dimension(1350, 75));
        panelBandeau.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(140, 3125));
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel espace = new JPanel();
        espace.setBackground(Color.DARK_GRAY);
        espace.setPreferredSize(new Dimension(300, 75));

        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        BFilm.setPreferredSize(dim);
        BSerie.setPreferredSize(dim);
        BRecherche.setPreferredSize(new Dimension(125, 25));

        constraints.gridx = 0;
        BFilm.addActionListener(this);
        BFilm.setBackground(Color.DARK_GRAY);
        BFilm.setBorderPainted(false);
        BFilm.setFont(new Font("Arial", Font.BOLD, 15));
        BFilm.setForeground(Color.WHITE);
        panelBandeau.add(BFilm, constraints);
        constraints.gridx = 1;
        BSerie.addActionListener(this);
        BSerie.setBackground(Color.DARK_GRAY);
        BSerie.setBorderPainted(false);
        BSerie.setFont(new Font("Arial", Font.BOLD, 15));
        BSerie.setForeground(Color.WHITE);
        panelBandeau.add(BSerie, constraints);

        panelBandeau.add(espace);

        constraints.gridx = 3;
        panelBandeau.add(recherche, constraints);
        constraints.gridx = 4;
        BRecherche.addActionListener(this);
        BRecherche.setBackground(Color.DARK_GRAY);
        BRecherche.setBorderPainted(false);
        BRecherche.setFont(new Font("Arial", Font.BOLD, 15));
        BRecherche.setForeground(Color.WHITE);
        panelBandeau.add(BRecherche, constraints);
        constraints.gridx = 5;
        BRetourConnexion.addActionListener(this);
        BRetourConnexion.setBackground(Color.DARK_GRAY);
        BRetourConnexion.setBorderPainted(false);
        BRetourConnexion.setFont(new Font("Arial", Font.BOLD, 15));
        BRetourConnexion.setForeground(Color.WHITE);
        panelBandeau.add(BRetourConnexion, constraints);

        panel.add(panelBandeau);

        scrollFilm1.setPreferredSize(new Dimension(1300, 200));
        scrollFilm2.setPreferredSize(new Dimension(1300, 200));
        scrollFilm3.setPreferredSize(new Dimension(1300, 200));
        scrollFilm4.setPreferredSize(new Dimension(1300, 200));
        scrollFilm5.setPreferredSize(new Dimension(1300, 200));
        scrollFilm6.setPreferredSize(new Dimension(1300, 200));
        scrollFilm7.setPreferredSize(new Dimension(1300, 200));
        scrollFilm8.setPreferredSize(new Dimension(1300, 200));
        scrollFilm9.setPreferredSize(new Dimension(1300, 200));
        scrollFilm10.setPreferredSize(new Dimension(1300, 200));
        scrollFilm11.setPreferredSize(new Dimension(1300, 200));
        scrollFilm12.setPreferredSize(new Dimension(1300, 200));

        scrollFilm1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm5.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm6.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm7.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm8.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm9.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm10.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm11.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm12.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        BoxLayout boxLayout = new BoxLayout(panelFilm1, BoxLayout.Y_AXIS); // BoxLayout avec un alignement vertical
        panelFilm1.setLayout(boxLayout);

        panelFilm1.setLayout(new GridLayout(1, 1));
        panelFilm2.setLayout(new GridLayout(1, 1));
        panelFilm3.setLayout(new GridLayout(1, 1));
        panelFilm4.setLayout(new GridLayout(1, 1));
        panelFilm5.setLayout(new GridLayout(1, 1));
        panelFilm6.setLayout(new GridLayout(1, 1));
        panelFilm7.setLayout(new GridLayout(1, 1));
        panelFilm8.setLayout(new GridLayout(1, 1));
        panelFilm9.setLayout(new GridLayout(1, 1));
        panelFilm10.setLayout(new GridLayout(1,1));
        panelFilm11.setLayout(new GridLayout(1,1));
        panelFilm12.setLayout(new GridLayout(1,1));


        for (int i = 0; i < 30; i++) {
            BFilm1[i] = new JButton("Film " + i);
            BFilm1[i].setSize(100,150);
            BFilm1[i].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            BFilm1[i].addActionListener(this);
            panelFilm1.add(BFilm1[i]);
        }
        for (int i = 0; i < 30; i++) {
            constraints.gridx = i;
            BFilm2[i] = new JButton("Film " + i);
            BFilm2[i].setSize(100,150);
            BFilm2[i].addActionListener(this);
            panelFilm2.add(BFilm2[i],constraints);
        }
        for (int i = 0; i < 30; i++) {
            constraints.gridx = 5*i;
            BFilm3[i] = new JButton("Film " + i);
            BFilm3[i].setSize(100,150);
            BFilm3[i].addActionListener(this);
            panelFilm3.add(BFilm3[i],constraints);
        }
        for (int i = 0; i < 30; i++) {
            constraints.gridx = 5*i;
            BFilm4[i] = new JButton("Film " + i);
            BFilm4[i].setSize(100,150);
            BFilm4[i].addActionListener(this);
            panelFilm4.add(BFilm4[i],constraints);
        }
        for (int i = 0; i < 30; i++) {
            constraints.gridx = 5*i;
            BFilm5[i] = new JButton("Film " + i);
            BFilm5[i].setSize(100,150);
            BFilm5[i].addActionListener(this);
            panelFilm5.add(BFilm5[i],constraints);
        }
        for (int i = 0; i < 30; i++) {
            constraints.gridx = 5*i;
            BFilm6[i] = new JButton("Film " + i);
            BFilm6[i].setSize(100,150);
            BFilm6[i].addActionListener(this);
            panelFilm6.add(BFilm6[i],constraints);
        }
        for (int i = 0; i < 30; i++) {
            constraints.gridx = 5*i;
            BFilm7[i] = new JButton("Film " + i);
            BFilm7[i].setSize(100,150);
            BFilm7[i].addActionListener(this);
            panelFilm7.add(BFilm7[i],constraints);
        }
        for (int i = 0; i < 30; i++) {
            constraints.gridx = 5*i;
            BFilm8[i] = new JButton("Film " + i);
            BFilm8[i].setSize(100,150);
            BFilm8[i].addActionListener(this);
            panelFilm8.add(BFilm8[i],constraints);
        }
        for (int i = 0; i < 30; i++) {
            constraints.gridx = 5*i;
            BFilm9[i] = new JButton("Film " + i);
            BFilm9[i].setSize(100,150);
            BFilm9[i].addActionListener(this);
            panelFilm9.add(BFilm9[i],constraints);
        }
        for (int i = 0; i < 30; i++) {
            constraints.gridx = 5*i;
            BFilm10[i] = new JButton("Film " + i);
            BFilm10[i].setSize(100,150);
            BFilm10[i].addActionListener(this);
            panelFilm10.add(BFilm10[i],constraints);
        }
        for (int i = 0; i < 30; i++) {
            constraints.gridx = 5*i;
            BFilm11[i] = new JButton("Film " + i);
            BFilm11[i].setSize(100,150);
            BFilm11[i].addActionListener(this);
            panelFilm11.add(BFilm11[i],constraints);
        }
        for (int i = 0; i < 30; i++) {
            constraints.gridx = 5*i;
            BFilm12[i] = new JButton("Film " + i);
            BFilm12[i].setSize(100,150);
            BFilm12[i].addActionListener(this);
            panelFilm12.add(BFilm12[i],constraints);
        }

        espaceFilm1.setPreferredSize(esp);
        panel.add(espaceFilm1);
        genre1.setFont(new Font("Arial", Font.BOLD, 24));
        genre1.setForeground(Color.WHITE);
        panel.add(genre1);
        panel.add(scrollFilm1);

        espaceFilm2.setPreferredSize(esp);
        panel.add(espaceFilm2);
        genre2.setFont(new Font("Arial", Font.BOLD, 24));
        genre2.setForeground(Color.WHITE);
        panel.add(genre2);
        panel.add(scrollFilm2);

        espaceFilm3.setPreferredSize(esp);
        panel.add(espaceFilm3);
        genre3.setFont(new Font("Arial", Font.BOLD, 24));
        genre3.setForeground(Color.WHITE);
        panel.add(genre3);
        panel.add(scrollFilm3);

        espaceFilm4.setPreferredSize(esp);
        panel.add(espaceFilm4);
        genre4.setFont(new Font("Arial", Font.BOLD, 24));
        genre4.setForeground(Color.WHITE);
        panel.add(genre4);
        panel.add(scrollFilm4);

        espaceFilm5.setPreferredSize(esp);
        panel.add(espaceFilm5);
        genre5.setFont(new Font("Arial", Font.BOLD, 24));
        genre5.setForeground(Color.WHITE);
        panel.add(genre5);
        panel.add(scrollFilm5);

        espaceFilm6.setPreferredSize(esp);
        panel.add(espaceFilm6);
        genre6.setFont(new Font("Arial", Font.BOLD, 24));
        genre6.setForeground(Color.WHITE);
        panel.add(genre6);
        panel.add(scrollFilm6);

        espaceFilm7.setPreferredSize(esp);
        panel.add(espaceFilm7);
        genre7.setFont(new Font("Arial", Font.BOLD, 24));
        genre7.setForeground(Color.WHITE);
        panel.add(genre7);
        panel.add(scrollFilm7);

        espaceFilm8.setPreferredSize(esp);
        panel.add(espaceFilm8);
        genre8.setFont(new Font("Arial", Font.BOLD, 24));
        genre8.setForeground(Color.WHITE);
        panel.add(genre8);
        panel.add(scrollFilm8);

        espaceFilm9.setPreferredSize(esp);
        panel.add(espaceFilm9);
        genre9.setFont(new Font("Arial", Font.BOLD, 24));
        genre9.setForeground(Color.WHITE);
        panel.add(genre9);
        panel.add(scrollFilm9);

        espaceFilm10.setPreferredSize(esp);
        panel.add(espaceFilm10);
        genre10.setFont(new Font("Arial", Font.BOLD, 24));
        genre10.setForeground(Color.WHITE);
        panel.add(genre10);
        panel.add(scrollFilm10);

        espaceFilm11.setPreferredSize(esp);
        panel.add(espaceFilm11);
        genre11.setFont(new Font("Arial", Font.BOLD, 24));
        genre11.setForeground(Color.WHITE);
        panel.add(genre11);
        panel.add(scrollFilm11);

        espaceFilm12.setPreferredSize(esp);
        panel.add(espaceFilm12);
        genre12.setFont(new Font("Arial", Font.BOLD, 24));
        genre12.setForeground(Color.WHITE);
        panel.add(genre12);
        panel.add(scrollFilm12);

        scrollPage.setViewportView(panel);
        scrollPage.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

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
        panel.setVisible(false);
        this.getContentPane().add(panelInfoFilm);
        revalidate();
        repaint();
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
          AffichageInfoFilm();
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
        panel.setVisible(true);
        InitInterface();
    }
    if(e.getSource() == BRetourConnexion){
        this.dispose();
        new Mafenetre();
    }
}
}