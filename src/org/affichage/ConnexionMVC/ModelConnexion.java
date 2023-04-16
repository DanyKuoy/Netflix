package org.affichage.ConnexionMVC;

import org.compte.Compte;
import org.dao.CompteDAO;

public class ModelConnexion {

    private String ID_Connexion;
    private String MDP_Connexion;
    private String ID_Creation;
    private String MDP_Creation;
    private String Prenom_Creation;
    private String Nom_Creation;
    private String Prenom_Profil;


    private int IsStaff;
    private int IsResAge;
    private int IsRepriseVideo;
    private int Quality;

    private Compte compte;
    private CompteDAO compteDAO;

    public ModelConnexion(){
        compte = new Compte();
        compteDAO = new CompteDAO();
    }

    public String getID_Connexion(){
        return ID_Connexion;
    }
    public String getMDP_Connexion(){
        return MDP_Connexion;
    }
    public String getID_Creation(){
        return ID_Creation;
    }
    public String getMDP_Creation(){
        return MDP_Creation;
    }
    public String getPrenom_Creationn(){
        return Prenom_Creation;
    }
    public String getNom_Creation(){
        return Nom_Creation;
    }
    public String getPrenom_Profil(){
        return Prenom_Profil;
    }
    public int getIsStaff(){
        return IsStaff;
    }
    public int getIsResAge(){
        return IsResAge;
    }
    public int getIsRepriseVideo(){
        return IsRepriseVideo;
    }
    public int getQuality(){
        return Quality;
    }

    public Compte getCompte(){
        return compte;
    }
    public CompteDAO getCompteDAO(){
        return compteDAO;
    }


    public void setID_Connexion(String A){
        ID_Connexion = A;
    }
    public void setMDP_Connexion(String A){
        MDP_Connexion = A;
    }
    public void setID_Creation(String A){
        ID_Creation = A;
    }
    public void setMDP_Creation(String A){
        MDP_Creation = A;
    }
    public void setPrenom_Creationn(String A){
        Prenom_Creation = A;
    }
    public void setNom_Creation(String A){
        Nom_Creation = A;
    }
    public void setPrenom_Profil(String A){
        Prenom_Profil = A;
    }
    public void setIsStaff(int a){
        IsStaff = a;
    }
    public void setIsResAge(int a){
        IsResAge = a;
    }
    public void setIsRepriseVideo(int a){
        IsRepriseVideo = a;
    }
    public void setQuality(int a){
        Quality = a;
    }

    public void setCompte(Compte a){
        compte = a;
    }
    public void setCompteDAO(CompteDAO a){
        compteDAO = a;
    }


}
