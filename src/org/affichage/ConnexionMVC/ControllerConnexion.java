package org.affichage.ConnexionMVC;

import org.affichage.FilmsMVC.ModelFilms;
import org.affichage.FilmsMVC.VueFilms;
import org.affichage.InterfaceGraphiqueMVC.ControllerInterface;
import org.affichage.InterfaceGraphiqueMVC.ModelInterface;
import org.affichage.InterfaceGraphiqueMVC.VueInterface;
import org.affichage.MenuStaffMVC.ControllerStaff;
import org.affichage.MenuStaffMVC.ModelStaff;
import org.affichage.MenuStaffMVC.VueStaff;
import org.compte.Profil;
import org.compte.*;
import org.dao.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerConnexion implements ActionListener {


    private VueConnexion vueConnexion;
    private ModelConnexion modelConnexion;

    public ControllerConnexion(VueConnexion vueConnexion, ModelConnexion modelConnexion){
        this.vueConnexion = vueConnexion;
        this.modelConnexion = modelConnexion;

        this.vueConnexion.getBConnexion().addActionListener(this);
        this.vueConnexion.getBConnecte().addActionListener(this);
        this.vueConnexion.getBCreation().addActionListener(this);

        this.vueConnexion.getBRetour().addActionListener(this);
        this.vueConnexion.getBRetour2().addActionListener(this);
        this.vueConnexion.getBRetour3().addActionListener(this);

        this.vueConnexion.getBCreer().addActionListener(this);
        this.vueConnexion.getBCreer2().addActionListener(this);

        this.vueConnexion.getBProfil1().addActionListener(this);
        this.vueConnexion.getBProfil2().addActionListener(this);
        this.vueConnexion.getBProfil3().addActionListener(this);
        this.vueConnexion.getBProfil4().addActionListener(this);

        this.vueConnexion.getBSupProfil1().addActionListener(this);
        this.vueConnexion.getBSupProfil2().addActionListener(this);
        this.vueConnexion.getBSupProfil3().addActionListener(this);
        this.vueConnexion.getBSupProfil4().addActionListener(this);

        this.vueConnexion.getBProfilCreer().addActionListener(this);
        this.vueConnexion.getBProfilValider().addActionListener(this);

        this.vueConnexion.getStaff().addActionListener(this);
        this.vueConnexion.getResAge().addActionListener(this);
        this.vueConnexion.getRepriseVideo().addActionListener(this);
        this.vueConnexion.getComboBox().addActionListener(this);
        this.vueConnexion.getComboBoxSousTitres().addActionListener(this);

    }


    public void actionPerformed(ActionEvent e) {
        // code à exécuter lorsqu'un événement est déclenché

        if(e.getSource() == this.vueConnexion.getBConnecte()){

            this.vueConnexion.AffichageConnexion();

        }

        else if(e.getSource() == this.vueConnexion.getBCreation()){

            this.vueConnexion.AffichageCreation();

        }

        else if(e.getSource() == this.vueConnexion.getBRetour() || e.getSource() == this.vueConnexion.getBRetour2()){

            this.vueConnexion.getpanelCreation().setVisible(false);
            this.vueConnexion.getpanelConnexion().setVisible(false);
            this.vueConnexion.getpanelProfil().setVisible(false);
            this.vueConnexion.getpanelCreationProfil().setVisible(false);

            this.vueConnexion.getID().setText("");
            this.vueConnexion.getMDP().setText("");
            this.vueConnexion.getID2().setText("");
            this.vueConnexion.getMDP2().setText("");
            this.vueConnexion.getPrenom().setText("");
            this.vueConnexion.getNom().setText("");

            this.vueConnexion.InitConnexionCreation();
            this.vueConnexion.getContentPane().add(this.vueConnexion.getpanel(), BorderLayout.CENTER);
            this.vueConnexion.revalidate();
            this.vueConnexion.repaint();

            this.vueConnexion.getpanel().setVisible(true);

        }

        //*Vérification de si l'utilisateur est dans la base de données*/
        //*Accès aux différents profils*/
        //*Accès à l'interface utilisateur de l'application*/

        else if(e.getSource() == this.vueConnexion.getBCreer()){
            //*Récupération de la saisie clavier*/
            this.modelConnexion.setID_Connexion(this.vueConnexion.getID().getText());
            this.modelConnexion.setMDP_Connexion(this.vueConnexion.getMDP().getText());

            boolean trouve = false;

            trouve = this.modelConnexion.getCompteDAO().verifierCompte(this.modelConnexion.getID_Connexion(), this.modelConnexion.getMDP_Connexion());
            if(trouve==true) {

                this.vueConnexion.setMDP("");
                this.vueConnexion.setID("");

                this.modelConnexion.setCompte(this.modelConnexion.getCompteDAO().chargerCompte(this.modelConnexion.getID_Connexion(), this.modelConnexion.getMDP_Connexion()));

                if(this.modelConnexion.getCompte().getNbProfil()>0) {
                    this.vueConnexion.getProfil1().setText(this.modelConnexion.getCompte().getListeProfil().get(0).getPrenomProfil());
                }
                if(this.modelConnexion.getCompte().getNbProfil()>1) {
                    this.vueConnexion.getProfil2().setText(this.modelConnexion.getCompte().getListeProfil().get(1).getPrenomProfil());
                }
                if(this.modelConnexion.getCompte().getNbProfil()>2) {
                    this.vueConnexion.getProfil3().setText(this.modelConnexion.getCompte().getListeProfil().get(2).getPrenomProfil());
                }
                if(this.modelConnexion.getCompte().getNbProfil()>3) {
                    this.vueConnexion.getProfil4().setText(this.modelConnexion.getCompte().getListeProfil().get(3).getPrenomProfil());
                }

                this.vueConnexion.InitProfil(this.modelConnexion.getCompte());

                this.modelConnexion.setID_Connexion("");
                this.modelConnexion.setMDP_Connexion("");

                this.vueConnexion.AffichageProfil();
            }
            else {

                this.vueConnexion.setID("");
                this.vueConnexion.setMDP("");

                this.modelConnexion.setID_Connexion("");
                this.modelConnexion.setMDP_Connexion("");
                this.vueConnexion.InitError();
            }
        }

        //*Ajout de l'utilisateur dans la base de données si il n'existe pas déjà*/
        else if(e.getSource() == this.vueConnexion.getBCreer2()){
            //*Récupération de la saisie clavier*/

            this.modelConnexion.setID_Creation(this.vueConnexion.getID2().getText());
            this.modelConnexion.setMDP_Creation(this.vueConnexion.getMDP2().getText());
            this.modelConnexion.setNom_Creation(this.vueConnexion.getNom().getText());
            this.modelConnexion.setPrenom_Creationn(this.vueConnexion.getPrenom().getText());

            if(this.vueConnexion.getStaff().isSelected()==true){
                this.modelConnexion.setIsStaff(1);
            }
            else {
                this.modelConnexion.setIsStaff(0);
            }

            boolean trouve = this.modelConnexion.getCompteDAO().verifierCreerCompte(this.modelConnexion.getID_Creation());
            if(trouve==false) {                 // Si le l'email n'existe pas dans la BDD
                this.modelConnexion.getCompteDAO().creerCompte(this.modelConnexion.getPrenom_Creationn(), this.modelConnexion.getNom_Creation(), this.modelConnexion.getID_Creation(), this.modelConnexion.getMDP_Creation(), this.modelConnexion.getIsStaff());

                this.vueConnexion.setID2("");
                this.vueConnexion.setMDP2("");
                this.vueConnexion.setNom("");
                this.vueConnexion.setPrenom("");

                this.modelConnexion.setID_Creation("");
                this.modelConnexion.setMDP_Creation("");
                this.modelConnexion.setNom_Creation("");
                this.modelConnexion.setPrenom_Creationn("");

                this.vueConnexion.getBRetour().doClick();
            }
            else {
                this.vueConnexion.setID2("");
                this.vueConnexion.setMDP2("");
                this.vueConnexion.setNom("");
                this.vueConnexion.setPrenom("");

                this.modelConnexion.setID_Creation("");
                this.modelConnexion.setMDP_Creation("");
                this.modelConnexion.setNom_Creation("");
                this.modelConnexion.setPrenom_Creationn("");

                this.vueConnexion.getBRetour().doClick();
            }

        }

        else if(e.getSource() == this.vueConnexion.getBProfilCreer()) {


            this.vueConnexion.AffichageNouveauProfil();

        }

        else if(e.getSource() == this.vueConnexion.getBProfilValider()){

            this.modelConnexion.setPrenom_Profil(this.vueConnexion.getPrenomProfil().getText());

            if(this.vueConnexion.getResAge().isSelected()== true) {
                this.modelConnexion.setIsResAge(1);
            }
            else{
                this.modelConnexion.setIsResAge(0);
            }

            if(this.vueConnexion.getRepriseVideo().isSelected()== true) {
                this.modelConnexion.setIsRepriseVideo(1);
            }
            else{
                this.modelConnexion.setIsRepriseVideo(0);
            }

            if(this.vueConnexion.getComboBoxString()== "Qualité vidéo basse") {
                this.modelConnexion.setQuality(0);
            }
            else if(this.vueConnexion.getComboBoxString()== "Qualité vidéo moyenne"){
                this.modelConnexion.setQuality(1);
            }
            else if(this.vueConnexion.getComboBoxString()== "Qualité vidéo haute"){
                this.modelConnexion.setQuality(2);
            }

            this.modelConnexion.setCompte(this.modelConnexion.getCompteDAO().chargerCompte(this.modelConnexion.getCompte().getEmailCompte(),this.modelConnexion.getCompte().getMdpCompte()));
            if(this.modelConnexion.getCompte().getNbProfil() < 4)
            {
                /// Ajout du nouveau profil dans la BDD
                this.modelConnexion.getCompteDAO().ajouterProfil(this.modelConnexion.getPrenom_Profil(), this.modelConnexion.getCompte().getEmailCompte(), this.modelConnexion.getIsResAge(), this.modelConnexion.getIsRepriseVideo(), this.modelConnexion.getQuality(), this.vueConnexion.getComboBoxSousTitreString());
            }
            /// Ajout du nouveau profil dans le compte
            boolean restrictionAge;
            boolean repriseVideo;
            if(this.modelConnexion.getIsResAge()==0) {
                restrictionAge = false;
            }
            else {
                restrictionAge = true;
            }
            if(this.modelConnexion.getIsRepriseVideo()==0) {
                repriseVideo = false;
            }
            else {
                repriseVideo = true;
            }
            this.modelConnexion.getCompte().getListeProfil().add(new Profil(this.modelConnexion.getPrenom_Profil(), this.modelConnexion.getCompte().getEmailCompte(), restrictionAge, repriseVideo, this.modelConnexion.getQuality(), this.vueConnexion.getComboBoxSousTitreString()));

            if(this.modelConnexion.getCompte().getNbProfil()>0) {
                this.vueConnexion.getProfil1().setText(this.modelConnexion.getCompte().getListeProfil().get(1).getPrenomProfil());
            }
            if(this.modelConnexion.getCompte().getNbProfil()>1) {
                this.vueConnexion.getProfil2().setText(this.modelConnexion.getCompte().getListeProfil().get(2).getPrenomProfil());
            }
            if(this.modelConnexion.getCompte().getNbProfil()>2) {
                this.vueConnexion.getProfil3().setText(this.modelConnexion.getCompte().getListeProfil().get(3).getPrenomProfil());
            }
            if(this.modelConnexion.getCompte().getNbProfil()>3) {
                this.vueConnexion.getProfil4().setText(this.modelConnexion.getCompte().getListeProfil().get(4).getPrenomProfil());
            }

            this.modelConnexion.setCompte(this.modelConnexion.getCompteDAO().chargerCompte(this.modelConnexion.getID_Connexion(), this.modelConnexion.getMDP_Connexion()));

            this.vueConnexion.InitProfil(this.modelConnexion.getCompte());
            this.vueConnexion.AffichageProfil();

            this.vueConnexion.getpanelCreation().setVisible(false);
            this.vueConnexion.getpanelConnexion().setVisible(false);
            this.vueConnexion.getpanelProfil().setVisible(true);
            this.vueConnexion.getpanel().setVisible(false);
            this.vueConnexion.getpanelCreationProfil().setVisible(false);
        }

        else if(e.getSource() == this.vueConnexion.getBProfil1() && this.modelConnexion.getCompte().getStaff() == false){
            this.vueConnexion.dispose();
            ModelInterface modelInterface = new ModelInterface(this.modelConnexion.getCompte(),1);
            VueInterface vueInterface = new VueInterface(this.modelConnexion.getCompte(),1);
            ControllerInterface controllerInterface = new ControllerInterface(modelInterface, vueInterface);
            vueInterface.afficher();

        }
        else if(e.getSource() == this.vueConnexion.getBProfil2() && this.modelConnexion.getCompte().getStaff() == false){
            this.vueConnexion.dispose();
            ModelInterface modelInterface = new ModelInterface(this.modelConnexion.getCompte(),2);
            VueInterface vueInterface = new VueInterface(this.modelConnexion.getCompte(),3);
            ControllerInterface controllerInterface = new ControllerInterface(modelInterface, vueInterface);
            vueInterface.afficher();
        }
        else if(e.getSource() == this.vueConnexion.getBProfil3() && this.modelConnexion.getCompte().getStaff() == false){
            this.vueConnexion.dispose();
            ModelInterface modelInterface = new ModelInterface(this.modelConnexion.getCompte(),3);
            VueInterface vueInterface = new VueInterface(this.modelConnexion.getCompte(),3);
            ControllerInterface controllerInterface = new ControllerInterface(modelInterface, vueInterface);
            vueInterface.afficher();
        }
        else if(e.getSource() == this.vueConnexion.getBProfil4() && this.modelConnexion.getCompte().getStaff() == false){
            this.vueConnexion.dispose();
            ModelInterface modelInterface = new ModelInterface(this.modelConnexion.getCompte(),4);
            VueInterface vueInterface = new VueInterface(this.modelConnexion.getCompte(),4);
            ControllerInterface controllerInterface = new ControllerInterface(modelInterface, vueInterface);
            vueInterface.afficher();
        }
        else if(e.getSource() == this.vueConnexion.getBProfil1() && this.modelConnexion.getCompte().getStaff() == true){
            this.vueConnexion.dispose();
            ModelStaff modelStaff = new ModelStaff(this.modelConnexion.getCompte(),1);
            VueStaff vueStaff = new VueStaff();
            ControllerStaff controllerStaff = new ControllerStaff(modelStaff, vueStaff);
            vueStaff.afficher();
        }
        else if(e.getSource() == this.vueConnexion.getBProfil2() && this.modelConnexion.getCompte().getStaff() == true){
            this.vueConnexion.dispose();
            ModelStaff modelStaff = new ModelStaff(this.modelConnexion.getCompte(),2);
            VueStaff vueStaff = new VueStaff();
            ControllerStaff controllerStaff = new ControllerStaff(modelStaff, vueStaff);
            vueStaff.afficher();
        }
        else if(e.getSource() == this.vueConnexion.getBProfil3() && this.modelConnexion.getCompte().getStaff() == true){
            this.vueConnexion.dispose();
            ModelStaff modelStaff = new ModelStaff(this.modelConnexion.getCompte(),3);
            VueStaff vueStaff = new VueStaff();
            ControllerStaff controllerStaff = new ControllerStaff(modelStaff, vueStaff);
            vueStaff.afficher();
        }
        else if(e.getSource() == this.vueConnexion.getBProfil4() && this.modelConnexion.getCompte().getStaff() == true){
            this.vueConnexion.dispose();
            ModelStaff modelStaff = new ModelStaff(this.modelConnexion.getCompte(),4);
            VueStaff vueStaff = new VueStaff();
            ControllerStaff controllerStaff = new ControllerStaff(modelStaff, vueStaff);
            vueStaff.afficher();
        }

        else if(e.getSource() == this.vueConnexion.getBRetour3()){
            this.vueConnexion.getpanelCreation().setVisible(false);
            this.vueConnexion.getpanelConnexion().setVisible(false);
            this.vueConnexion.getpanelProfil().setVisible(true);
            this.vueConnexion.getpanel().setVisible(false);
            this.vueConnexion.getpanelCreationProfil().setVisible(false);
            this.modelConnexion.setPrenom_Profil("");
        }
        else if(e.getSource() == this.vueConnexion.getBSupProfil1()){

            this.modelConnexion.getCompteDAO().supprimerProfil(this.modelConnexion.getID_Connexion(),this.vueConnexion.getProfil1().getText());

            this.modelConnexion.setCompte(this.modelConnexion.getCompteDAO().chargerCompte(this.modelConnexion.getID_Connexion(), this.modelConnexion.getMDP_Connexion()));

            if(this.modelConnexion.getCompte().getNbProfil()>0) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil1());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil1());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil1());

            }
            if(this.modelConnexion.getCompte().getNbProfil()>1) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil2());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil2());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil2());
                this.vueConnexion.getProfil1().setText(this.modelConnexion.getCompte().getListeProfil().get(0).getPrenomProfil());

            }
            if(this.modelConnexion.getCompte().getNbProfil()>2) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil3());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil3());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil3());
                this.vueConnexion.getProfil2().setText(this.modelConnexion.getCompte().getListeProfil().get(1).getPrenomProfil());

            }
            if(this.modelConnexion.getCompte().getNbProfil()>3) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil4());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil4());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil4());
                this.vueConnexion.getProfil3().setText(this.modelConnexion.getCompte().getListeProfil().get(2).getPrenomProfil());
            }

            this.vueConnexion.InitProfil(this.modelConnexion.getCompte());

            this.vueConnexion.AffichageProfil();
        }
        else if(e.getSource() == this.vueConnexion.getBSupProfil2()){

            this.modelConnexion.getCompteDAO().supprimerProfil(this.modelConnexion.getCompte().getEmailCompte(),this.vueConnexion.getProfil2().getText());

            this.modelConnexion.setCompte(this.modelConnexion.getCompteDAO().chargerCompte(this.modelConnexion.getID_Connexion(), this.modelConnexion.getMDP_Connexion()));

            if(this.modelConnexion.getCompte().getNbProfil()>0) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil1());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil1());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil1());

            }
            if(this.modelConnexion.getCompte().getNbProfil()>1) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil2());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil2());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil2());
                this.vueConnexion.getProfil1().setText(this.modelConnexion.getCompte().getListeProfil().get(0).getPrenomProfil());

            }
            if(this.modelConnexion.getCompte().getNbProfil()>2) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil3());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil3());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil3());
                this.vueConnexion.getProfil2().setText(this.modelConnexion.getCompte().getListeProfil().get(1).getPrenomProfil());

            }
            if(this.modelConnexion.getCompte().getNbProfil()>3) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil4());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil4());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil4());
                this.vueConnexion.getProfil3().setText(this.modelConnexion.getCompte().getListeProfil().get(2).getPrenomProfil());
            }

            this.vueConnexion.InitProfil(this.modelConnexion.getCompte());
            this.vueConnexion.AffichageProfil();
        }

        else if(e.getSource() == this.vueConnexion.getBSupProfil3()){

            this.modelConnexion.getCompteDAO().supprimerProfil(this.modelConnexion.getCompteDAO().getUsernameBDD(), this.vueConnexion.getProfil3().getText());

            this.modelConnexion.setCompte(this.modelConnexion.getCompteDAO().chargerCompte(this.modelConnexion.getID_Connexion(), this.modelConnexion.getMDP_Connexion()));

            if(this.modelConnexion.getCompte().getNbProfil()>0) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil1());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil1());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil1());

            }
            if(this.modelConnexion.getCompte().getNbProfil()>1) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil2());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil2());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil2());
                this.vueConnexion.getProfil1().setText(this.modelConnexion.getCompte().getListeProfil().get(0).getPrenomProfil());

            }
            if(this.modelConnexion.getCompte().getNbProfil()>2) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil3());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil3());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil3());
                this.vueConnexion.getProfil2().setText(this.modelConnexion.getCompte().getListeProfil().get(1).getPrenomProfil());

            }
            if(this.modelConnexion.getCompte().getNbProfil()>3) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil4());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil4());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil4());
                this.vueConnexion.getProfil3().setText(this.modelConnexion.getCompte().getListeProfil().get(2).getPrenomProfil());
            }

            this.vueConnexion.InitProfil(this.modelConnexion.getCompte());
            this.vueConnexion.AffichageProfil();
        }
        else if(e.getSource() == this.vueConnexion.getBSupProfil4()){

            this.modelConnexion.getCompteDAO().supprimerProfil(this.modelConnexion.getID_Connexion(),this.vueConnexion.getProfil4().getText());

            this.modelConnexion.setCompte(this.modelConnexion.getCompteDAO().chargerCompte(this.modelConnexion.getID_Connexion(), this.modelConnexion.getMDP_Connexion()));

            if(this.modelConnexion.getCompte().getNbProfil()>0) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil1());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil1());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil1());

            }
            if(this.modelConnexion.getCompte().getNbProfil()>1) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil2());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil2());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil2());
                this.vueConnexion.getProfil1().setText(this.modelConnexion.getCompte().getListeProfil().get(0).getPrenomProfil());

            }
            if(this.modelConnexion.getCompte().getNbProfil()>2) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil3());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil3());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil3());
                this.vueConnexion.getProfil2().setText(this.modelConnexion.getCompte().getListeProfil().get(1).getPrenomProfil());

            }
            if(this.modelConnexion.getCompte().getNbProfil()>3) {
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBProfil4());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getProfil4());
                this.vueConnexion.getpanelProfil().remove(this.vueConnexion.getBSupProfil4());
                this.vueConnexion.getProfil3().setText(this.modelConnexion.getCompte().getListeProfil().get(2).getPrenomProfil());
            }

            this.vueConnexion.InitProfil(this.modelConnexion.getCompte());
            this.vueConnexion.AffichageProfil();
        }
    }
}
