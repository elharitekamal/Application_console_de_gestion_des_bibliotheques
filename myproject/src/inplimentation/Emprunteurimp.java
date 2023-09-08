package inplimentation;

import connection.Connectionbd;
import dto.Emprunteur;
import dto.Livre;
import interfaces.Inemprunteur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Emprunteurimp implements Inemprunteur {


    @Override
    public Boolean ajouterEmprunteur(Emprunteur emprunteur) {
        Connection con = Connectionbd.getConn();


        try {
            String sql = "INSERT INTO emprunteur (prenom, nom, telephone, num_membre) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, emprunteur.getPrenom());
            stmt.setString(2, emprunteur.getNom());
            stmt.setString(3, emprunteur.getTelephone());
            stmt.setInt(4, emprunteur.getNum_membre());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean modifierEmprunteur(Emprunteur emprunteur) {
        Connection con = Connectionbd.getConn();

        try {
            String sql = "UPDATE emprunteur SET prenom = ?, nom = ?, telephone = ? WHERE num_membre = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, emprunteur.getPrenom());
            stmt.setString(2, emprunteur.getNom());
            stmt.setString(3, emprunteur.getTelephone());
            stmt.setInt(4, emprunteur.getNum_membre());

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
    public boolean supprimerEmprunteurParNumMembre(int numMembre) {
        Connection con = Connectionbd.getConn();
        try {
            String sql = "DELETE FROM emprunteur WHERE num_membre = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, numMembre);

            stmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Emprunteur obtenirEmprunteurParNumMembre(int num_membre) {
        Emprunteur emprunteur = new Emprunteur();
        Connection con = Connectionbd.getConn();
        try {
            String sql = "SELECT * FROM emprunteur WHERE num_membre = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, num_membre);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                int Num_membre = resultSet.getInt("num_membre");
                String prenom = resultSet.getString("prenom");
                String nom = resultSet.getString("nom");
                String telephone = resultSet.getString("telephone");
                emprunteur = new Emprunteur(prenom, nom, telephone, Num_membre);
                return emprunteur;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Emprunteur> obtenirTousLesEmprunteurs() {

        List<Emprunteur> emprunteurs = new ArrayList<>();
        Connection con = Connectionbd.getConn();
        try {
            String sql = "SELECT * FROM emprunteur";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int num_membre = resultSet.getInt("num_membre");
                String prenom = resultSet.getString("prenom");
                String nom = resultSet.getString("nom");
                String telephone = resultSet.getString("telephone");
                Emprunteur emprunteur = new Emprunteur(prenom, nom, telephone, num_membre);
                emprunteurs.add(emprunteur);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emprunteurs;
    }

}
