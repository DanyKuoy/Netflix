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

public class Series extends JFrame implements ActionListener {
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
    private JPanel panelFilm13 = new JPanel();
    private JPanel panelFilm14 = new JPanel();
    private JPanel panelFilm15 = new JPanel();
    private JPanel panelFilm16 = new JPanel();

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
    private JPanel espaceFilm13 = new JPanel();
    private JPanel espaceFilm14 = new JPanel();
    private JPanel espaceFilm15 = new JPanel();
    private JPanel espaceFilm16 = new JPanel();

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
    private JScrollPane scrollFilm13 = new JScrollPane(panelFilm13);
    private JScrollPane scrollFilm14 = new JScrollPane(panelFilm14);
    private JScrollPane scrollFilm15 = new JScrollPane(panelFilm15);
    private JScrollPane scrollFilm16 = new JScrollPane(panelFilm16);

    private JLabel genre1 = new JLabel("Drame                                                                                                                                                                        ");
    private JLabel genre2 = new JLabel("Reprendre la lecture                                                                                                                                                  ");
    private JLabel genre3 = new JLabel("Fantasique                                                                                                                                                                 ");
    private JLabel genre4 = new JLabel("Comédies                                                                                                                                                                   ");
    private JLabel genre5 = new JLabel("Science-Fiction                                                                                                                                                         ");
    private JLabel genre6 = new JLabel("Action et Aventure                                                                                                                                                    ");
    private JLabel genre7 = new JLabel("Horreur                                                                                                                                                                       ");
    private JLabel genre8 = new JLabel("Romances                                                                                                                                                                  ");
    private JLabel genre9 = new JLabel("Animés                                                                                                                                                                      ");
    private JLabel genre10 = new JLabel("Documentaires                                                                                                                                                           ");
    private JLabel genre11 = new JLabel("Séries Internationales                                                                                                                                                 ");
    private JLabel genre12 = new JLabel("Séries pour Ados                                                                                                                                                 ");
    private JLabel genre13 = new JLabel("Télé-réalité                                                                                                                                                                ");
    private JLabel genre14 = new JLabel("Thriller                                                                                                                                                                      ");
    private JLabel genre15 = new JLabel("Jeunesse et Famille                                                                                                                                                  ");
    private JLabel genre16 = new JLabel("Mini-séries                                                                                                                                                  ");


    private JButton BMenu = new JButton("Menu");
    private JButton BFilm = new JButton("Films");
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
    private JButton[] BFilm13 = new JButton[45];
    private JButton[] BFilm14 = new JButton[45];
    private JButton[] BFilm15 = new JButton[45];
    private JButton[] BFilm16 = new JButton[45];

    private JButton BFermerInfo = new JButton();
    private JButton BRetourConnexion = new JButton("DECONNEXION");

    private JTextField recherche = new JTextField(15);

    private Dimension dim = new Dimension(200, 50);
    private Dimension esp = new Dimension(1440,10);

    private Bibliotheque biblio = new Bibliotheque();

    private Map<String, ArrayList<Film>> listeFilm;

    private ArrayList<Film> Action;
    private ArrayList<Film> Comedie;
    private ArrayList<Film> SciFi;
    private ArrayList<Film> Fantastique;
    private ArrayList<Film> Francais;
    private ArrayList<Film> Policier;
    private ArrayList<Film> Horreur;

    public Series(Compte compte, int profil) {

        listeFilm = biblio.getTriFilm();

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
        espaceFilm13.setBackground(Color.DARK_GRAY);
        espaceFilm14.setBackground(Color.DARK_GRAY);
        espaceFilm15.setBackground(Color.DARK_GRAY);
        espaceFilm16.setBackground(Color.DARK_GRAY);

        panelBandeau.setPreferredSize(new Dimension(1350, 75));
        panelBandeau.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(140, 4150));
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel espace = new JPanel();
        espace.setBackground(Color.DARK_GRAY);
        espace.setPreferredSize(new Dimension(300, 75));

        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        BMenu.setPreferredSize(dim);
        BFilm.setPreferredSize(dim);
        BRecherche.setPreferredSize(new Dimension(125, 25));

