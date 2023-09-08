import dto.Emprunteur;
import dto.Livre;
import inplimentation.Emprunteurimp;
import inplimentation.Livreimp;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Options:");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Afficher les livres");
        System.out.println("3. Rechercher les livres");
        System.out.println("4. Emprunter un livre");
        System.out.println("5. Retourner livre");
        System.out.println("6. Afficher les livres empruntés");
        System.out.println("7. Supprimer les livres");
        System.out.println("8. Modifier les livres");
        System.out.println("9. Ajouter un emprunteur");
        System.out.println("10. Modifier un emprunteur");
        System.out.println("11. Supprimer un emprunteur");
        System.out.println("12. Afficher  les emprunteurs");
        System.out.println("0. Quit");

        System.out.print("Enter your choice (1-12): ");
        int choice = scanner.nextInt();

        Main main = new Main();
        switch (choice) {
            case 1:
                main.ajout();
                break;
            case 2:
               main.supprimer();
            break;
            case 3:
                main.chercherparisbn();
                break;
            case 4:
                main.chercherpartitre();
                break;
            case 5:
                main.modifierLivre();
                break;
            case 6:
                main.toutlivres();
                break;
            case 7:
                main.ajoutemprunteur();
                break;
            case 8:
                main.emprunteurparnum();
                break;
            case 9:
                main.modifierEmprunteur();
                break;
            case 10:
                main.toutmprunteurs();
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option (1-4).");
        }

        scanner.close();


    }


    public void ajout() {
        Livreimp add = new Livreimp();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ISBN du livre : ");
        int isbn = scanner.nextInt();

        System.out.print("Entrez le titre du livre : ");
        String titre = scanner.next();

        System.out.print("Entrez l'auteur du livre : ");
        String auteur = scanner.next();

        System.out.print("Entrez le statut du livre : ");
        String statut = scanner.next();

        Livre livre = new Livre(isbn, titre, auteur, statut);


        boolean ajoutReussi = add.ajouterLivre(livre);
        if (ajoutReussi == true) {
            System.out.println("Livre ajouté avec succès !");
        } else {
            System.out.println("3yaaaaaan");
        }
        scanner.close();

    }


    public void chercherparisbn() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ISBN du livre chercher : ");
        int isbn = scanner.nextInt();

        Livreimp livreImp = new Livreimp();
        Livre livreTrouve = livreImp.obtenirLivreParISBN(isbn);

        if (livreTrouve != null) {
            System.out.println("Livre trouvé :");
            System.out.println("ISBN : " + livreTrouve.getIsbn());
            System.out.println("Titre : " + livreTrouve.getTitre());
            System.out.println("Auteur : " + livreTrouve.getAuteur());
            System.out.println("Statut : " + livreTrouve.getStatut());
        } else {
            System.out.println("Aucun livre trouvé avec cet ISBN.");
        }

        scanner.close();

    }

    public void chercherpartitre() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le titre du livre chercher : ");
        String titre = scanner.next();

        Livreimp livreImp = new Livreimp();
        Livre livreTrouve = livreImp.obtenirLivreParTitre(titre);

        if (livreTrouve != null) {
            System.out.println("Livre trouvé :");
            System.out.println("ISBN : " + livreTrouve.getIsbn());
            System.out.println("Titre : " + livreTrouve.getTitre());
            System.out.println("Auteur : " + livreTrouve.getAuteur());
            System.out.println("Statut : " + livreTrouve.getStatut());
        } else {
            System.out.println("Aucun livre trouvé avec cet ISBN.");
        }

        scanner.close();

    }

    public void modifierLivre() {
        Livreimp livreImp = new Livreimp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez l'ISBN du livre que vous souhaitez modifier :");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        Livre livreExistant = livreImp.obtenirLivreParISBN(isbn);

        if (livreExistant != null) {
            System.out.println("Entrez le nouveau titre du livre (laissez vide pour ne pas le modifier) :");
            String titre = scanner.nextLine();

            System.out.println("Entrez le nouvel auteur du livre (laissez vide pour ne pas le modifier) :");
            String auteur = scanner.nextLine();

            System.out.println("Entrez le nouveau statut du livre (laissez vide pour ne pas le modifier) :");
            String statut = scanner.nextLine();

            if (!titre.isEmpty()) {
                livreExistant.setTitre(titre);
            }
            if (!auteur.isEmpty()) {
                livreExistant.setAuteur(auteur);
            }
            if (!statut.isEmpty()) {
                livreExistant.setStatut(statut);
            }

            boolean modificationReussie = livreImp.modifierLivre(livreExistant);

            if (modificationReussie) {
                System.out.println("La modification du livre a été effectuée avec succès.");
            } else {
                System.out.println("La modification du livre a échoué.");
            }
        } else {
            System.out.println("Le livre avec l'ISBN donné n'existe pas.");
        }

        scanner.close();
    }


    public void supprimer(){
        Livreimp livreImp = new Livreimp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez l'ISBN du livre que vous souhaitez SUPPRIMER :");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        boolean livreTrouve = livreImp.supprimerLivreParISBN(isbn);
        if(livreTrouve){
            System.out.println("Le livre est supprimee :");
        }else{
            System.out.println("Le livre n'est pas supprimer");

        }


    }


    public void toutlivres(){
        Livreimp livreImp = new Livreimp();
        List<Livre> tousLesLivres = livreImp.obtenirTousLesLivres();

        if (tousLesLivres.isEmpty()) {
            System.out.println("Aucun livre trouvé.");
        } else {
            System.out.println("Liste de tous les livres :");
            for (Livre livre : tousLesLivres) {
                System.out.println("ISBN : " + livre.getIsbn());
                System.out.println("Titre : " + livre.getTitre());
                System.out.println("Auteur : " + livre.getAuteur());
                System.out.println("Statut : " + livre.getStatut());
                System.out.println("-----------------------");
            }
        }
    }


    public void ajoutemprunteur(){
        Emprunteurimp add = new Emprunteurimp();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le prenom de l'emprunteur : ");
        String prenom = scanner.next();

        System.out.print("Entrez le nom de l'emprunteur: ");
        String nom = scanner.next();

        System.out.print("Entrez le telephone de l'emprunteur : ");
        String telephone = scanner.next();

        System.out.print("Entrer le numero de membre de l'emprunteur : ");
        int num_membre = scanner.nextInt();

        Emprunteur emprunteur = new Emprunteur(prenom, nom, telephone, num_membre);


        boolean ajoutReussi = add.ajouterEmprunteur(emprunteur);
        if (ajoutReussi == true) {
            System.out.println("L'emprunteur ajouté avec succès !");
        } else {
            System.out.println("3yaaaaaan");
        }
        scanner.close();


    }

    public void modifierEmprunteur() {
        Emprunteurimp emprunteur = new Emprunteurimp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez l'ISBN du livre que vous souhaitez modifier :");
        int num_membre = scanner.nextInt();
        scanner.nextLine();

        Emprunteur emprunteurexist = emprunteur.obtenirEmprunteurParNumMembre(num_membre);

        if (emprunteurexist != null) {
            System.out.println("Entrez le Prénom de l'emprunteur (laissez vide pour ne pas le modifier) :");
            String prenom = scanner.nextLine();

            System.out.println("Entrez le nom de l'emprunteur (laissez vide pour ne pas le modifier) :");
            String nom = scanner.nextLine();

            System.out.println("Entrez le nouveau téléphone de l'emprunteur (laissez vide pour ne pas le modifier) :");
            String telephone = scanner.nextLine();

            if (!prenom.isEmpty()) {
                emprunteurexist.setPrenom(prenom);
            }
            if (!nom.isEmpty()) {
                emprunteurexist.setNom(nom);
            }
            if (!telephone.isEmpty()) {
                emprunteurexist.setTelephone(telephone);
            }

            boolean modificationReussie = emprunteur.modifierEmprunteur(emprunteurexist);

            if (modificationReussie) {
                System.out.println("La modification d'emprunteur a été effectuée avec succès.");
            } else {
                System.out.println("La modification d'emprunteur a été échouée.");
            }
        } else {
            System.out.println("d'emprunteur donné n'existe pas.");
        }

        scanner.close();
    }


    public void emprunteurparnum() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ISBN du livre chercher : ");
        int num_membre = scanner.nextInt();

        Emprunteurimp emprunteur = new Emprunteurimp();
        Emprunteur emprunteurTouve = emprunteur.obtenirEmprunteurParNumMembre(num_membre);


        if (emprunteurTouve != null) {
            System.out.println("Emprunteur trouvé :");
            System.out.println("Numero de membre : " + emprunteurTouve.getNum_membre());
            System.out.println("Prenom : " + emprunteurTouve.getPrenom());
            System.out.println("Nom : " + emprunteurTouve.getNom());
            System.out.println("Telephone : " + emprunteurTouve.getTelephone());
        } else {
            System.out.println("Aucun Emprunteur trouvé avec ce Numero de membre.");
        }

        scanner.close();

    }

    public void toutmprunteurs(){
        Emprunteurimp ttemprunteur = new Emprunteurimp();
        List<Emprunteur> emprunteurs = ttemprunteur.obtenirTousLesEmprunteurs();

        if (emprunteurs.isEmpty()) {
            System.out.println("Aucun livre trouvé.");
        } else {
            System.out.println("Liste de tous les Emprunteurs :");
            for (Emprunteur emprunteur : emprunteurs) {
                System.out.println("Prénom : " + emprunteur.getPrenom());
                System.out.println("Nom : " + emprunteur.getNom());
                System.out.println("Téléphone : " + emprunteur.getTelephone());
                System.out.println("Numéro de membre : " + emprunteur.getNum_membre());
                System.out.println("-----------------------");
            }
        }
    }

    public void suppEmpruteur(){
        Emprunteurimp emprunteur = new Emprunteurimp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le numéro de membre de l'emprunteur que vous souhaitez SUPPRIMER :");
        int num_membre = scanner.nextInt();
        scanner.nextLine();

        boolean emprunteurTrouve = emprunteur.supprimerEmprunteurParNumMembre(num_membre);
        if(emprunteurTrouve){
            System.out.println("L'amprunteur est supprime :");
        }else{
            System.out.println("Aucun emprunteur est avec ce numero de membre");
        }
    }
}