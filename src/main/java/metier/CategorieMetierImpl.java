package metier;

import modele.dao.DBConnexion;
import modele.domaine.Categorie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieMetierImpl {

    public void ajouterCategorie(Categorie c) {
        try (Connection conn = DBConnexion.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO categorie (code, libelle) VALUES (?, ?)");
            ps.setString(1, c.getCode());
            ps.setString(2, c.getLibelle());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifierCategorie(Categorie c) {
        try (Connection conn = DBConnexion.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE categorie SET code = ?, libelle = ? WHERE id = ?");
            ps.setString(1, c.getCode());
            ps.setString(2, c.getLibelle());
            ps.setInt(3, c.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void supprimerCategorie(int id) {
        try (Connection conn = DBConnexion.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM categorie WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Categorie getCategorieById(int id) {
        try (Connection conn = DBConnexion.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM categorie WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categorie c = new Categorie();
                c.setId(rs.getInt("id"));
                c.setCode(rs.getString("code"));
                c.setLibelle(rs.getString("libelle"));
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Categorie> listerCategories() {
        List<Categorie> list = new ArrayList<>();
        try (Connection conn = DBConnexion.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM categorie");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categorie c = new Categorie();
                c.setId(rs.getInt("id"));
                c.setCode(rs.getString("code"));
                c.setLibelle(rs.getString("libelle"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
