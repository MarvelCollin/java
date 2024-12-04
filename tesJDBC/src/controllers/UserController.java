package controllers;

import views.UserView;

public class UserController {
	private UserView userView;
	
	
	public UserController() {
		this.userView = new UserView(this);
	}

}
