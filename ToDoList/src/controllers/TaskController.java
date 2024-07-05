package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Task;
import utils.Connect;
import views.TaskView;

public class TaskController {
	private TaskView taskView;
	private Connect conn;
	
	public TaskController() {
		this.taskView = new TaskView(this);
		conn = Connect.getInstance();
	}
	
	public ArrayList<Task> getTasks(){
		ArrayList<Task> tasks = new ArrayList<Task>();
		
		String query = "SELECT * FROM tasks";
		
		PreparedStatement stmt;
		try {
			stmt = conn.getConn().
					prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Integer id = result.getInt(1);
				String title = result.getString(2);
				String status = result.getString(3);
				tasks.add(new Task(id, title, status));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}
	
	public void insertTask(String title, String status) {
		String query = "INSERT INTO tasks (title, status) VALUES (?,?)";
		
		try {
			PreparedStatement stmt = conn.getConn().prepareStatement(query);
			stmt.setString(1, title);
			stmt.setString(2, status);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		redirect();
	}
	
	public void menuHandler(String choice) {
		switch (choice) {
		case "1":
			taskView.view();
			break;
		case "2":
			taskView.insertView();
			break;
		default:
			break;
		}
	}
	
	public void redirect() {
		taskView.menu();
	}
}	