package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import models.User;
import utils.Connect;
import views.UserView;

public class UserController {
	public Connect conn;
	public UserView userView;
	
	public UserController() {
		userView = new UserView(this);
		conn = Connect.getInstance();
	}
	
	public ArrayList<User> getUsers(){
		String query = "SELECT * FROM users";
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			PreparedStatement stmt = conn.getConn().prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Integer id = result.getInt(1);
				String username = result.getString(2);
				String password = result.getString(3);
				users.add(new User(id, username, password));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}
	
	public void insert(String username, String password) {
		String query = "INSERT INTO users (username, password) VALUES (?,?)";
		
		try {
			PreparedStatement stmt = conn.getConn().prepareStatement(query);
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		redirect();
	}
	
	public void redirect() {
		userView.menu();
	}
	
	public void menuHandler(String choice) {
		switch (choice) {
		case "1":
			userView.show(getUsers());
			break;
		case "2":
			userView.insertMenu();
			break;
		default:
			break;
		}
	}

}
