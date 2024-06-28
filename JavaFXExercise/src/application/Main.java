package application;

import java.awt.FlowLayout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{

	Scene scene;
	BorderPane mainLayout;
	FlowLayout flowLayout;
	GridPane topLayout, centerLayout, botLayout;
	FlowPane flowName, flowjenisKelamin;
	
	Label logo, title, name, password, confirm, address, jenisKelamin, status;
	
	TextField firstNameInput, lastNameInput;	
	PasswordField passInput, confirmPasswordInput;
	TextArea addressInput;
	RadioButton priaInput, wanitaInput;
	ToggleGroup jenisKelaminGroup;
	ComboBox<String> statusInput;
	
	CheckBox agree;
	
	Button submit;
	
	public void initTop() {
		logo = new Label("Regis");
		title = new Label("Register Your Account");
		
		topLayout.add(logo, 0, 0);
		topLayout.add(title, 1, 0);
		topLayout.setHgap(100);
	}
	
	public void initBot() {
		agree = new CheckBox("Saya Setuju");
		submit = new Button("Submit");
		
		botLayout.add(agree,0, 0);
		botLayout.add(submit, 0, 1);
	}
	
	public void initCenter() {
		name = new Label("Username : ");
		password = new Label("Password : ");
		confirm = new Label("Confirm Password : ");
		address = new Label("Address : ");
		jenisKelamin = new Label("Jenis Kelamin : ");
		status = new Label("Status : ");
		
		firstNameInput = new TextField("Nama Depan");
		lastNameInput = new TextField("Nama Belakang");
		passInput = new PasswordField();
		confirmPasswordInput = new PasswordField();
		addressInput = new TextArea();
		priaInput = new RadioButton("Pria");
		wanitaInput = new RadioButton("Wanita");
		jenisKelaminGroup = new ToggleGroup();
		statusInput = new ComboBox<String>();
		
		centerLayout.add(name, 0, 0);
		centerLayout.add(password, 0,1);
		centerLayout.add(confirm, 0,2);
		centerLayout.add(address, 0,3);
		centerLayout.add(jenisKelamin, 0,4);
		centerLayout.add(status, 0,5);
		
		centerLayout.setHgap(100);
		priaInput.setToggleGroup(jenisKelaminGroup);
		wanitaInput.setToggleGroup(jenisKelaminGroup);
		statusInput.getItems().add("Single");
		statusInput.getItems().add("Married");
		
		centerLayout.add(firstNameInput, 1, 0);
		centerLayout.add(lastNameInput, 2, 0);
		centerLayout.add(passInput, 1, 1);
		centerLayout.add(confirmPasswordInput, 1, 2);
		centerLayout.add(addressInput, 1, 3);
		centerLayout.add(priaInput, 1, 4);
		centerLayout.add(wanitaInput, 2, 4);
		centerLayout.add(statusInput, 1, 5);
	}
	
	
	public void initialize() {
		mainLayout = new BorderPane();
		topLayout = new GridPane();
		centerLayout = new GridPane();
		botLayout = new GridPane();
		
		flowName = new FlowPane();
		flowjenisKelamin = new FlowPane();
		
		mainLayout.setTop(topLayout);
		mainLayout.setCenter(centerLayout);
		mainLayout.setBottom(botLayout);
			
		scene = new Scene(mainLayout, 500,500);
		
		initCenter();
		initTop();
		initBot();
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		initialize();
		stage.setTitle("Form Registrasi");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
