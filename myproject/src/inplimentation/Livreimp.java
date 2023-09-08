package inplimentation;

import connection.Connectionbd;
import dto.Livre;
import interfaces.Inlivre;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Livreimp implements Inlivre {





    @Override
    public boolean ajouterLivre(Livre livre) {
        Connection con = Connectionbd.getConn();


        try {
            String sql = "INSERT INTO livre (isbn, titre, auteur, statut) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, livre.getIsbn());
            stmt.setString(2, livre.getTitre());
            stmt.setString(3, livre.getAuteur());
            stmt.setString(4, livre.getStatut());

            stmt.executeUpdate();
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }




    @Override
    public boolean modifierLivre(Livre livre) {

        Connection con = Connectionbd.getConn();

        try {
            String sql = "UPDATE livre SET titre = ?, auteur = ?, statut = ? WHERE isbn = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setString(3, livre.getStatut());
            stmt.setInt(4, livre.getIsbn());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerLivreParISBN(int isbn) {
        Connection con = Connectionbd.getConn();
        try {
            String sql = "DELETE FROM livre WHERE isbn = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, isbn);

           stmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }




    @Override
    public Livre obtenirLivreParISBN(int isbn) {
        Livre livre = new Livre();
        Connection con = Connectionbd.getConn();
        try {
            String sql = "SELECT * FROM livre WHERE isbn = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, isbn);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                int isbnResult = resultSet.getInt("isbn");
                String titre = resultSet.getString("titre");
                String auteur = resultSet.getString("auteur");
                String statut = resultSet.getString("statut");
                livre = new Livre(isbnResult, titre, auteur, statut);
                return livre;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Livre obtenirLivreParTitre(String titre) {
        Livre livre = new Livre();
        Connection con = Connectionbd.getConn();
        try {
            String sql = "SELECT * FROM livre WHERE titre = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, titre);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                int isbn = resultSet.getInt("isbn");
                String letitre = resultSet.getString("titre");
                String auteur = resultSet.getString("auteur");
                String statut = resultSet.getString("statut");
                livre = new Livre(isbn, letitre, auteur, statut);
                return livre;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Livre> obtenirTousLesLivres() {

        List<Livre> livres = new ArrayList<>();
        Connection con = Connectionbd.getConn();
        try {
            String sql = "SELECT * FROM livre";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int isbn = resultSet.getInt("isbn");
                String titre = resultSet.getString("titre");
                String auteur = resultSet.getString("auteur");
                String statut = resultSet.getString("statut");
                Livre livre = new Livre(isbn, titre, auteur, statut);
                livres.add(livre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livres;
    }

}
