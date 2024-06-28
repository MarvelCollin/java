package controllers;

import views.BookView;

public class BookController {
	private BookView bookView;

	public BookController() {
		this.bookView = new BookView(this);
	}
	
	
}
