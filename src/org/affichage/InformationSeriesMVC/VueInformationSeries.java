package org.affichage.InformationSeriesMVC;

import org.oeuvre.Serie;
import org.compte.*;

import javax.swing.*;
import java.awt.*;

public class VueInformationSeries extends JFrame{


    private JPanel panelInfoSeries = new JPanel();
    private JScrollPane scrollPage = new JScrollPane(panelInfoSeries);
    private JPanel image = new JPanel();
    private JPanel description = new JPanel();
    private JLabel descriptionFilm = new JLabel();
    private JLabel duree = new JLabel();
    private JLabel acteurs = new JLabel();
    private JLabel real = new JLabel();
    private JLabel titre = new JLabel();
    private JLabel espace = new JLabel();
    private JLabel espace1 = new JLabel();
    private JLabel espace2 = new JLabel();
    private JLabel espace3 = new JLabel();
    private Serie serie;
    private String descri;
    private String acteur;

    private JButton BFermerInfo = new JButton();
    private JButton[][] BRegarder = new JButton[4][30];
    private JLabel[] Saison = new JLabel[4];

    public VueInformationSeries(Serie serie){

        this.serie = serie;

        setSize(720,1440);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        InitInfoFilm();
        setLocationRelativeTo(null);
        getContentPane().add(scrollPage, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Fin classe");
    }

    private void InitInfoFilm(){

        panelInfoSeries.setPreferredSize(new Dimension(1440,4000));
        panelInfoSeries.setBackground(Color.DARK_GRAY);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 0;
        constraints.gridx = 0;

        ImageIcon photoIcon = new ImageIcon("image/logoCroixRouge.png");
        Image image1 = photoIcon.getImage(); // transform it
        Image newimg = image1.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        BFermerInfo = new JButton (new ImageIcon(newimg));
        BFermerInfo.setPreferredSize(new Dimension(30,30));

        panelInfoSeries.add(BFermerInfo,constraints);
        JPanel lab = new JPanel();
        lab.setPreferredSize(new Dimension(1440,20));
        lab.setBackground(Color.DARK_GRAY);
        panelInfoSeries.add(lab,constraints);

        constraints.gridy = 1;


        ImageIcon photoIcon1 = new ImageIcon("image/DescriptionSerie/"+ serie.getNomOeuvre() +"1.png");
        Image image2 = photoIcon1.getImage(); // transform it
        Image newimg1 = image2.getScaledInstance(900, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        JLabel temp = new JLabel(new ImageIcon(newimg1));
        temp.setPreferredSize(new Dimension(900,300));

        image.add(temp,constraints);

        image.setPreferredSize(new Dimension(900,300));

        panelInfoSeries.add(image, constraints);

        description.setBackground(Color.DARK_GRAY);
        description.setLayout(new BoxLayout(description, BoxLayout.Y_AXIS));

        constraints.gridy = 2;
        description.setPreferredSize(new Dimension(1300,175));

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridy = 0;
        constraints.gridx = 0;

        descriptionFilm.setText(this.serie.getSynopsisOeuvre());
        acteurs.setText("Acteurs : " + this.serie.getDistributionOeuvre());
        real.setText("Réalisateur : " + this.serie.getRealisateurOeuvre());
        titre.setText(this.serie.getNomOeuvre());

        descriptionFilm.setFont(new Font("Arial", Font.BOLD, 15));
        descriptionFilm.setForeground(Color.WHITE);
        duree.setFont(new Font("Arial", Font.ITALIC, 15));
        duree.setForeground(Color.WHITE);
        acteurs.setFont(new Font("Arial", Font.ITALIC, 15));
        acteurs.setForeground(Color.WHITE);
        real.setFont(new Font("Arial", Font.ITALIC, 15));
        real.setForeground(Color.WHITE);
        titre.setFont(new Font("Arial", Font.BOLD, 30));
        titre.setForeground(Color.WHITE);

        espace.setFont(new Font("Arial", Font.BOLD, 30));
        espace1.setFont(new Font("Arial", Font.BOLD, 5));
        espace2.setFont(new Font("Arial", Font.BOLD, 10));
        espace3.setFont(new Font("Arial", Font.BOLD, 10));
        espace.setText(" ");
        espace1.setText(" ");
        espace2.setText(" ");
        espace3.setText(" ");

        JPanel lab1 = new JPanel();
        lab1.setPreferredSize(new Dimension(1440,20));
        lab1.setBackground(Color.DARK_GRAY);
        panelInfoSeries.add(lab1,constraints);

        description.add(titre,constraints);
        constraints.gridy = 1;
        description.add(espace,constraints);
        constraints.gridx = 20;
        constraints.gridy = 2;
        description.add(descriptionFilm,constraints);
        constraints.gridy = 3;
        description.add(espace1,constraints);
        constraints.gridx = 20;
        constraints.gridy = 4;
        description.add(duree,constraints);
        constraints.gridy = 5;
        description.add(espace2,constraints);
        constraints.gridx = 20;
        constraints.gridy = 6;
        description.add(real,constraints);
        constraints.gridy = 7;
        description.add(espace3,constraints);
        constraints.gridx = 20;
        constraints.gridy = 8;
        description.add(acteurs,constraints);

        panelInfoSeries.add(description, constraints);

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);

        System.out.println("Nb Saison : " + serie.getNbSaisons());
        System.out.println("Nb Episodes : " + serie.getListeEpisodes().isEmpty());

        for(int i=0;i<serie.getNbSaisons();i++) {
            JPanel espace2 = new JPanel();
            espace2.setPreferredSize(new Dimension(1440,25));
            espace2.setBackground(Color.DARK_GRAY);
            JPanel espace = new JPanel();
            espace.setPreferredSize(new Dimension(1440,25));
            espace.setBackground(Color.DARK_GRAY);
            Saison[i] = new JLabel("                            "+ "Saison " + (i+1) +"                            ");
            Saison[i].setFont(new Font("Arial", Font.BOLD, 25));
            Saison[i].setForeground(Color.WHITE);
            panelInfoSeries.add(espace2);
            panelInfoSeries.add(Saison[i]);
            panelInfoSeries.add(espace);
            for(int j=0;j<serie.getListeEpisodes().get(i).size();j++)
                {
                BRegarder[i][j] = new JButton("Episode " + (j+1) + ": " + serie.getListeEpisodes().get(i).get(j).getTitreEpisode());
                BRegarder[i][j].setBackground(Color.DARK_GRAY);
                BRegarder[i][j].setFont(new Font("Arial", Font.BOLD, 15));
                BRegarder[i][j].setForeground(Color.white);
                BRegarder[i][j].setPreferredSize(new Dimension(1000, 50));
                panelInfoSeries.add(BRegarder[i][j]);
            }
        }
        JPanel espace1 = new JPanel();
        espace1.setPreferredSize(new Dimension(1440,25));
        espace1.setBackground(Color.DARK_GRAY);
        panelInfoSeries.add(espace1);
        scrollPage.setViewportView(panelInfoSeries);
        scrollPage.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public void Afficher() {
        setVisible(true);
        revalidate();
        repaint();
    }

    public JButton getBFermerInfo(){
        return BFermerInfo;
    }

    public JButton getBRegarder(int i, int j){return BRegarder[i][j];}
    public Serie getSeries(){return serie;}

}
