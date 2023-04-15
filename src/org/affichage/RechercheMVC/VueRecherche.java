package org.affichage.RechercheMVC;

import org.compte.Compte;

import javax.swing.*;
import java.awt.*;

public class VueRecherche extends JFrame {

    private JButton BFilm = new JButton("Films");
    private JButton BSerie = new JButton("Séries");
    private JButton BRecherche = new JButton("Recherche");
    private JButton BRetourConnexion = new JButton("DECONNEXION");

    private  JTextField recherche = new JTextField(15);

    private JPanel panel = new JPanel();
    private JPanel panelBandeau = new JPanel();

    private JScrollPane scrollPage = new JScrollPane(panel);

    private Dimension dim = new Dimension(200, 50);


    public VueRecherche(Compte compte, int profil) {
        setSize(1440, 720);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        InitInterface();
    }

    public void InitInterface(){

        panel.setBackground(Color.DARK_GRAY);
        panelBandeau.setBackground(Color.DARK_GRAY);

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
        BFilm.setBackground(Color.DARK_GRAY);
        BFilm.setBorderPainted(false);
        BFilm.setFont(new Font("Arial", Font.BOLD, 15));
        BFilm.setForeground(Color.WHITE);
        panelBandeau.add(BFilm, constraints);

        constraints.gridx = 1;
        BSerie.setBackground(Color.DARK_GRAY);
        BSerie.setBorderPainted(false);
        BSerie.setFont(new Font("Arial", Font.BOLD, 15));
        BSerie.setForeground(Color.WHITE);
        panelBandeau.add(BSerie, constraints);

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

    }

    public void Afficher(){
        setContentPane(scrollPage);
        setLocationRelativeTo(null);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
