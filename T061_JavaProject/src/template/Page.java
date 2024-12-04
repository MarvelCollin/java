package template;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Page {
	public Stage stage;
	public Scene scene;
	
	public Page(Stage stage) {
		this.stage = stage;
		init();
	}
	
	public abstract void init();
	
	public void show() {
		stage.show();
	}
}
