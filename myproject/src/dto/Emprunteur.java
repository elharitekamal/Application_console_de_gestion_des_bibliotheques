package dto;

import java.util.List;

public class Emprunteur {


    // Attributes
    private int num_membre;
    private String nom;
    private String prenom;
    private String telephone;

    private List<Emprunt> emprunts;


    public Emprunteur(String prenom, String nom, String telephone, int num_membre)  {
        this.num_membre = num_membre;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;

    }




    public Emprunteur (){
    }




    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }



    public int getNum_membre() {
        return num_membre;
    }

    public void setNum_membre(int num_membre) {
        this.num_membre = num_membre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
