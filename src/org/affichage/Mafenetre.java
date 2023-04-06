package org.affichage;

import org.bdd.*;
import org.compte.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Mafenetre extends JFrame implements ActionListener{
    /** Attributs **/
    private JButton BConnexion = new JButton("Connexion");
    private JButton BConnecte = new JButton("Connexion");
    private JButton BCreation = new JButton("Création");
    private JButton BRetour = new JButton("Retour");
    private JButton BCreer = new JButton("Connexion");
    private JButton BRetour2 = new JButton("Retour");
    private JButton BCreer2 = new JButton("Créer le compte");
    private JCheckBox Staff = new JCheckBox("Cocher si membre du staff");
    private JPanel panel = new JPanel(new GridBagLayout());
    private JPanel panelConnexion = new JPanel(new GridBagLayout());
    private JPanel panelCreation = new JPanel(new GridBagLayout());
    private JLabel labelMDP = new JLabel("MDP : ");
    private JLabel labelID = new JLabel("E-mail : ");
    private JLabel labelMDP2 = new JLabel("MDP : ");
    private JLabel labelID2 = new JLabel("E-mail : ");
    private JLabel labelPrenom = new JLabel("Prénom : ");
    private JLabel labelNom = new JLabel("Nom : ");
    private String ID_Connexion;
    private String MDP_Connexion;
    private String ID_Creation;
    private String MDP_Creation;
    private String Prenom_Creation;
    private String Nom_Creation;
    private JTextField ID =  new JTextField(15);
    private JTextField MDP = new JTextField(15);
    private JTextField ID2 = new JTextField(15);
    private JTextField MDP2 = new JTextField(15);
    private JTextField Prenom = new JTextField(15);
    private JTextField Nom = new JTextField(15);
    private int IsStaff;

    /** Constructeur **/
    public Mafenetre() {
        super();
        build();
        InitAccueil();
        InitConnexionCreation();
        setLocationRelativeTo(null);
        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);

    }

    /** Méthodes **/
    private void build(){
        /// Création de la fenètre*/
        setTitle("Fenêtre");
        setSize(1440, 720);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void InitAccueil(){

        panel.setBackground(Color.WHITE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridy = 0;
        constraints.gridx = 0;

        BConnecte.addActionListener(this);
        BConnecte.setPreferredSize(new Dimension(100, 25));
        panel.add(BConnecte, constraints);
        BCreation.addActionListener(this);
        BCreation.setPreferredSize(new Dimension(100, 25));
        constraints.gridx = 1;
        panel.add(BCreation, constraints);
    }

    private void InitConnexionCreation(){

        panelConnexion.setBackground(Color.WHITE);
        panelCreation.setBackground(Color.WHITE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        panelConnexion.add(labelID, constraints);
        panelCreation.add(labelPrenom, constraints);

        constraints.gridx = 1;
        panelConnexion.add(ID, constraints);
        panelCreation.add(Prenom, constraints);

        constraints.gridx = 0;
        constraints.gridy = 10;
        panelConnexion.add(labelMDP, constraints);
        panelCreation.add(labelNom, constraints);

        constraints.gridx = 1;
        panelConnexion.add(MDP, constraints);
        panelCreation.add(Nom, constraints);

        constraints.gridy = 20;
        constraints.gridx = 0;
        panelCreation.add(labelID2, constraints);

        constraints.gridx = 1;
        panelCreation.add(ID2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 30;
        panelCreation.add(labelMDP2, constraints);

        constraints.gridx = 1;
        panelCreation.add(MDP2, constraints);

        constraints.gridx = 1;
        constraints.gridy = 40;

        panelCreation.add(Staff,constraints);

        BCreer.addActionListener(this);
        BCreer2.addActionListener(this);

        constraints.gridx = 1;
        constraints.gridy = 45;

        panelConnexion.add(BCreer, constraints);
        panelCreation.add(BCreer2, constraints);

        BRetour.addActionListener(this);
        BRetour2.addActionListener(this);

        constraints.gridx = 2;

        panelConnexion.add(BRetour, constraints);
        panelCreation.add(BRetour2, constraints);
    }

    private void AffichageConnexion(){

        panel.setVisible(false);
        panelCreation.setVisible(false);
        panelConnexion.setVisible(true);

        getContentPane().add(panelConnexion, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void AffichageCreation(){

        panel.setVisible(false);
        panelCreation.setVisible(true);
        panelConnexion.setVisible(false);

        getContentPane().add(panelCreation, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        /// Code à exécuter lorsqu'un événement est déclenché

        if(e.getSource() == BConnecte){
            AffichageConnexion();
        }
        else if(e.getSource() == BCreation){
            AffichageCreation();
        }
        else if(e.getSource() == BRetour || e.getSource() == BRetour2){
            panelCreation.setVisible(false);
            panelConnexion.setVisible(false);
            getContentPane().add(panel, BorderLayout.CENTER);
            revalidate();
            repaint();
            panel.setVisible(true);
        }

        /// Vérification de si l'utilisateur est dans la base de données
        else if(e.getSource() == BCreer){
            /// Récupération de la saisie clavier
            ID_Connexion = ID.getText();
            MDP_Connexion = MDP.getText();
            System.out.println("ID_Connexion: " + ID_Connexion);
            System.out.println("MDP_Connexion: " + MDP_Connexion);

            Connexion connexion = new Connexion();
            Compte compte = connexion.seConnecter(ID_Connexion, MDP_Connexion);
            connexion.setMonCompte(compte);

        }

        /// Ajout de l'utilisateur dans la base de données si il n'existe pas déjà
        else if(e.getSource() == BCreer2){
            /// Récupération de la saisie clavier
            ID_Creation = ID2.getText();
            MDP_Creation = MDP2.getText();
            Nom_Creation = Nom.getText();
            Prenom_Creation = Prenom.getText();

            if(Staff.isSelected()==true){
                IsStaff = 1;
            }
            else {
                IsStaff = 0;
            }

            Connexion connexion = new Connexion();
            connexion.creerCompte(Prenom_Creation, Nom_Creation, ID_Creation, MDP_Creation, IsStaff);

        }
    }
}

