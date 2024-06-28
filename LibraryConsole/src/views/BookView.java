package views;

import java.util.Scanner;

import controllers.BookController;

public class BookView {
	private BookController bookController;
	private Scanner s;

	public BookView(BookController bookController) {
		this.bookController = bookController;
		s = new Scanner(System.in);
	}
	
	public void showMenu() {
		System.out.println("1. Display All");
		System.out.println("2. Insert Data");
		System.out.println("3. Update Data");
		System.out.println("4. Delete Data");
		System.out.println(">>");
		
		bookController.handleMenu(s.nextLine());
		
	}
	
}
