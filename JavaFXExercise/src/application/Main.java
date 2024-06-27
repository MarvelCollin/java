package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{

//	Scene scene = new Scene(new BorderPane());
	Scene scene;
	BorderPane layoutBorder;
	GridPane gridLayout;
	FlowPane flowLayout;
	
	Button btn1, btn2, btn3, btn4;
	
	public void initialize() {
		layoutBorder = new BorderPane();
		gridLayout = new GridPane();
		flowLayout = new FlowPane();
		
		btn1 = new Button("Button 1");
		btn2 = new Button("Button 2");
		btn3 = new Button("Button 3");
		btn4 = new Button("Button 4");
		
//		flowLayout.getChildren().add(btn1);
//		flowLayout.getChildren().add(btn2);
//		flowLayout.getChildren().add(btn3);
//		flowLayout.getChildren().add(btn4);
		
//		scene = new Scene(flowLayout, 500, 500);
		
		gridLayout.add(btn1, 0, 0);
		gridLayout.add(btn2, 1, 0);
		gridLayout.add(btn3, 0, 1);
		gridLayout.add(btn4, 1, 1);
		
		scene = new Scene(gridLayout, 500, 500);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		initialize();
		stage.setTitle("Form Registrasi");
		
//		stage.setFullScreen(true);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
