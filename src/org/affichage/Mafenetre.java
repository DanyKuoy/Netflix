package org.affichage;

import org.bdd.Connexion;
import org.compte.Compte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Mafenetre extends JFrame implements ActionListener{

    private JButton BConnexion = new JButton("Connexion");
    private JButton BConnecte = new JButton("Connexion");
    private JButton BCreation = new JButton("Création");
    private JButton BRetour = new JButton("Retour");
    private JButton BRetour2 = new JButton("Retour");
    private JButton BRetour3= new JButton("Retour");
    private JButton BCreer = new JButton("Connexion");
    private JButton BCreer2 = new JButton("Créer le compte");
    private JButton BProfil1 = new JButton("Profil 1");
    private JButton BProfil2 = new JButton("Profil 2");
    private JButton BProfil3 = new JButton("Profil 3");
    private JButton BProfil4 = new JButton("Profil 4");

    //private Image icon = new ImageIcon(getClass().getResource("/BackgroundNetflix.png")).getImage();

    private JButton BProfilCreer = new JButton("Créer le profil");
    private JButton BProfilValider = new JButton("Valider le profil");

    private JCheckBox Staff = new JCheckBox("Chocher si membre du staff");
    private JCheckBox ResAge = new JCheckBox("Chocher si le compte est soumis à une restriction d'âge");
    private JCheckBox RepriseVideo = new JCheckBox("Chocher si vous voulez activer la reprise automatique des vidéos");
    private JCheckBox QualiteVideoBasse = new JCheckBox("Basse qualitée");
    private JCheckBox QualiteVideoMoyenne = new JCheckBox("Moyenne qualité");
    private JCheckBox QualiteVideoHaute = new JCheckBox("Haute qualité");

    private JPanel panel = new JPanel(new GridBagLayout());
    private JPanel panelConnexion = new JPanel(new GridBagLayout());
    private JPanel panelCreation = new JPanel(new GridBagLayout());
    private JPanel panelProfil = new JPanel(new GridBagLayout());
    private JPanel panelCreationProfil = new JPanel(new GridBagLayout());

    private JLabel labelMDP = new JLabel("MDP : ");
    private JLabel labelID = new JLabel("ID : ");
    private JLabel labelMDP2 = new JLabel("MDP : ");
    private JLabel labelID2 = new JLabel("ID : ");
    private JLabel labelPrenom = new JLabel("Prénom : ");
    private JLabel labelPrenomProfil = new JLabel("Prénom : ");
    private JLabel labelNom = new JLabel("Nom : ");
    private JLabel labelQualite = new JLabel("Qualité : ");


    private String ID_Connexion;
    private String MDP_Connexion;
    private String ID_Creation;
    private String MDP_Creation;
    private String Prenom_Creation;
    private String Nom_Creation;
    private String Prenom_Profil;

    private JTextField ID =  new JTextField(15);
    private JTextField MDP = new JTextField(15);
    private JTextField ID2 = new JTextField(15);
    private JTextField MDP2 = new JTextField(15);
    private JTextField Prenom = new JTextField(15);
    private JTextField Nom = new JTextField(15);
    private JTextField PrenomProfil = new JTextField(15);

    private int IsStaff;
    private int IsResAge;
    private int IsRepriseVideo;
    private int Quality;

    private Compte compte;


    public Mafenetre() {

        super();
        build();
        InitAccueil();
        InitConnexionCreation();
        InitProfilCreation();
        setLocationRelativeTo(null);
        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);

    }

    private void build(){
//*création de la fenètre*/

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


    private void InitProfilCreation(){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        panelCreationProfil.add(labelPrenomProfil, constraints);

        constraints.gridx = 1;
        panelCreationProfil.add(PrenomProfil, constraints);

        constraints.gridx = 1;
        constraints.gridy = 10;
        panelCreationProfil.add(ResAge, constraints);

        constraints.gridx = 1;
        constraints.gridy = 20;
        panelCreationProfil.add(RepriseVideo, constraints);

        constraints.gridx = 1;
        constraints.gridy = 30;
        panelCreationProfil.add(QualiteVideoBasse, constraints);

        constraints.gridx = 1;
        constraints.gridy = 40;

        panelCreationProfil.add(QualiteVideoMoyenne,constraints);

        constraints.gridx = 1;
        constraints.gridy = 50;

        panelCreationProfil.add(QualiteVideoHaute,constraints);

        BProfilValider.addActionListener(this);

        constraints.gridx = 1;
        constraints.gridy = 60;

        panelCreationProfil.add(BProfilValider, constraints);

        BRetour3.addActionListener(this);

        constraints.gridx = 2;

        panelCreationProfil.add(BRetour3, constraints);
    }

    private void AffichageConnexion(){

        panel.setVisible(false);
        panelCreation.setVisible(false);
        panelConnexion.setVisible(true);
        panelProfil.setVisible(false);
        panelCreationProfil.setVisible(false);

        getContentPane().add(panelConnexion, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void AffichageCreation(){

        panel.setVisible(false);
        panelCreation.setVisible(true);
        panelConnexion.setVisible(false);
        panelProfil.setVisible(false);
        panelCreationProfil.setVisible(false);

        getContentPane().add(panelCreation, BorderLayout.CENTER);
        revalidate();
        repaint();
    }


    private void InitProfil(Compte compte){

        System.out.println(compte.getNbProfil());

        panelProfil.setBackground(Color.WHITE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 0;
        constraints.gridx = 0;

        System.out.println(compte.getNbProfil());

        if(compte.getNbProfil()==0){
            BProfilCreer.addActionListener(this);
            BProfilCreer.setPreferredSize(new Dimension(100, 100));
            panelProfil.add(BProfilCreer, constraints);
        }

        if(compte.getNbProfil()>0){
            BProfil1.addActionListener(this);
            BProfil1.setPreferredSize(new Dimension(100, 100));
            panelProfil.add(BProfil1, constraints);
        }

        if(compte.getNbProfil()>1){
            constraints.gridx = 1;
            BProfil2.addActionListener(this);
            BProfil2.setPreferredSize(new Dimension(100, 100));
            panelProfil.add(BProfil2, constraints);
        }

        if(compte.getNbProfil()>2){
            constraints.gridx = 2;
            BProfil3.addActionListener(this);
            BProfil3.setPreferredSize(new Dimension(100, 100));
            panelProfil.add(BProfil3, constraints);
        }

        if(compte.getNbProfil()>3){
            constraints.gridx = 3;
            BProfil4.addActionListener(this);
            BProfil4.setPreferredSize(new Dimension(100, 100));
            panelProfil.add(BProfil4, constraints);
        }

        if(compte.getNbProfil()==1){
            constraints.gridx = 1;
            BProfilCreer.addActionListener(this);
            BProfilCreer.setPreferredSize(new Dimension(100, 100));
            panelProfil.add(BProfilCreer, constraints);
        }

        if(compte.getNbProfil()==2){
            constraints.gridx = 2;
            BProfilCreer.addActionListener(this);
            BProfilCreer.setPreferredSize(new Dimension(100, 100));
            panelProfil.add(BProfilCreer, constraints);
        }

        if(compte.getNbProfil()==0){
            constraints.gridx = 3;
            BProfilCreer.addActionListener(this);
            BProfilCreer.setPreferredSize(new Dimension(100, 100));
            panelProfil.add(BProfilCreer, constraints);
        }

        if(compte.getNbProfil()==4){
            constraints.gridx = 4;
            BProfilCreer.addActionListener(this);
            BProfilCreer.setPreferredSize(new Dimension(100, 100));
            panelProfil.add(BProfilCreer, constraints);
        }
    }

    public void AffichageProfil(){
        panel.setVisible(false);
        panelCreation.setVisible(false);
        panelConnexion.setVisible(false);
        panelProfil.setVisible(true);
        panelCreationProfil.setVisible(false);

        getContentPane().add(panelProfil, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void AffichageNouveauProfil(){
        panelCreation.setVisible(false);
        panelConnexion.setVisible(false);
        panelProfil.setVisible(false);
        panel.setVisible(false);
        panelCreationProfil.setVisible(true);

        getContentPane().add(panelCreationProfil, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        // code à exécuter lorsqu'un événement est déclenché

        if(e.getSource() == BConnecte){

            AffichageConnexion();

        }

        else if(e.getSource() == BCreation){

            AffichageCreation();

        }

        else if(e.getSource() == BRetour || e.getSource() == BRetour2){

            panelCreation.setVisible(false);
            panelConnexion.setVisible(false);
            panelProfil.setVisible(false);
            panelCreationProfil.setVisible(false);

            getContentPane().add(panel, BorderLayout.CENTER);
            revalidate();
            repaint();

            panel.setVisible(true);

        }

        //*Vérification de si l'utilisateur est dans la base de données*/
        //*Accès aux différents profils*/
        //*Accès à l'interface utilisateur de l'application*/

        else if(e.getSource() == BCreer){
            //*Récupération de la saisie clavier*/
            ID_Connexion = ID.getText();
            MDP_Connexion = MDP.getText();

            Connexion connexion = new Connexion();
            compte = connexion.seConnecter(ID_Connexion, MDP_Connexion);
            connexion.setMonCompte(compte);

            ID_Connexion = "";
            MDP_Connexion = "";

            InitProfil(compte);
            AffichageProfil();
        }

        //*Ajout de l'utilisateur dans la base de données si il n'existe pas déjà*/
        else if(e.getSource() == BCreer2){
            //*Récupération de la saisie clavier*/
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

            ID_Creation = "";
            MDP_Creation = "";
            Nom_Creation = "";
            Prenom_Creation = "";

            BRetour.doClick();

        }

        else if(e.getSource() == BProfilCreer) {


            AffichageNouveauProfil();

        }

        else if(e.getSource() == BProfilValider){

            Prenom_Profil = PrenomProfil.getText();

            if(ResAge.isSelected()== true) {
                IsResAge = 1;
            }
            else{
                IsResAge = 0;
            }

            if(RepriseVideo.isSelected()== true) {
                IsRepriseVideo = 1;
            }
            else{
                IsRepriseVideo = 0;
            }

            if(QualiteVideoBasse.isSelected()== true) {
                Quality = 0;
            }
            else if(QualiteVideoMoyenne.isSelected()== true){
                Quality = 1;
            }
            else if(QualiteVideoHaute.isSelected()== true){
                Quality = 2;
            }

            compte.ajouterProfil(Prenom_Profil, compte.getEmailCompte(), IsResAge, IsRepriseVideo, Quality, "");

            InitProfil(compte);

            panelCreation.setVisible(false);
            panelConnexion.setVisible(false);
            panelProfil.setVisible(true);
            panel.setVisible(false);
            panelCreationProfil.setVisible(false);
        }

        else if(e.getSource() == QualiteVideoBasse){
            QualiteVideoMoyenne.setSelected(false);
            QualiteVideoHaute.setSelected(false);
        }
        else if(e.getSource() == QualiteVideoMoyenne){
            QualiteVideoBasse.setSelected(false);
            QualiteVideoHaute.setSelected(false);
        }
        else if(e.getSource() == QualiteVideoHaute){
            QualiteVideoBasse.setSelected(false);
            QualiteVideoMoyenne.setSelected(false);
        }
    }
}

