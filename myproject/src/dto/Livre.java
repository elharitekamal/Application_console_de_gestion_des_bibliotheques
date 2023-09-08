package dto;

import java.util.List;

public class Livre {
    private String titre;
    private String auteur;
    private int isbn;
    private String statut;//enum
    private List<Emprunt> emprunts;

    public Livre(int isbn, String titre, String auteur, String statut) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.statut = statut;
        //emprunts= new arr...
    }

    public Livre() {
    }



    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }




    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String status) {
        this.statut = status;
    }



}
