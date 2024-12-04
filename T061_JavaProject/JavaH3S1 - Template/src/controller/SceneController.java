package controller;

import javafx.stage.Stage;
import view.UserView;

public class SceneController {
	public static UserController userController;
	
	public static void init(Stage stage) {
		userController = new UserController();
		stage.setScene(userController.getUserView().getScene());
	}
}
