package modele.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.dao.DBConnexion;
import modele.domaine.User;

public class UserMetierImpl implements UserMetierInterface {

    @Override
    public void addUser(User u) {
        Connection conn = DBConnexion.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO user VALUES (0,?,?,?,?)");
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getLogin());
            ps.setString(4, u.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> listUsers() {
        List<User> users = new ArrayList<>();
        Connection conn = DBConnexion.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setLogin(rs.getString("login"));
                u.setPassword(rs.getString("password"));
                users.add(u);
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserByLoginAndPassword(String l, String p) {
        Connection conn = DBConnexion.getConnection();
        User u = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE login = ? AND password = ?");
            ps.setString(1, l);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setLogin(rs.getString("login"));
                u.setPassword(rs.getString("password"));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public User getUserById(int id) {
        Connection conn = DBConnexion.getConnection();
        User u = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setLogin(rs.getString("login"));
                u.setPassword(rs.getString("password"));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public void updateUser(User u) {
        Connection conn = DBConnexion.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE user SET nom = ?, prenom = ?, login = ?, password = ? WHERE id = ?"
            );
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getLogin());
            ps.setString(4, u.getPassword());
            ps.setInt(5, u.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        Connection conn = DBConnexion.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM user WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
