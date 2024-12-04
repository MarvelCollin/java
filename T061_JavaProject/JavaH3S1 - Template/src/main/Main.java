package main;

import controller.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("User Database");
		stage.setWidth(1280);
		stage.setHeight(720);
		SceneController.init(stage);
		stage.show();
		
	}
}