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
		System.out.println("1. Display All");
		System.out.println("2. Insert Data");
		System.out.println("3. Update Data");
		System.out.println("4. Delete Data");
		System.out.println(">>");
		
		bookController.handleMenu(s.nextLine());
	}
	
	public void displayBooks(ArrayList<Book> books) {
		System.out.println("Current Books: ");
		for (Book book : books) {
			System.out.println(book.getId() + " " + book.getAuthor() + " " + book.getName());
		}
	}
	
	public void insertBooks() {
		String name, author;
		System.out.print("Input Name : ");
		name = s.nextLine();
		
		System.out.print("Input Author : ");
		author = s.nextLine(); 
		
		bookController.insertBook(name, author);
	}
	
	public void updateBooks() {
		Integer id;
		String name, author;
		System.out.print("ID : ");
		id = s.nextInt(); s.nextLine();
		
		System.out.println("Name : ");
		name = s.nextLine();
		
		System.out.println("Author : ");
		author = s.nextLine();
		
		bookController.update(id, name, author);
	}
	
	public void deleteBook() {
		Integer id;
		System.out.println("Input ID : ");
		id = s.nextInt(); s.nextLine();
		
		bookController.remove(id);
	}
	
}
