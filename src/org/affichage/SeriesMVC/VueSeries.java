package org.affichage.SeriesMVC;

import org.affichage.FilmsMVC.ModelFilms;
import org.compte.Compte;
import org.affichage.SeriesMVC.ModelSeries;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;

public class VueSeries extends JFrame{

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


    private JLabel genre1 = new JLabel("Drame                                                                                                                                                                        ");
    private JLabel genre2 = new JLabel("Reprendre la lecture                                                                                                                                                  ");
    private JLabel genre3 = new JLabel("Comédies                                                                                                                                                                   ");
    private JLabel genre4 = new JLabel("Action et Aventure                                                                                                                                                    ");
    private JLabel genre5 = new JLabel("Romances                                                                                                                                                                  ");
    private JLabel genre6 = new JLabel("Séries Internationales                                                                                                                                                 ");
    private JLabel genre7 = new JLabel("Séries pour Ados                                                                                                                                                 ");
    private JLabel genre8 = new JLabel("Télé-réalité                                                                                                                                                                ");
    private JLabel genre9 = new JLabel("Thriller                                                                                                                                                                      ");
    private JLabel genre10 = new JLabel("Jeunesse et Famille                                                                                                                                                  ");
    private JLabel Serie = new JLabel("Séries                                                                                                                                                                            ");


    private JButton BMenu = new JButton("Menu");
    private JButton BFilms = new JButton("Films");
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

    private JButton BFermerInfo = new JButton();
    private JButton BRetourConnexion = new JButton("DECONNEXION");

    private JTextField recherche = new JTextField(15);

    private Dimension dim = new Dimension(200, 50);
    private Dimension esp = new Dimension(1440,10);

    private Compte compte;
    private int profil;

