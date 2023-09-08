package interfaces;

import dto.Emprunteur;

import java.util.List;

public interface Inemprunteur {
    Boolean ajouterEmprunteur(Emprunteur emprunteur);

    Boolean modifierEmprunteur(Emprunteur emprunteur);

    boolean supprimerEmprunteurParNumMembre(int numMembre);

    Emprunteur obtenirEmprunteurParNumMembre(int numMembre);

    List<Emprunteur> obtenirTousLesEmprunteurs();
}
