package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Book;
import utils.Connect;
import views.BookView;

public class BookController {
	private BookView bookView;
	private Connect conn;

	public BookController() {
		this.bookView = new BookView(this);
		conn = Connect.getInstance();
	}
	
	public ArrayList<Book> getBooks() {
		ArrayList<Book> books = new ArrayList<>();
		
		String query = "SELECT * FROM books";
		
		try {
			PreparedStatement statement = conn.getConn().prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Integer id = result.getInt(1);
				String name = result.getString(2);
				String author = result.getString(3);
				books.add(new Book(id, name, author));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
	
	public void handleMenu(String choice) {
		switch(choice) {
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			default:
				break;
		}
	}
}
