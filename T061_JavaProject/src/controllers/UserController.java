package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.User;
import utils.Connect;
import views.LoginView;

public class UserController {
    private LoginView loginView;
    private Connect conn;

    public UserController() {
        this.loginView = new LoginView(this);
        conn = Connect.getInstance();
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        String query = "SELECT * FROM msuser";

        try {
            PreparedStatement statement = conn.getConn().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String id = result.getString(1);
                String name = result.getString(2);
                String email = result.getString(3);
                String password = result.getString(4);
                String dob = result.getString(5);
                Integer isPremium = result.getInt(6);
                String profilePicture = result.getString(7);
                String headerImage = result.getString(8);
                String theme = result.getString(9);
                users.add(new User(id, name, email, 
                		dob, password, isPremium,profilePicture, headerImage, theme));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void insertUser(String name, String password, String email) {
    	ArrayList<User> users = getUsers();
    	
    	String value = users.get(users.size() - 1).getUserId();
    	String cutted = value.substring(value.length() - 3);
    	int lastId = Integer.parseInt(cutted) + 1;
    	
    	String id = "US" + String.valueOf(lastId);
    	
        String query = "INSERT INTO msuser (userId ,username, email , password, dob, isPremium, profilePicture"
        		+ "	 , headerImage, theme) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.getConn().prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, "2004-03-01");
            stmt.setString(6, "1");
            stmt.setString(7, "NULL");
            stmt.setString(8, "NULL");
            stmt.setString(9, "black");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean login(String email, String password) {
        String query = "SELECT * FROM msuser WHERE email = ? AND password = ?";
        
        try {
            PreparedStatement statement = conn.getConn().prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                System.out.println("Login successful!");
                String userId = result.getString("userId");
                String userName = result.getString("username");
                String userEmail = result.getString("email");
                return true;
            } else {
                System.out.println("Invalid email or password. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void changePassword(String email, String password) {
    	String query = "UPDATE msuser SET password = ? WHERE email = ?";
    	
    	try {
            PreparedStatement stmt = conn.getConn().prepareStatement(query);
            stmt.setString(1, password);
            stmt.setString(2, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Integer id, String name, String email) {
        String query = "UPDATE msuser SET username = ?, email = ? WHERE userId = ?";

        try {
            PreparedStatement stmt = conn.getConn().prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(Integer id) {
        String query = "DELETE FROM msuser WHERE id = ?";

        try {
            PreparedStatement stmt = conn.getConn().prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void handleMenu(String choice) {
//        switch (choice) {
//            case "1":
//                loginView.displayUsers(getUsers());
//                break;
//            case "2":
//                loginView.showRegistration();
//                break;
//            case "3":
//                loginView.displayUsers(getUsers());
//                loginView.updateUser();
//                break;
//            case "4":
//                loginView.displayUsers(getUsers());
//                loginView.deleteUser();
//                break;
//            default:
//                break;
//        }
//    }
}
