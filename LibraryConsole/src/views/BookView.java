package views;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.BookController;
import models.Book;

public class BookView {
	private BookController bookController;
	private Scanner s;

	public BookView(BookController bookController) {
		this.bookController = bookController;
		s = new Scanner(System.in);
	}
	
	public void showMenu() {
		
	}
	
	
	
	public void insertBooks() {
		
	}
	
	public void updateBooks() {
	}
	
	public void deleteBook() {
	}
	
}