    public VueSeries(Compte compte, int profil) {
        setSize(1440, 720);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.compte = compte;
        this.profil = profil;

        InitInterface();

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

        panelBandeau.setPreferredSize(new Dimension(1350, 75));
        panelBandeau.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(140, 2800));
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel espace = new JPanel();
        espace.setBackground(Color.DARK_GRAY);
        espace.setPreferredSize(new Dimension(300, 75));

        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        ImageIcon photoIcon1 = new ImageIcon("image/logoECENETFLIX.png");
        Image image1 = photoIcon1.getImage(); // transform it
        Image newimg1 = image1.getScaledInstance(150, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        BMenu= new JButton (new ImageIcon(newimg1));
        BMenu.setPreferredSize(new Dimension(150,50));
        BFilms.setPreferredSize(dim);
        BRecherche.setPreferredSize(new Dimension(125, 25));

        constraints.gridx = 0;
        BMenu.setBackground(Color.DARK_GRAY);
        BMenu.setBorderPainted(false);
        BMenu.setFont(new Font("Arial", Font.BOLD, 15));
        BMenu.setForeground(Color.WHITE);
        panelBandeau.add(BMenu, constraints);

        constraints.gridx = 1;
        BFilms.setBackground(Color.DARK_GRAY);
        BFilms.setBorderPainted(false);
        BFilms.setFont(new Font("Arial", Font.BOLD, 15));
        BFilms.setForeground(Color.WHITE);
        panelBandeau.add(BFilms, constraints);

        panelBandeau.add(espace);

        constraints.gridx = 3;
        panelBandeau.add(recherche, constraints);

        constraints.gridx = 4;
        BRecherche.setBackground(Color.DARK_GRAY);
        BRecherche.setBorderPainted(false);
        BRecherche.setFont(new Font("Arial", Font.BOLD, 15));
        BRecherche.setForeground(Color.WHITE);
        panelBandeau.add(BRecherche, constraints);

        constraints.gridx = 5;
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


        ModelSeries modelFilms = new ModelSeries(compte,profil);

        for(int i=0; i<11; i++) {
            ImageIcon photoIcon = new ImageIcon("image/Serie/"+modelFilms.getLiens()[i][5]+".png");
            Image image = photoIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(110, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            BFilm1[i] = new JButton (new ImageIcon(newimg));
            BFilm1[i].setPreferredSize(new Dimension(110,160));
            panelFilm1.add(BFilm1[i]);
        }

        for(int i=0; i<2; i++) {
            ImageIcon photoIcon = new ImageIcon("image/Serie/"+modelFilms.getLiens()[i][8]+".png");
            Image image = photoIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(110, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            BFilm8[i] = new JButton (new ImageIcon(newimg));
            BFilm8[i].setPreferredSize(new Dimension(110,160));
            panelFilm8.add(BFilm8[i]);
        }

        for(int i=0; i<18; i++) {
            ImageIcon photoIcon = new ImageIcon("image/Serie/"+modelFilms.getLiens()[i][9]+".png");
            Image image = photoIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(110, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            BFilm3[i] = new JButton (new ImageIcon(newimg));
            BFilm3[i].setPreferredSize(new Dimension(110,160));
            panelFilm3.add(BFilm3[i]);
        }

        for(int i=0; i<10; i++) {
            System.out.println(modelFilms.getLiens()[i][1]+".png");
            ImageIcon photoIcon = new ImageIcon("image/Serie/"+modelFilms.getLiens()[i][3]+".png");
            Image image = photoIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(110, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            BFilm4[i] = new JButton (new ImageIcon(newimg));
            BFilm4[i].setPreferredSize(new Dimension(110,160));
            panelFilm4.add(BFilm4[i]);
        }

        for(int i=0; i<14; i++) {
            ImageIcon photoIcon = new ImageIcon("image/Serie/"+modelFilms.getLiens()[i][6]+".png");
            Image image = photoIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(110, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            BFilm5[i] = new JButton (new ImageIcon(newimg));
            BFilm5[i].setPreferredSize(new Dimension(110,160));
            panelFilm5.add(BFilm5[i]);
        }

        for(int i=0; i<21; i++) {
            ImageIcon photoIcon = new ImageIcon("image/Serie/"+modelFilms.getLiens()[i][7]+".png");
            Image image = photoIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(110, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            BFilm6[i] = new JButton (new ImageIcon(newimg));
            BFilm6[i].setPreferredSize(new Dimension(110,160));
            panelFilm6.add(BFilm6[i]);
        }

        for(int i=0; i<13; i++) {
            ImageIcon photoIcon = new ImageIcon("image/Serie/"+modelFilms.getLiens()[i][0]+".png");
            Image image = photoIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(110, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            BFilm7[i] = new JButton (new ImageIcon(newimg));
            BFilm7[i].setPreferredSize(new Dimension(110,160));
            panelFilm7.add(BFilm7[i]);
        }
        for(int i=0; i<3; i++) {
            ImageIcon photoIcon = new ImageIcon("image/Serie/"+modelFilms.getLiens()[i][1]+".png");
            Image image = photoIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(110, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            BFilm8[i+2] = new JButton (new ImageIcon(newimg));
            BFilm8[i+2].setPreferredSize(new Dimension(110,160));
            panelFilm8.add(BFilm8[i+2]);
        }
        for(int i=0; i<10; i++) {
            ImageIcon photoIcon = new ImageIcon("image/Serie/"+modelFilms.getLiens()[i][4]+".png");
            Image image = photoIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(110, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            BFilm9[i] = new JButton (new ImageIcon(newimg));
            BFilm9[i].setPreferredSize(new Dimension(110,160));
            panelFilm9.add(BFilm9[i]);
        }
        for(int i=0; i<11; i++) {
            ImageIcon photoIcon = new ImageIcon("image/Serie/"+modelFilms.getLiens()[i][2]+".png");
            Image image = photoIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(110, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            BFilm10[i] = new JButton (new ImageIcon(newimg));
            BFilm10[i].setPreferredSize(new Dimension(110,160));
            panelFilm10.add(BFilm10[i]);
        }


        Serie.setFont(new Font("Arial", Font.BOLD, 50));
        Serie.setForeground(Color.white);
        panel.add(Serie);

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


        scrollPage.setViewportView(panel);
        scrollPage.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    }

    public void Afficher(){
        setContentPane(scrollPage);
        setLocationRelativeTo(null);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getBMenu() {
        return BMenu;
    }
    public JButton getBFilms() {
        return BFilms;
    }
    public JButton getBRecherche() {
        return BRecherche;
    }
    public JButton[] getBFilm1() {
        return BFilm1;
    }
    public JButton[] getBFilm2() {
        return BFilm2;
    }
    public JButton[] getBFilm3() {
        return BFilm3;
    }
    public JButton[] getBFilm4() {
        return BFilm4;
    }
    public JButton[] getBFilm5() {
        return BFilm5;
    }
    public JButton[] getBFilm6() {
        return BFilm6;
    }
    public JButton[] getBFilm7() {
        return BFilm7;
    }
    public JButton[] getBFilm8() {
        return BFilm8;
    }
    public JButton[] getBFilm9() {
        return BFilm9;
    }
    public JButton[] getBFilm10() {
        return BFilm10;
    }
    public JButton getBRetourConnexion() {
        return BRetourConnexion;
    }
    public String getRecherche(){return recherche.getText();}

}
