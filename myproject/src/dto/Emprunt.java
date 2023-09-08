package dto;

import java.util.Date;

public class Emprunt {


    private Date dateEmprunt;
    private Livre livre;

    private Emprunteur emprunteur ;

    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }
// const par defaut

    public Emprunt(Date dateEmprunt, Livre livre, Emprunteur emprunteur) {
        this.dateEmprunt = dateEmprunt;
        this.livre = livre;
        this.emprunteur = emprunteur;
    }


    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }




    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }


}
