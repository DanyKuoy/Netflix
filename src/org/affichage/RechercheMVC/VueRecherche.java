package org.affichage.RechercheMVC;

import org.compte.Compte;
import org.affichage.RechercheMVC.ModelRecherche.*;
import org.oeuvre.Oeuvre;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VueRecherche extends JFrame {

    private JButton BFilm = new JButton("Films");
    private JButton BSerie = new JButton("Séries");
    private JButton BRecherche = new JButton("Recherche");
    private JButton BRetourConnexion = new JButton("DECONNEXION");
    private JButton[] BAffichage = new JButton[100];

    private  JTextField recherche = new JTextField(15);

    private JPanel panel = new JPanel();
    private JPanel Oeuvre = new JPanel();
    private JPanel panelBandeau = new JPanel();

    private JScrollPane scrollPage = new JScrollPane(panel);

    private Dimension dim = new Dimension(200, 50);

    private Compte compte;
    private int profil;
    private String Recherche;
    private ArrayList<org.oeuvre.Oeuvre> ListeOeuvre = new ArrayList<Oeuvre>();
    private boolean[] tab = new boolean[100];


    public VueRecherche(Compte compte, int profil, String Nom) {
        this.compte = compte;
        this.profil = profil;
        this.Recherche = Nom;

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

        Oeuvre.setLayout(new GridLayout(10, 9));
        Oeuvre.setPreferredSize(new Dimension(1300,3000));
        Oeuvre.setBackground(Color.DARK_GRAY);

        ModelRecherche modelRecherche = new ModelRecherche(compte, profil);
        boolean test = modelRecherche.getBiblio().rechercheOeuvre(Recherche,ListeOeuvre);

        if(test==true){
            for(int i=0;i<ListeOeuvre.size();i++){
                    ImageIcon photoIcon = new ImageIcon("image/Film/"+ListeOeuvre.get(i).getNomOeuvre()+".png");
                    Image image = photoIcon.getImage(); // transform it
                    Image newimg = image.getScaledInstance(110, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                    BAffichage[i] = new JButton (new ImageIcon(newimg));
                    BAffichage[i].setBackground(Color.DARK_GRAY);
                    BAffichage[i].setPreferredSize(new Dimension(110,160));
                    if (photoIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                        tab[i] = true;
                    }
                    else {
                        ImageIcon photoIcon1 = new ImageIcon("image/Serie/"+ListeOeuvre.get(i).getNomOeuvre()+".png");
                        Image image1 = photoIcon.getImage(); // transform it
                        Image newimg1 = image.getScaledInstance(110, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                        BAffichage[i] = new JButton (new ImageIcon(newimg1));
                        BAffichage[i].setPreferredSize(new Dimension(110,160));
                        tab[i] = false;
                        if (photoIcon1.getImageLoadStatus() == MediaTracker.COMPLETE) {

                        }
                        else{
                            ListeOeuvre.remove(i);
                            i--;
                        }
                    }
                    Oeuvre.add(BAffichage[i]);
                }
            }
        panel.add(Oeuvre);
        }

    public void Afficher(){
        setContentPane(scrollPage);
        setLocationRelativeTo(null);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JButton getBFilms() {
        return BFilm;
    }
    public JButton getBSerie() {
        return BSerie;
    }
    public JButton getBRecherche() {
        return BRecherche;
    }
    public String getRecherche(){return recherche.getText();}
    public JButton getBRetourConnexion() {
        return BRetourConnexion;
    }
    public JButton getBAffichage(int i){return BAffichage[i];}

    public ArrayList<org.oeuvre.Oeuvre> getListeOeuvre(){return ListeOeuvre;};
    public boolean[] getTab(){return tab;}
}
