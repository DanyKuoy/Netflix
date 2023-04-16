package org.affichage.InformationFilmsMVC;

import org.oeuvre.Film;
import org.compte.*;

import javax.swing.*;
import java.awt.*;

public class VueInformationFilms extends JFrame{


    private JPanel panelInfoFilm = new JPanel();
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
    private Film film;
    private String descri;
    private String acteur;

    private JButton BFermerInfo = new JButton();
    private JButton BRegarder = new JButton("Regarder");

    public VueInformationFilms(Film film){

        this.film = film;

        setSize(720,1440);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        InitInfoFilm();
        setLocationRelativeTo(null);
        getContentPane().add(panelInfoFilm, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Fin classe");
    }

    private void InitInfoFilm(){

        panelInfoFilm.setPreferredSize(new Dimension(1440,720));
        panelInfoFilm.setBackground(Color.DARK_GRAY);

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

        panelInfoFilm.add(BFermerInfo,constraints);

        JPanel lab = new JPanel();
        lab.setPreferredSize(new Dimension(1440,20));
        lab.setBackground(Color.DARK_GRAY);
        panelInfoFilm.add(lab,constraints);



        constraints.gridy = 1;

        ImageIcon photoIcon1 = new ImageIcon("image/DescriptionFilm/"+ film.getNomOeuvre() +"1.png");
        Image image2 = photoIcon1.getImage(); // transform it
        Image newimg1 = image2.getScaledInstance(900, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        JLabel temp = new JLabel(new ImageIcon(newimg1));
        temp.setPreferredSize(new Dimension(900,300));

        image.add(temp,constraints);

        image.setPreferredSize(new Dimension(900,300));

        panelInfoFilm.add(image, constraints);

        description.setBackground(Color.DARK_GRAY);
        description.setLayout(new BoxLayout(description, BoxLayout.Y_AXIS));

        constraints.gridy = 2;
        description.setPreferredSize(new Dimension(1300,175));

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridy = 0;
        constraints.gridx = 0;

        descriptionFilm.setText(this.film.getSynopsisOeuvre());
        duree.setText("Durée : " + this.film.getDureeFilm() + " minutes            ");
        acteurs.setText("Acteurs : " + this.film.getDistributionOeuvre());
        real.setText("Réalisateur : " + this.film.getRealisateurOeuvre());
        titre.setText(this.film.getNomOeuvre());

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

        espace.setFont(new Font("Arial", Font.BOLD, 10));
        espace1.setFont(new Font("Arial", Font.BOLD, 10));
        espace2.setFont(new Font("Arial", Font.BOLD, 10));
        espace3.setFont(new Font("Arial", Font.BOLD, 10));
        espace.setText(" ");
        espace1.setText(" ");
        espace2.setText(" ");
        espace3.setText(" ");

        JPanel lab1 = new JPanel();
        lab1.setPreferredSize(new Dimension(1440,20));
        lab1.setBackground(Color.DARK_GRAY);
        panelInfoFilm.add(lab1,constraints);

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

        panelInfoFilm.add(description, constraints);

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);

        BRegarder.setBackground(Color.DARK_GRAY);
        BRegarder.setFont(new Font("Arial", Font.BOLD, 30));
        BRegarder.setForeground(Color.white);

        BRegarder.setPreferredSize(new Dimension(200,100));
        panelInfoFilm.add(BRegarder,constraints);
    }

    public void Afficher() {
        panelInfoFilm.setVisible(true);
        this.getContentPane().add(panelInfoFilm);
        revalidate();
        repaint();
    }

    public JButton getBFermerInfo(){
        return BFermerInfo;
    }

    public JButton getBRegarder(){return BRegarder;}
    public Film getFilm(){return film;}

}
