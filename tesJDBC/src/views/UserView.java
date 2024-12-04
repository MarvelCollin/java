package views;

import java.util.Scanner;

import controllers.UserController;

public class UserView {
	private UserController userController;
	private Scanner s;
	
	public UserView(UserController userController) {
		this.userController = userController;
		s = new Scanner(System.in);
	}

	public void menu() {
		System.out.println("1. show all");
		System.out.print("input > ");
	}
}