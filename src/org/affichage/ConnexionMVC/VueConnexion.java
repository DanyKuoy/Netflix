package org.affichage.ConnexionMVC;

import org.compte.Compte;
import org.compte.Profil;
import org.dao.CompteDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VueConnexion extends JFrame {

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

    private JCheckBox Staff = new JCheckBox("Cocher si membre du staff");
    private JCheckBox ResAge = new JCheckBox("Cocher si le compte est soumis à une restriction d'âge");
    private JCheckBox RepriseVideo = new JCheckBox("Cocher si vous voulez activer la reprise automatique des vidéos");

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
    private JLabel Profil1 = new JLabel("                  Profil 1");
    private JLabel Profil2 = new JLabel("                  Profil 2");
    private JLabel Profil3 = new JLabel("                  Profil 3");
    private JLabel Profil4 = new JLabel("                  Profil 4");
    private JLabel Erreur = new JLabel("");
    private JLabel labelSousTitres = new JLabel("Sous Titre");

    private JTextField ID =  new JTextField(15);
    private JPasswordField MDP = new JPasswordField(15);
    private JTextField ID2 = new JTextField(15);
    private JPasswordField MDP2 = new JPasswordField(15);
    private JTextField Prenom = new JTextField(15);
    private JTextField Nom = new JTextField(15);
    private JTextField PrenomProfil = new JTextField(15);

    private JComboBox<String> comboBox;
    private JComboBox<String> comboBoxSousTitres;

    public VueConnexion() {

        super();
        build();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        InitAccueil();
        InitConnexionCreation();
        InitProfilCreation();

    }

    public void Afficher(){
        setLocationRelativeTo(null);
        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void build(){
//*création de la fenètre*/

        setTitle("Fenêtre");
        setSize(1440, 720);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getBConnexion(){
        return BConnexion;
    }
    public JButton getBConnecte(){
        return BConnecte;
    }
    public JButton getBCreation(){
        return BCreation;
    }
    public JButton getBRetour(){
        return BRetour;
    }
    public JButton getBRetour2(){
        return BRetour2;
    }
    public JButton getBRetour3(){
        return BRetour3;
    }
    public JButton getBCreer(){
        return BCreer;
    }
    public JButton getBCreer2(){
        return BCreer2;
    }
    public JButton getBProfil1(){
        return BProfil1;
    }
    public JButton getBProfil2(){
        return BProfil2;
    }
    public JButton getBProfil3(){
        return BProfil3;
    }
    public JButton getBProfil4(){
        return BProfil4;
    }
    public JButton getBProfilCreer(){
        return BProfilCreer;
    }
    public JButton getBProfilValider(){
        return BProfilValider;
    }
    public JCheckBox getStaff(){
        return Staff;
    }
    public JCheckBox getResAge(){
        return ResAge;
    }
    public JCheckBox getRepriseVideo(){
        return RepriseVideo;
    }

    public JPanel getpanel(){
        return panel;
    }
    public JPanel getpanelConnexion(){
        return panelConnexion;
    }
    public JPanel getpanelCreation(){
        return panelCreation;
    }
    public JPanel getpanelProfil(){
        return panelProfil;
    }
    public JPanel getpanelCreationProfil(){
        return panelCreationProfil;
    }

    public String getComboBoxString(){
        return comboBox.getSelectedItem().toString();
    }
    public String getComboBoxSousTitreString(){
        return comboBoxSousTitres.getSelectedItem().toString();
    }
    public JComboBox<String> getComboBox(){
        return comboBox;
    }
    public JComboBox<String> getComboBoxSousTitres(){
        return comboBoxSousTitres;
    }

    public JTextField getID(){
        return ID;
    }
    public JPasswordField getMDP(){
        return MDP;
    }
    public JTextField getID2(){
        return ID2;
    }
    public JPasswordField getMDP2(){
        return MDP2;
    }
    public JTextField getPrenom(){
        return Prenom;
    }
    public JTextField getNom(){
        return Nom;
    }
    public JTextField getPrenomProfil(){
        return PrenomProfil;
    }
    public JLabel getProfil1(){
        return Profil1;
    }
    public JLabel getProfil2(){
        return Profil2;
    }
    public JLabel getProfil3(){
        return Profil3;
    }
    public JLabel getProfil4(){
        return Profil4;
    }

    public void setMDP(String a){
        MDP.setText(a);
    }
    public void setID(String a){
        ID.setText(a);
    }
    public void setMDP2(String a){
        MDP2.setText(a);
    }
    public void setID2(String a){
        ID2.setText(a);
    }
    public void setNom(String a){
        Nom.setText(a);
    }
    public void setPrenom(String a){
        Prenom.setText(a);
    }




    public void InitAccueil(){

        panel.setBackground(Color.DARK_GRAY);

        labelID.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrenom.setFont(new Font("Arial", Font.BOLD, 15));
        labelMDP.setFont(new Font("Arial", Font.BOLD, 15));
        labelID2.setFont(new Font("Arial", Font.BOLD, 15));
        labelMDP2.setFont(new Font("Arial", Font.BOLD, 15));
        labelNom.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrenomProfil.setFont(new Font("Arial", Font.BOLD, 15));
        labelSousTitres.setFont(new Font("Arial", Font.BOLD, 15));
        Profil1.setFont(new Font("Arial", Font.BOLD, 15));
        Profil2.setFont(new Font("Arial", Font.BOLD, 15));
        Profil3.setFont(new Font("Arial", Font.BOLD, 15));
        Profil4.setFont(new Font("Arial", Font.BOLD, 15));

        labelID.setForeground(Color.WHITE);
        labelPrenom.setForeground(Color.WHITE);
        labelMDP.setForeground(Color.WHITE);
        labelID2.setForeground(Color.WHITE);
        labelMDP2.setForeground(Color.WHITE);
        labelNom.setForeground(Color.WHITE);
        labelPrenomProfil.setForeground(Color.WHITE);
        labelSousTitres.setForeground(Color.WHITE);
        Profil1.setForeground(Color.WHITE);
        Profil2.setForeground(Color.WHITE);
        Profil3.setForeground(Color.WHITE);
        Profil4.setForeground(Color.WHITE);

        BConnexion.setFont(new Font("Arial", Font.BOLD, 15));
        BConnecte.setFont(new Font("Arial", Font.BOLD, 15));
        BCreation.setFont(new Font("Arial", Font.BOLD, 15));
        BRetour.setFont(new Font("Arial", Font.BOLD, 15));
        BRetour2.setFont(new Font("Arial", Font.BOLD, 15));
        BRetour3.setFont(new Font("Arial", Font.BOLD, 15));
        BCreer.setFont(new Font("Arial", Font.BOLD, 15));
        BCreer2.setFont(new Font("Arial", Font.BOLD, 15));
        BProfil1.setFont(new Font("Arial", Font.BOLD, 15));
        BProfil2.setFont(new Font("Arial", Font.BOLD, 15));
        BProfil3.setFont(new Font("Arial", Font.BOLD, 15));
        BProfil4.setFont(new Font("Arial", Font.BOLD, 15));
        BProfilCreer.setFont(new Font("Arial", Font.BOLD, 15));
        BProfilValider.setFont(new Font("Arial", Font.BOLD, 15));
        Staff.setFont(new Font("Arial", Font.BOLD, 15));
        ResAge.setFont(new Font("Arial", Font.BOLD, 15));
        RepriseVideo.setFont(new Font("Arial", Font.BOLD, 15));

        BConnexion.setForeground(Color.BLACK);
        BConnecte.setForeground(Color.BLACK);
        BCreation.setForeground(Color.BLACK);
        BRetour.setForeground(Color.BLACK);
        BRetour2.setForeground(Color.BLACK);
        BRetour3.setForeground(Color.BLACK);
        BCreer.setForeground(Color.BLACK);
        BCreer2.setForeground(Color.BLACK);
        BProfil1.setForeground(Color.BLACK);
        BProfil2.setForeground(Color.BLACK);
        BProfil3.setForeground(Color.BLACK);
        BProfil4.setForeground(Color.BLACK);
        BProfilCreer.setForeground(Color.BLACK);
        BProfilValider.setForeground(Color.BLACK);

        Staff.setForeground(Color.WHITE);
        ResAge.setForeground(Color.WHITE);
        RepriseVideo.setForeground(Color.WHITE);

        Staff.setBackground(Color.DARK_GRAY);
        ResAge.setBackground(Color.DARK_GRAY);
        RepriseVideo.setBackground(Color.DARK_GRAY);



        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridy = 0;
        constraints.gridx = 0;

        BConnecte.setPreferredSize(new Dimension(150, 50));
        panel.add(BConnecte, constraints);
        BCreation.setPreferredSize(new Dimension(150, 50));
        constraints.gridx = 1;
        panel.add(BCreation, constraints);
    }

    public void InitConnexionCreation(){

        panelConnexion.setBackground(Color.DARK_GRAY);
        panelCreation.setBackground(Color.DARK_GRAY);

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
        constraints.gridy = 1;
        panelConnexion.add(labelMDP, constraints);
        panelCreation.add(labelNom, constraints);

        constraints.gridx = 1;
        panelConnexion.add(MDP, constraints);
        panelCreation.add(Nom, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        panelCreation.add(labelID2, constraints);

        constraints.gridx = 1;
        panelCreation.add(ID2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panelCreation.add(labelMDP2, constraints);

        constraints.gridx = 1;
        panelCreation.add(MDP2, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;

        panelCreation.add(Staff,constraints);

        constraints.gridx = 1;
        constraints.gridy = 45;

        panelConnexion.add(BCreer, constraints);
        panelCreation.add(BCreer2, constraints);

        constraints.gridx = 2;

        panelConnexion.add(BRetour, constraints);
        panelCreation.add(BRetour2, constraints);

        Erreur.setText("");
        panelConnexion.add(Erreur,constraints);
    }


    public void InitProfilCreation(){

        panelCreationProfil.setBackground(Color.DARK_GRAY);

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

        String[] elements = {"Qualité Vidéo Basse", "Qualité Vidéo Moyenne", "Qualité Vidéo Haute"};

        // Créer un JComboBox
        comboBox = new JComboBox<>(elements);

        constraints.gridx = 1;
        constraints.gridy = 30;
        panelCreationProfil.add(comboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 40;
        panelCreationProfil.add(labelSousTitres, constraints);

        String[] elements1 = {"Aucun", "Français", "Anglais", "Espagnol", "Italien", "Allemand"};

        comboBoxSousTitres = new JComboBox<>(elements1);

        constraints.gridx = 1;
        constraints.gridy = 40;

        panelCreationProfil.add(comboBoxSousTitres,constraints);

        constraints.gridx = 1;
        constraints.gridy = 60;

        panelCreationProfil.add(BProfilValider, constraints);

        constraints.gridx = 2;

        panelCreationProfil.add(BRetour3, constraints);

    }

    public void AffichageConnexion(){

        panel.setVisible(false);
        panelCreation.setVisible(false);
        panelConnexion.setVisible(true);
        panelProfil.setVisible(false);
        panelCreationProfil.setVisible(false);

        getContentPane().add(panelConnexion, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void AffichageCreation(){

        panel.setVisible(false);
        panelCreation.setVisible(true);
        panelConnexion.setVisible(false);
        panelProfil.setVisible(false);
        panelCreationProfil.setVisible(false);

        getContentPane().add(panelCreation, BorderLayout.CENTER);
        revalidate();
        repaint();
    }


    public void InitProfil(Compte compte){

        panelProfil.setBackground(Color.DARK_GRAY);

        System.out.println(compte.getNbProfil());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 0;
        constraints.gridx = 0;

        System.out.println(compte.getNbProfil());

        if(compte.getNbProfil()==0){
            BProfilCreer.setPreferredSize(new Dimension(150, 150));
            panelProfil.add(BProfilCreer, constraints);
        }

        if(compte.getNbProfil()>0){
            BProfil1.setPreferredSize(new Dimension(150, 150));
            panelProfil.add(BProfil1, constraints);
            constraints.gridy = 1;
            panelProfil.add(Profil1, constraints);
        }

        if(compte.getNbProfil()>1){
            constraints.gridx = 1;
            constraints.gridy = 0;
            BProfil2.setPreferredSize(new Dimension(150, 150));
            panelProfil.add(BProfil2, constraints);
            constraints.gridy = 1;
            panelProfil.add(Profil2, constraints);
        }

        if(compte.getNbProfil()>2){
            constraints.gridx = 2;
            constraints.gridy = 0;
            BProfil3.setPreferredSize(new Dimension(150, 150));
            panelProfil.add(BProfil3, constraints);
            constraints.gridy = 1;
            panelProfil.add(Profil3, constraints);
        }

        if(compte.getNbProfil()>3){
            constraints.gridx = 3;
            constraints.gridy = 0;
            BProfil4.setPreferredSize(new Dimension(150, 150));
            panelProfil.add(BProfil4, constraints);
            constraints.gridy = 1;
            panelProfil.add(Profil4, constraints);
        }

        if(compte.getNbProfil()==1){
            constraints.gridx = 1;
            constraints.gridy = 0;
            BProfilCreer.setPreferredSize(new Dimension(150, 150));
            panelProfil.add(BProfilCreer, constraints);
        }

        else if(compte.getNbProfil()==2){
            constraints.gridx = 2;
            constraints.gridy = 0;
            BProfilCreer.setPreferredSize(new Dimension(150, 150));
            panelProfil.add(BProfilCreer, constraints);
        }

        else if(compte.getNbProfil()==3){
            constraints.gridx = 3;
            constraints.gridy = 0;
            BProfilCreer.setPreferredSize(new Dimension(150, 150));
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

    public void InitError(){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 100;
        constraints.gridx = 1;
        Erreur.setText("Mot de passe ou identifiant invalide");
        Erreur.setForeground(Color.red);
        panelConnexion.add(Erreur,constraints);
    }


}

