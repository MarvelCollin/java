package views;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.UserController;
import models.User;

public class UserView {
	public UserController userController;
	private Scanner s;
	
	public UserView(UserController userController) {
		this.userController = userController;
		s = new Scanner(System.in);
	}
	
	public void show(ArrayList<User> users) {
		for (User user : users) {
			System.out.println(user.getId() + " " + user.getUsername() + " " + user.getPassword());
		}
	}
	
	public void insertMenu() {
		String username;
		String password;
		System.out.print("username : ");
		username = s.nextLine();
		System.out.println("password : ");
		password = s.nextLine();
		
		userController.insert(username, password);
	}
	
	public void menu() {
		System.out.println("1. Show All");
		System.out.println("2. Insert");
		System.out.print("Input > ");
		userController.menuHandler(s.nextLine());
	}
}
