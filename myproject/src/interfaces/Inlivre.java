package interfaces;
import dto.Livre;

import java.util.List;

public interface Inlivre {

    boolean ajouterLivre(Livre livre);

    boolean modifierLivre(Livre livre);

    boolean supprimerLivreParISBN(int isbn);





    Livre obtenirLivreParISBN(int isbn);


    Livre obtenirLivreParTitre(String titre);

    List<Livre> obtenirTousLesLivres();
}