        constraints.gridx = 0;
        BMenu.addActionListener(this);
        BMenu.setBackground(Color.DARK_GRAY);
        BMenu.setBorderPainted(false);
        BMenu.setFont(new Font("Arial", Font.BOLD, 15));
        BMenu.setForeground(Color.WHITE);
        panelBandeau.add(BMenu, constraints);
        constraints.gridx = 1;
        BFilm.addActionListener(this);
        BFilm.setBackground(Color.DARK_GRAY);
        BFilm.setBorderPainted(false);
        BFilm.setFont(new Font("Arial", Font.BOLD, 15));
        BFilm.setForeground(Color.WHITE);
        panelBandeau.add(BFilm, constraints);

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
        scrollFilm13.setPreferredSize(new Dimension(1300, 200));
        scrollFilm14.setPreferredSize(new Dimension(1300, 200));
        scrollFilm15.setPreferredSize(new Dimension(1300, 200));
        scrollFilm16.setPreferredSize(new Dimension(1300, 200));

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
        scrollFilm13.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm14.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm15.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollFilm16.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        BoxLayout boxLayout = new BoxLayout(panelFilm1, BoxLayout.Y_AXIS); // BoxLayout avec un alignement vertical
        panelFilm1.setLayout(boxLayout);

        panelFilm1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm3.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm4.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm5.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm6.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm7.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm8.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm9.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm10.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm11.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm12.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm13.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm14.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm15.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelFilm16.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        panelFilm1.setBackground(Color.darkGray);
        panelFilm2.setBackground(Color.darkGray);
        panelFilm3.setBackground(Color.darkGray);
        panelFilm4.setBackground(Color.darkGray);
        panelFilm5.setBackground(Color.darkGray);
        panelFilm6.setBackground(Color.darkGray);
        panelFilm7.setBackground(Color.darkGray);
        panelFilm8.setBackground(Color.darkGray);
        panelFilm9.setBackground(Color.darkGray);
        panelFilm10.setBackground(Color.darkGray);
        panelFilm11.setBackground(Color.darkGray);
        panelFilm12.setBackground(Color.darkGray);
        panelFilm13.setBackground(Color.darkGray);
        panelFilm14.setBackground(Color.darkGray);
        panelFilm15.setBackground(Color.darkGray);
        panelFilm16.setBackground(Color.darkGray);

        scrollFilm1.setBorder(null);
        scrollFilm2.setBorder(null);
        scrollFilm3.setBorder(null);
        scrollFilm4.setBorder(null);
        scrollFilm5.setBorder(null);
        scrollFilm6.setBorder(null);
        scrollFilm7.setBorder(null);
        scrollFilm8.setBorder(null);
        scrollFilm9.setBorder(null);
        scrollFilm10.setBorder(null);
        scrollFilm11.setBorder(null);
        scrollFilm12.setBorder(null);
        scrollFilm13.setBorder(null);
        scrollFilm14.setBorder(null);
        scrollFilm15.setBorder(null);
        scrollFilm16.setBorder(null);

