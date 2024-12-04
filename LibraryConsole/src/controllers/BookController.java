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
			e.printStackTrace();
		}
		
		return books;
	}
	
	public void insertBook(String name, String author) {
		String query = "INSERT INTO books (name, author) VALUES (?,?)";
		
		PreparedStatement statement;
		try {
			statement = conn.getConn().prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, author);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void update(Integer id, String name, String author) {
        String query = "UPDATE books SET name = ?, author = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.getConn().prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, author);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public void remove(Integer id) {
    	String query = "DELETE FROM books WHERE id = ?";
    	
    	try {
			PreparedStatement stmt = conn.getConn().prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public void navigateToMenu() {
		bookView.showMenu();
	}
	
	public void handleMenu(String choice) {
		switch(choice) {
			case "1":
//				bookView.displayBooks(getBooks());
				break;
			case "2":
				bookView.insertBooks();
				break;
			case "3":
//				bookView.displayBooks(getBooks());
				bookView.updateBooks();
				break;
			case "4":
//				bookView.displayBooks(getBooks());
				bookView.deleteBook();
				break;
			default:
				break;
		}
	}
}
