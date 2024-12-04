package main;

import controllers.UserController;
import utils.Connect;

public class Main {
	public Connect conn;
	public UserController userController;
	
	public Main() {
		userController = new UserController();
		conn = new Connect();
		userController.redirect();
	}
	
	public static void main(String[] args) {
		new Main();
	}	

}