        for (int i = 0; i < 30; i++) {
            BFilm1[i] = new JButton("Série " + i);
            BFilm1[i].setPreferredSize(new Dimension(110,160));
            BFilm1[i].addActionListener(this);
            panelFilm1.add(BFilm1[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm2[i] = new JButton("Série " + i);
            BFilm2[i].setPreferredSize(new Dimension(110,160));
            BFilm2[i].addActionListener(this);
            panelFilm2.add(BFilm2[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm3[i] = new JButton("Série " + i);
            BFilm3[i].setPreferredSize(new Dimension(110,160));
            BFilm3[i].addActionListener(this);
            panelFilm3.add(BFilm3[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm4[i] = new JButton("Série " + i);
            BFilm4[i].setPreferredSize(new Dimension(110,160));
            BFilm4[i].addActionListener(this);
            panelFilm4.add(BFilm4[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm5[i] = new JButton("Série " + i);
            BFilm5[i].setPreferredSize(new Dimension(110,160));
            BFilm5[i].addActionListener(this);
            panelFilm5.add(BFilm5[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm6[i] = new JButton("Série " + i);
            BFilm6[i].setPreferredSize(new Dimension(110,160));
            BFilm6[i].addActionListener(this);
            panelFilm6.add(BFilm6[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm7[i] = new JButton("Série " + i);
            BFilm7[i].setPreferredSize(new Dimension(110,160));
            BFilm7[i].addActionListener(this);
            panelFilm7.add(BFilm7[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm8[i] = new JButton("Série " + i);
            BFilm8[i].setPreferredSize(new Dimension(110,160));
            BFilm8[i].addActionListener(this);
            panelFilm8.add(BFilm8[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm9[i] = new JButton("Série " + i);
            BFilm9[i].setPreferredSize(new Dimension(110,160));
            BFilm9[i].addActionListener(this);
            panelFilm9.add(BFilm9[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm10[i] = new JButton("Série " + i);
            BFilm10[i].setPreferredSize(new Dimension(110,160));
            BFilm10[i].addActionListener(this);
            panelFilm10.add(BFilm10[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm11[i] = new JButton("Série " + i);
            BFilm11[i].setPreferredSize(new Dimension(110,160));
            BFilm11[i].addActionListener(this);
            panelFilm11.add(BFilm11[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm12[i] = new JButton("Série " + i);
            BFilm12[i].setPreferredSize(new Dimension(110,160));
            BFilm12[i].addActionListener(this);
            panelFilm12.add(BFilm12[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm13[i] = new JButton("Série " + i);
            BFilm13[i].setPreferredSize(new Dimension(110,160));
            BFilm13[i].addActionListener(this);
            panelFilm13.add(BFilm13[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm14[i] = new JButton("Série " + i);
            BFilm14[i].setPreferredSize(new Dimension(110,160));
            BFilm14[i].addActionListener(this);
            panelFilm14.add(BFilm14[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm15[i] = new JButton("Série " + i);
            BFilm15[i].setPreferredSize(new Dimension(110,160));
            BFilm15[i].addActionListener(this);
            panelFilm15.add(BFilm15[i]);
        }
        for (int i = 0; i < 30; i++) {
            BFilm16[i] = new JButton("Série " + i);
            BFilm16[i].setPreferredSize(new Dimension(110,160));
            BFilm16[i].addActionListener(this);
            panelFilm16.add(BFilm16[i]);
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

        espaceFilm13.setPreferredSize(esp);
        panel.add(espaceFilm13);
        genre13.setFont(new Font("Arial", Font.BOLD, 24));
        genre13.setForeground(Color.WHITE);
        panel.add(genre13);
        panel.add(scrollFilm13);

        espaceFilm14.setPreferredSize(esp);
        panel.add(espaceFilm14);
        genre14.setFont(new Font("Arial", Font.BOLD, 24));
        genre14.setForeground(Color.WHITE);
        panel.add(genre14);
        panel.add(scrollFilm14);

        espaceFilm15.setPreferredSize(esp);
        panel.add(espaceFilm15);
        genre15.setFont(new Font("Arial", Font.BOLD, 24));
        genre15.setForeground(Color.WHITE);
        panel.add(genre15);
        panel.add(scrollFilm15);

        espaceFilm16.setPreferredSize(esp);
        panel.add(espaceFilm16);
        genre16.setFont(new Font("Arial", Font.BOLD, 24));
        genre16.setForeground(Color.WHITE);
        panel.add(genre16);
        panel.add(scrollFilm16);

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

        for (int i = 0; i < 40; i++) {
            if (e.getSource() == BFilm1[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();

            }
            else if (e.getSource() == BFilm2[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm3[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm4[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm5[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm6[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm7[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm8[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm9[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm10[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm11[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm12[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm13[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm14[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm15[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }
            else if (e.getSource() == BFilm16[i]) {
                System.out.println("Film : " + BFilm1[i].getText());

                this.dispose();
                new InforamtionOeuvre();
            }

        }
        if (e.getSource() == BFermerInfo){
            panelInfoFilm.setVisible(false);
            panel.setVisible(true);
            InitInterface();
        }
        if(e.getSource() == BRetourConnexion){
            new Mafenetre();
            this.dispose();
        }
        if(e.getSource() == BFilm){
            new Films(new Compte(),1);
            this.dispose();
        }
        if(e.getSource() == BMenu){
            new InterfaceGraphique(new Compte(),1);
            this.dispose();
        }
    }
}
