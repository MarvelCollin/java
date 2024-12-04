package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.User;
import utils.Connect;
import views.UserView;

public class UserController {
	private UserView userView;
	private Connect conn;
	
	public UserController() {
		this.userView = new UserView(this);
		conn = new Connect();
	}
	
	public void registering(String username, String password) {
		String query = "INSERT INTO users (username, password) VALUES (?, ?)";
		
		try {
			PreparedStatement stmt = conn.getConn().prepareStatement(query);
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public ArrayList<User> getUsers(){
		ArrayList<User> users = new ArrayList<User>();
		
		String query = "SELECT * FROM users";
		try {
			PreparedStatement stmt = conn.getConn().prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				Integer id = result.getInt(1);
				String username = result.getString(2);
				String passsword = result.getString(3);
				
				users.add(new User(id, username, passsword));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	public void logining(String username, String password) {
		String query = "SELECT username, password FROM users WHERE username = ?";
		
		try {
			PreparedStatement stmt = conn.getConn().prepareStatement(query);
			stmt.setString(1, username);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next() && result.getString(1).equals(username) && result.getString(2).equals(password)) {
				System.out.println("berhasil");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ArrayList<User> users = getUsers();
		
		for (User user : users) {
			if(user.getId() + ". " + user.getUsername() != null);
		}
	}
	
	public void redirect() {
		userView.menu();
	}
	
	public void handleMenu(String choice) {
		switch (choice) {
		case "1":
			userView.show(getUsers());
			break;
		case "2":
			userView.loginMenu();
		default:
			break;
		}
	}
	
	
	
}
