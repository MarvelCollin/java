package views;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.UserController;
import models.User;

public class UserView {
	private UserController userController;
	private Scanner s;
	
	public UserView(UserController userController) {
		this.userController = userController;
		s = new Scanner(System.in);
	}
	
	public void registerMenu() {
		String username, password;
		System.out.print("Username : ");
		username = s.nextLine();

		System.out.print("Password : ");
		password = s.nextLine();
		
		userController.registering(username, password);
	}

	public void show(ArrayList<User> users) {
		users = userController.getUsers();
		
		for (User user : users) {
			System.out.println(user.getId() + " " + user.getUsername() + " ");
		}
	}
	
	public void loginMenu() {
		String username;
		String password;
		
		System.out.println("Login");
		System.out.print("Username : ");
		username = s.nextLine();
		System.out.print("Password : ");
		password = s.nextLine();
		
		userController.logining(username, password);
	}
	
	public void menu() {
		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("3. Show User");
		System.out.println("Input : ");
		
		userController.handleMenu(s.nextLine());
	}
}
