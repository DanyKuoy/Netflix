package org.affichage.MenuStaffMVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VueStaff extends JFrame {



    private JButton BStaff = new JButton("Staff");
    private JButton BClient = new JButton("Client");
    private JButton BModifierCompte = new JButton("Modifier compte");
    private JButton BSupprimerCompte = new JButton("Supprimer compte");
    private JButton BAjouterFilm = new JButton("Ajouter film");
    private JButton BSupprimerFilm = new JButton("Supprimer film");
    private JButton BAjouterSerie = new JButton("Ajouter série");
    private JButton BSupprimerSerie = new JButton("Supprimer série");
    private JButton BValiderAjoutCompte = new JButton("Valider");
    private JButton BValiderSupprimeCompte = new JButton("Valider");
    private JButton BValiderAjoutFilm = new JButton("Valider");
    private JButton BValiderSupprimeFilm = new JButton("Valider");
    private JButton BValiderAjoutSerie = new JButton("Valider");
    private JButton BValiderSupprimeSerie = new JButton("Valider");
    private JButton BRetour = new JButton("Retour");
    private JButton BRetour1 = new JButton("Retour");
    private JButton BRetour2 = new JButton("Retour");
    private JButton BRetour3 = new JButton("Retour");
    private JButton BRetour4 = new JButton("Retour");
    private JButton BRetour5 = new JButton("Retour");





    private JPanel panelInitStaff = new JPanel(new GridBagLayout());
    private JPanel panelMenuStaff = new JPanel(new GridBagLayout());
    private JPanel panelModifierCompte = new JPanel(new GridBagLayout());
    private JPanel panelSupprimerCompte = new JPanel(new GridBagLayout());
    private JPanel panelAjouterFilm = new JPanel(new GridBagLayout());
    private JPanel panelSupprimerFilm = new JPanel(new GridBagLayout());
    private JPanel panelAjouterSerie = new JPanel(new GridBagLayout());
    private JPanel panelSupprimerSerie = new JPanel(new GridBagLayout());

    private JLabel labelPrenom = new JLabel("Prénom : ");
    private JLabel labelNom = new JLabel("Nom : ");
    private JLabel labelMDP2 = new JLabel("MDP : ");
    private JLabel labelID2 = new JLabel("ID : ");

    private JTextField ID2 = new JTextField(15);
    private JPasswordField MDP2 = new JPasswordField(15);
    private JTextField Prenom = new JTextField(15);
    private JTextField Nom = new JTextField(15);

    private JComboBox<String> comboBox;
    private JComboBox<String> comboBoxSousTitres;

    private JCheckBox Staff = new JCheckBox("Cocher si membre du staff");
    private JCheckBox ResAge = new JCheckBox("Cocher si le compte est soumis à une restriction d'âge");
    private JCheckBox RepriseVideo = new JCheckBox("Cocher si vous voulez activer la reprise automatique des vidéos");

    private JButton quitter = new JButton("Quitter");

    public VueStaff() {
        super();
        build();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        InitStaff();
        MenuStaff();
        ModifierCompte();
        SupprimerCompte();
        AjouterFilm();
        SupprimerFilm();
        AjouterSerie();
        SupprimerSerie();
    }

    public void afficher(){
        setLocationRelativeTo(null);
        getContentPane().add(panelInitStaff, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void InitStaff() {
        panelInitStaff.setBackground(Color.DARK_GRAY);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridy = 0;
        constraints.gridx = 0;


        BStaff.setPreferredSize(new Dimension(100, 25));
        panelInitStaff.add(BStaff, constraints);

        BClient.setPreferredSize(new Dimension(100, 25));
        constraints.gridx = 1;
        panelInitStaff.add(BClient, constraints);
    }

    public void build(){
        /// Création de la fenetre
        setTitle("Fenêtre");
        setSize(1440, 720);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void AffichageMenuStaff() {
        panelInitStaff.setVisible(false);
        panelMenuStaff.setVisible(true);
        panelModifierCompte.setVisible(false);
        panelSupprimerCompte.setVisible(false);
        panelAjouterFilm.setVisible(false);
        panelSupprimerFilm.setVisible(false);
        panelAjouterSerie.setVisible(false);
        panelSupprimerSerie.setVisible(false);

        //panelCreation.setVisible(false);
        //panelProfil.setVisible(false);
        //panelCreationProfil.setVisible(false);

        getContentPane().add(panelMenuStaff, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void AffichageModifierCompte() {
        panelInitStaff.setVisible(false);
        panelMenuStaff.setVisible(false);
        panelModifierCompte.setVisible(true);
        panelSupprimerCompte.setVisible(false);
        panelAjouterFilm.setVisible(false);
        panelSupprimerFilm.setVisible(false);
        panelAjouterSerie.setVisible(false);
        panelSupprimerSerie.setVisible(false);

        //panelCreation.setVisible(false);
        //panelProfil.setVisible(false);
        //panelCreationProfil.setVisible(false);

        getContentPane().add(panelModifierCompte, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void AffichageMenu() {
        panelInitStaff.setVisible(true);
        panelMenuStaff.setVisible(false);
        panelModifierCompte.setVisible(false);
        panelSupprimerCompte.setVisible(false);
        panelAjouterFilm.setVisible(false);
        panelSupprimerFilm.setVisible(false);
        panelAjouterSerie.setVisible(false);
        panelSupprimerSerie.setVisible(false);

        //panelCreation.setVisible(false);
        //panelProfil.setVisible(false);
        //panelCreationProfil.setVisible(false);

        getContentPane().add(panelModifierCompte, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void AffichageSupprimerCompte() {
        panelInitStaff.setVisible(false);
        panelMenuStaff.setVisible(false);
        panelModifierCompte.setVisible(false);
        panelSupprimerCompte.setVisible(true);
        panelAjouterFilm.setVisible(false);
        panelSupprimerFilm.setVisible(false);
        panelAjouterSerie.setVisible(false);
        panelSupprimerSerie.setVisible(false);

        //panelCreation.setVisible(false);
        //panelProfil.setVisible(false);
        //panelCreationProfil.setVisible(false);

        getContentPane().add(panelSupprimerCompte, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void AffichageAjouterFilm() {
        panelInitStaff.setVisible(false);
        panelMenuStaff.setVisible(false);
        panelModifierCompte.setVisible(false);
        panelSupprimerCompte.setVisible(false);
        panelAjouterFilm.setVisible(true);
        panelSupprimerFilm.setVisible(false);
        panelAjouterSerie.setVisible(false);
        panelSupprimerSerie.setVisible(false);

        //panelCreation.setVisible(false);
        //panelProfil.setVisible(false);
        //panelCreationProfil.setVisible(false);

        getContentPane().add(panelAjouterFilm, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void AffichageSupprimerFilm() {
        panelInitStaff.setVisible(false);
        panelMenuStaff.setVisible(false);
        panelModifierCompte.setVisible(false);
        panelSupprimerCompte.setVisible(false);
        panelAjouterFilm.setVisible(false);
        panelSupprimerFilm.setVisible(true);
        panelAjouterSerie.setVisible(false);
        panelSupprimerSerie.setVisible(false);

        //panelCreation.setVisible(false);
        //panelProfil.setVisible(false);
        //panelCreationProfil.setVisible(false);

        getContentPane().add(panelSupprimerFilm, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void AffichageAjouterSerie() {
        panelInitStaff.setVisible(false);
        panelMenuStaff.setVisible(false);
        panelModifierCompte.setVisible(false);
        panelSupprimerCompte.setVisible(false);
        panelAjouterFilm.setVisible(false);
        panelSupprimerFilm.setVisible(false);
        panelAjouterSerie.setVisible(true);
        panelSupprimerSerie.setVisible(false);

        //panelCreation.setVisible(false);
        //panelProfil.setVisible(false);
        //panelCreationProfil.setVisible(false);

        getContentPane().add(panelAjouterSerie, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void AffichageSupprimerSerie() {
        panelInitStaff.setVisible(false);
        panelMenuStaff.setVisible(false);
        panelModifierCompte.setVisible(false);
        panelSupprimerCompte.setVisible(false);
        panelAjouterFilm.setVisible(false);
        panelSupprimerFilm.setVisible(false);
        panelAjouterSerie.setVisible(false);
        panelSupprimerSerie.setVisible(true);

        //panelCreation.setVisible(false);
        //panelProfil.setVisible(false);
        //panelCreationProfil.setVisible(false);

        getContentPane().add(panelSupprimerSerie, BorderLayout.CENTER);
        revalidate();
        repaint();
    }



    public void MenuStaff() {
        panelMenuStaff.setBackground(Color.DARK_GRAY);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        /// Menu avec les boutons

        constraints.gridy = 0;
        BModifierCompte.setPreferredSize(new Dimension(200, 45));
        panelMenuStaff.add(BModifierCompte, constraints);

        BSupprimerCompte.setPreferredSize(new Dimension(200, 45));
        constraints.gridy = 1;
        panelMenuStaff.add(BSupprimerCompte, constraints);

        BAjouterFilm.setPreferredSize(new Dimension(200, 45));
        constraints.gridy = 2;
        panelMenuStaff.add(BAjouterFilm, constraints);

        BSupprimerFilm.setPreferredSize(new Dimension(200, 45));
        constraints.gridy = 3;
        panelMenuStaff.add(BSupprimerFilm, constraints);

        BAjouterSerie.setPreferredSize(new Dimension(200, 45));
        constraints.gridy = 4;
        panelMenuStaff.add(BAjouterSerie, constraints);

        BSupprimerSerie.setPreferredSize(new Dimension(200, 45));
        constraints.gridy = 5;
        panelMenuStaff.add(BSupprimerSerie, constraints);

        quitter.setPreferredSize(new Dimension(200, 45));
        constraints.gridy = 6;
        panelMenuStaff.add(quitter, constraints);
    }

    public JButton getQuitter(){return quitter;}

    private JLabel labelemail = new JLabel("Email");
    private JTextField email = new JTextField(15);

    private JTextField Erreur = new JTextField(15);

    public void InitErrorModifCompte(){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 100;
        constraints.gridx = 1;
        Erreur.setText("Le Compte n'existe pas");
        Erreur.setForeground(Color.red);
        panelModifierCompte.add(Erreur,constraints);
    }

    public void InitOUIModifCompte(){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 100;
        constraints.gridx = 1;
        Erreur.setText("Le compte a été supprimée");
        Erreur.setForeground(Color.GREEN);
        panelModifierCompte.add(Erreur,constraints);
    }


    public void ModifierCompte() {
        panelModifierCompte.setBackground(Color.DARK_GRAY);

        Staff.setBackground(Color.DARK_GRAY);

        labelemail.setFont(new Font("Arial", Font.BOLD, 15));

        labelemail.setForeground(Color.WHITE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        panelModifierCompte.add(labelemail, constraints);

        constraints.gridx = 1;
        panelModifierCompte.add(email, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;

        labelPrenom.setFont(new Font("Arial", Font.BOLD, 15));

        labelPrenom.setForeground(Color.WHITE);

        panelModifierCompte.add(labelPrenom, constraints);

        constraints.gridx = 1;
        panelModifierCompte.add(Prenom, constraints);

        labelNom.setFont(new Font("Arial", Font.BOLD, 15));

        labelNom.setForeground(Color.WHITE);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panelModifierCompte.add(labelNom, constraints);

        constraints.gridx = 1;
        panelModifierCompte.add(Nom, constraints);

        labelID2.setFont(new Font("Arial", Font.BOLD, 15));

        labelID2.setForeground(Color.WHITE);

        constraints.gridy = 3;
        constraints.gridx = 0;
        panelModifierCompte.add(labelID2, constraints);

        constraints.gridx = 1;
        panelModifierCompte.add(ID2, constraints);

        labelMDP2.setFont(new Font("Arial", Font.BOLD, 15));

        labelMDP2.setForeground(Color.WHITE);

        constraints.gridx = 0;
        constraints.gridy = 4;
        panelModifierCompte.add(labelMDP2, constraints);

        constraints.gridx = 1;
        panelModifierCompte.add(MDP2, constraints);

        constraints.gridy = 5;

        panelModifierCompte.add(Staff,constraints);

        constraints.gridy = 6;
        constraints.gridx = 1;

        panelModifierCompte.add(BValiderAjoutCompte, constraints);

        constraints.gridx = 2;

        panelModifierCompte.add(BRetour, constraints);


        //panelModifierCompte.add(BRetour2, constraints);
    }

    public void InitErrorSupCompte(){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 100;
        constraints.gridx = 1;
        Erreur.setText("Le Compte n'existe pas");
        Erreur.setForeground(Color.red);
        Erreur.setBackground(Color.DARK_GRAY);
        panelSupprimerCompte.add(Erreur,constraints);
    }

    public void InitOUISupCompte(){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 100;
        constraints.gridx = 1;
        Erreur.setText("Le compte a été supprimée");
        Erreur.setForeground(Color.GREEN);
        Erreur.setBackground(Color.DARK_GRAY);
        panelSupprimerCompte.add(Erreur,constraints);
    }

private JTextField Supprimer = new JTextField(15);
    private JLabel labelSupprimer = new JLabel("Saisir l'adresse mail du compte à supprimer");

    public void SupprimerCompte() {
        panelSupprimerCompte.setBackground(Color.DARK_GRAY);

        Staff.setBackground(Color.DARK_GRAY);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);


        labelSupprimer.setFont(new Font("Arial", Font.BOLD, 15));

        labelSupprimer.setForeground(Color.WHITE);
        panelSupprimerCompte.add(labelSupprimer, constraints);

        constraints.gridx = 1;
        panelSupprimerCompte.add(Supprimer, constraints);

        constraints.gridy = 1;
        panelSupprimerCompte.add(BValiderSupprimeCompte, constraints);

        constraints.gridx = 2;

        panelSupprimerCompte.add(BRetour1, constraints);

    }

    public void AjouterFilm() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        panelAjouterFilm.add(BRetour5, constraints);
    }

    public void InitErrorSupFilm(){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 100;
        constraints.gridx = 1;
        Erreur.setText("Le film n'est pas dans la base de données");
        Erreur.setForeground(Color.red);
        Erreur.setBackground(Color.DARK_GRAY);
        panelSupprimerFilm.add(Erreur,constraints);
    }

    public void InitOUISupFilm(){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 100;
        constraints.gridx = 1;
        Erreur.setText("Le film a été supprimée");
        Erreur.setForeground(Color.GREEN);
        Erreur.setBackground(Color.DARK_GRAY);
        panelSupprimerFilm.add(Erreur,constraints);
    }

    private JTextField SupprimerFilm = new JTextField(15);
    private JLabel labelSupprimerFilm = new JLabel("Saisir le nom du film à supprimer");

    public void SupprimerFilm() {
        panelSupprimerFilm.setBackground(Color.DARK_GRAY);

        Staff.setBackground(Color.DARK_GRAY);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        labelSupprimerFilm.setFont(new Font("Arial", Font.BOLD, 15));

        labelSupprimerFilm.setForeground(Color.WHITE);

        panelSupprimerFilm.add(labelSupprimerFilm, constraints);

        JTextField SupprimerFilm = new JTextField(15);

        constraints.gridx = 1;
        panelSupprimerFilm.add(SupprimerFilm, constraints);

        constraints.gridy = 1;
        panelSupprimerFilm.add(BValiderSupprimeFilm, constraints);

        constraints.gridx = 2;

        panelSupprimerFilm.add(BRetour2, constraints);
    }

    public void AjouterSerie() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        panelAjouterSerie.add(BRetour4, constraints);
    }

    public void InitErrorSupSerie(){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 100;
        constraints.gridx = 1;
        Erreur.setText("La série n'est pas dans la base de données");
        Erreur.setForeground(Color.red);
        Erreur.setBackground(Color.DARK_GRAY);
        panelSupprimerCompte.add(Erreur,constraints);
    }

    public void InitOUISupSerie(){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 100;
        constraints.gridx = 1;
        Erreur.setText("La série a été supprimée");
        Erreur.setForeground(Color.GREEN);
        Erreur.setBackground(Color.DARK_GRAY);
        panelSupprimerCompte.add(Erreur,constraints);
    }

    private JTextField SupprimerSerie = new JTextField(15);
    private JLabel labelSupprimerSerie = new JLabel("Saisir le nom de la série à supprimer");
    public void SupprimerSerie() {
        panelSupprimerSerie.setBackground(Color.DARK_GRAY);

        Staff.setBackground(Color.DARK_GRAY);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        labelSupprimerSerie.setFont(new Font("Arial", Font.BOLD, 15));

        labelSupprimerSerie.setForeground(Color.WHITE);

        panelSupprimerSerie.add(labelSupprimerSerie, constraints);

        constraints.gridx = 1;
        panelSupprimerSerie.add(SupprimerFilm, constraints);

        constraints.gridy = 1;
        panelSupprimerSerie.add(BValiderSupprimeSerie, constraints);

        constraints.gridx = 2;

        panelSupprimerSerie.add(BRetour3, constraints);
    }


    public JButton getBStaff() {
        return BStaff;
    }

    public JButton getBClient() {
        return BClient;
    }

    public JButton getBModifierCompte() {
        return BModifierCompte;
    }

    public JButton getBSupprimerCompte() {
        return BSupprimerCompte;
    }

    public JButton getBAjouterFilm() {
        return BAjouterFilm;
    }

    public JButton getBAjouterSerie() {
        return BAjouterSerie;
    }

    public JButton getBSupprimerFilm() {
        return BSupprimerFilm;
    }

    public JButton getBSupprimerSerie() {
        return BSupprimerSerie;
    }

    public JButton getBValiderAjoutCompte() {
        return BValiderAjoutCompte;
    }

    public JButton getBValiderSupprimeCompte() {
        return BValiderSupprimeCompte;
    }

    public JButton getBValiderAjoutFilm() {
        return BValiderAjoutFilm;
    }

    public JButton getBValiderSupprimeFilm() {
        return BValiderSupprimeFilm;
    }

    public JButton getBValiderAjoutSerie() {
        return BValiderAjoutSerie;
    }

    public JButton getBValiderSupprimeSerie() {
        return BValiderSupprimeSerie;
    }
    public String getID2() {
        return ID2.getText();
    }

    public String getMDP2() {
        return MDP2.getText();
    }

    public String getNom() {
        return Nom.getText();
    }

    public String getPrenom() {
        return Prenom.getText();
    }

    public JButton getBRetour() {
        return BRetour;
    }
    public JButton getBRetour1() {
        return BRetour1;
    }
    public JButton getBRetour2() {
        return BRetour2;
    }
    public JButton getBRetour3() {
        return BRetour3;
    }
    public JButton getBRetour4() {
        return BRetour4;
    }
    public JButton getBRetour5() {
        return BRetour5;
    }

    public boolean getStaff() {
        return Staff.isSelected();
    }

    public boolean getResAge() {
        return ResAge.isSelected();
    }

    public boolean getRepriseVideo() {
        return RepriseVideo.isSelected();
    }

    public String getSupprimer() {
        return Supprimer.getText();
    }
    public String getSupprimerFilm() {
        return SupprimerFilm.getText();
    }
    public String getSupprimerSerie() {
        return SupprimerSerie.getText();
    }
    public String getEmail() {
        return email.getText();
    }

}


