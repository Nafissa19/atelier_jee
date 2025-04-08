package modele.dao;

import java.util.List;

import modele.domaine.User;


public interface UserDaoInterface {

    // Method to add a new user
    void addUser(User user);

    // Method to get a list of all users
    List<User> listUsers();

    // Method to get a user by login and password
    User getUserByLoginAndPassword(String login, String password);

    // Method to get a user by ID
    User getUserById(int id);

    // Method to update an existing user
    void updateUser(User user);

    // Method to delete a user by ID
    void deleteUser(int id);
}
