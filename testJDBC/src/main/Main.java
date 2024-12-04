package main;


import controllers.UserController;
import utils.Connect;

public class Main {
	public UserController userController;
	
	public Main() {
		userController = new UserController();
		userController.redirect();
	}

	public static void main(String[] args) {
		new Main();
	}

}
