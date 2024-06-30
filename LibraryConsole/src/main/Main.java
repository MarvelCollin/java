package main;

import controllers.BookController;

public class Main {

	private BookController bookController;
	
	public Main() {
		bookController = new BookController();
		bookController.navigateToMenu();
	}

	public static void main(String[] args) {
		new Main();

	}

}
