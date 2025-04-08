package modele.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modele.domaine.User;


public class UserDaoImpl implements UserDaoInterface {

    @Override
    public void addUser(User user) {
        try (Connection conn = DBConnexion.getConnection()) {
            String query = "INSERT INTO user (nom, prenom, login, password) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, user.getNom());
                ps.setString(2, user.getPrenom());
                ps.setString(3, user.getLogin());
                ps.setString(4, user.getPassword());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> listUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DBConnexion.getConnection()) {
            String query = "SELECT * FROM user";
            try (PreparedStatement ps = conn.prepareStatement(query);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setNom(rs.getString("nom"));
                    user.setPrenom(rs.getString("prenom"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        User user = null;
        try (Connection conn = DBConnexion.getConnection()) {
            String query = "SELECT * FROM user WHERE login = ? AND password = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, login);
                ps.setString(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        user = new User();
                        user.setId(rs.getInt("id"));
                        user.setNom(rs.getString("nom"));
                        user.setPrenom(rs.getString("prenom"));
                        user.setLogin(rs.getString("login"));
                        user.setPassword(rs.getString("password"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        try (Connection conn = DBConnexion.getConnection()) {
            String query = "SELECT * FROM user WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        user = new User();
                        user.setId(rs.getInt("id"));
                        user.setNom(rs.getString("nom"));
                        user.setPrenom(rs.getString("prenom"));
                        user.setLogin(rs.getString("login"));
                        user.setPassword(rs.getString("password"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        try (Connection conn = DBConnexion.getConnection()) {
            String query = "UPDATE user SET nom = ?, prenom = ?, login = ?, password = ? WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, user.getNom());
                ps.setString(2, user.getPrenom());
                ps.setString(3, user.getLogin());
                ps.setString(4, user.getPassword());
                ps.setInt(5, user.getId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try (Connection conn = DBConnexion.getConnection()) {
            String query = "DELETE FROM user WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
