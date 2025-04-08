package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.dao.DBConnexion;
import modele.domaine.Produit;

public class ProduitMetierImpl {

    // Ajouter un produit
    public void ajouterProduit(Produit p) {
        Connection conn = DBConnexion.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO produit (code, designation, prix) VALUES (?,?,?)");
            ps.setString(1, p.getCode());
            ps.setString(2, p.getDesignation());
            ps.setDouble(3, p.getPrix());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lister tous les produits
    public List<Produit> listerProduits() {
        List<Produit> produits = new ArrayList<>();
        Connection conn = DBConnexion.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM produit");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setCode(rs.getString("code"));
                p.setDesignation(rs.getString("designation"));
                p.setPrix(rs.getDouble("prix"));
                produits.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    // Mettre à jour un produit
    public void updateProduit(Produit p) {
        Connection conn = DBConnexion.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE produit SET code = ?, designation = ?, prix = ? WHERE id = ?"
            );
            ps.setString(1, p.getCode());
            ps.setString(2, p.getDesignation());
            ps.setDouble(3, p.getPrix());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer un produit
    public void deleteProduit(int id) {
        Connection conn = DBConnexion.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM produit WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Récupérer un produit par ID
    public Produit getProduitById(int id) {
        Connection conn = DBConnexion.getConnection();
        Produit p = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM produit WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Produit();
                p.setId(rs.getInt("id"));
                p.setCode(rs.getString("code"));
                p.setDesignation(rs.getString("designation"));
                p.setPrix(rs.getDouble("prix"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
