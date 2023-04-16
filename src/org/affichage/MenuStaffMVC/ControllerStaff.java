package org.affichage.MenuStaffMVC;

import org.affichage.InterfaceGraphiqueMVC.ControllerInterface;
import org.affichage.InterfaceGraphiqueMVC.ModelInterface;
import org.affichage.InterfaceGraphiqueMVC.VueInterface;
import org.affichage.RechercheMVC.VueRecherche;
import org.compte.Compte;
import org.dao.BibliothequeDAO;
import org.dao.CompteDAO;

import javax.accessibility.Accessible;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerStaff implements ActionListener {

    private ModelStaff modelStaff;
    private VueStaff vueStaff;
    public ControllerStaff(ModelStaff modelStaff, VueStaff vueStaff){
        this.modelStaff = modelStaff;
        this.vueStaff = vueStaff;

        this.vueStaff.getBStaff().addActionListener(this);
        this.vueStaff.getBClient().addActionListener(this);
        this.vueStaff.getBModifierCompte().addActionListener(this);
        this.vueStaff.getBSupprimerCompte().addActionListener(this);
        this.vueStaff.getBAjouterSerie().addActionListener(this);
        this.vueStaff.getBSupprimerSerie().addActionListener(this);
        this.vueStaff.getBAjouterFilm().addActionListener(this);
        this.vueStaff.getBSupprimerFilm().addActionListener(this);

        this.vueStaff.getBValiderAjoutCompte().addActionListener(this);
        this.vueStaff.getBValiderSupprimeCompte().addActionListener(this);
        this.vueStaff.getBValiderAjoutFilm().addActionListener(this);
        this.vueStaff.getBValiderSupprimeFilm().addActionListener(this);
        this.vueStaff.getBValiderAjoutSerie().addActionListener(this);
        this.vueStaff.getBValiderSupprimeSerie().addActionListener(this);

        this.vueStaff.getBRetour().addActionListener(this);
        this.vueStaff.getBRetour1().addActionListener(this);
        this.vueStaff.getBRetour2().addActionListener(this);
        this.vueStaff.getBRetour3().addActionListener(this);
        this.vueStaff.getBRetour4().addActionListener(this);
        this.vueStaff.getBRetour5().addActionListener(this);

        this.vueStaff.getQuitter().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vueStaff.getBStaff()){
            this.vueStaff.AffichageMenuStaff();
        }

        else if(e.getSource() == this.vueStaff.getBClient()){
            this.vueStaff.dispose();
            ModelInterface modelInterface = new ModelInterface(this.modelStaff.getCompte(),1);
            VueInterface vueInterface = new VueInterface(this.modelStaff.getCompte(),1);
            ControllerInterface controllerInterface = new ControllerInterface(modelInterface, vueInterface);
            vueInterface.afficher();
        }

        else if(e.getSource() == this.vueStaff.getBModifierCompte()){
            this.vueStaff.AffichageModifierCompte();
        }

        else if(e.getSource() == this.vueStaff.getBSupprimerCompte()){
            this.vueStaff.AffichageSupprimerCompte();
        }

        else if(e.getSource() == this.vueStaff.getBAjouterFilm()) {
            this.vueStaff.AffichageAjouterFilm();
        }

        else if(e.getSource() == this.vueStaff.getBSupprimerFilm()){
            this.vueStaff.AffichageSupprimerFilm();
        }

        else if(e.getSource() == this.vueStaff.getBAjouterSerie()){
            this.vueStaff.AffichageAjouterSerie();
        }

        else if(e.getSource() == this.vueStaff.getBSupprimerSerie()){
            this.vueStaff.AffichageSupprimerSerie();
        }
        else if(e.getSource() == this.vueStaff.getBValiderAjoutCompte()){

            CompteDAO compteDAO = new CompteDAO();

            boolean verif;

            verif = compteDAO.modifierCompte(this.vueStaff.getPrenom(),this.vueStaff.getNom(),this.vueStaff.getMDP2(),this.vueStaff.getStaff(),this.vueStaff.getEmail());

            if (verif == false){
                this.vueStaff.InitErrorModifCompte();
            }
            else{
                this.vueStaff.InitOUIModifCompte();
            }
            this.vueStaff.AffichageModifierCompte();
        }
        else if(e.getSource() == this.vueStaff.getBValiderSupprimeCompte()){
            CompteDAO compteDAO = new CompteDAO();
            boolean verif;

            verif = compteDAO.supprimerCompte(this.vueStaff.getSupprimer());

            if (verif == false){
                this.vueStaff.InitErrorSupCompte();
            }
            else{
                this.vueStaff.InitOUISupCompte();
            }
            this.vueStaff.AffichageSupprimerCompte();

        }
        else if(e.getSource() == this.vueStaff.getBValiderSupprimeFilm()){
            BibliothequeDAO bibliothequeDAO = new BibliothequeDAO();
            boolean verif;

            verif = bibliothequeDAO.supprimerFilm(this.vueStaff.getSupprimerFilm());

            if (verif == false){
                this.vueStaff.InitErrorSupFilm();
            }
            else{
                this.vueStaff.InitOUISupFilm();
            }
            this.vueStaff.AffichageSupprimerFilm();
        }
        else if(e.getSource() == this.vueStaff.getBValiderSupprimeSerie()){
            BibliothequeDAO bibliothequeDAO = new BibliothequeDAO();
            boolean verif;

            verif = bibliothequeDAO.supprimerSerie(this.vueStaff.getSupprimerSerie());

            if (verif == false){
                this.vueStaff.InitErrorSupSerie();
            }
            else{
                this.vueStaff.InitOUISupSerie();
            }
            this.vueStaff.AffichageSupprimerSerie();

        }
        else if(e.getSource() == this.vueStaff.getBValiderAjoutFilm()){

        }
        else if(e.getSource() == this.vueStaff.getBValiderAjoutSerie()){

        }
        else if (e.getSource() == this.vueStaff.getBRetour() || e.getSource() == this.vueStaff.getBRetour1() || e.getSource() == this.vueStaff.getBRetour2() || e.getSource() == this.vueStaff.getBRetour3() || e.getSource() == this.vueStaff.getBRetour4() || e.getSource() == this.vueStaff.getBRetour5() ){
            this.vueStaff.AffichageMenuStaff();
        }
        else if(e.getSource() == this.vueStaff.getQuitter()){
            this.vueStaff.AffichageMenu();
            this.vueStaff.getBClient().addActionListener(this);
        }
    }

}
