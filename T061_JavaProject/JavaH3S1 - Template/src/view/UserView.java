package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import model.User;

public class UserView {
	Scene scene;
	
	private VBox main;
	private Button loadCSV;
	private FileChooser fileChooser;
	
	private TabPane tabPane;
	private Tab tableView, listView;
	private TableView<User> userTable;
	private TableColumn<User, String> nameCol, emailCol, phoneCol;
	
	private VBox userList;
	private ScrollPane userScroll;
	
	public UserView() {
		init();
	}
	
	public void init() {
		main = new VBox();
		fileChooser = new FileChooser();
		loadCSV = new Button("Load CSV File");
		tabPane = new TabPane();
		tableView = new Tab("Table View");
		listView = new Tab("List View");
		userTable = new TableView<User>();
		userList = new VBox();
		userScroll = new ScrollPane();
		listView.setContent(loadCSV);
		
		userList.setSpacing(10);
		userScroll.setContent(userList);
		listView.setContent(userScroll);
		
		nameCol = new TableColumn<User, String>("Name");
		nameCol.setCellValueFactory(data -> data.getValue().getFullName());
		
		emailCol = new TableColumn<User, String>("Email");
		emailCol.setCellValueFactory(data ->data.getValue().getEmail());
		
		phoneCol = new TableColumn<User, String>("Phone");
		phoneCol.setCellValueFactory(data ->data.getValue().getPhoneNumber());
		
		userTable.getColumns().addAll(nameCol, emailCol, phoneCol);
		emailCol = new TableColumn<User, String>("Email");
		phoneCol = new TableColumn<User, String>("Phone");
		
		tableView.setContent(userTable);
		tabPane.getTabs().addAll(tableView, listView);

		main.getChildren().addAll(loadCSV, tabPane);
		main.setAlignment(Pos.TOP_CENTER);
		main.setSpacing(10);

		scene = new Scene(main);
	}
	
	public TableView<User> getUserTable() {
		return userTable;
	}

	public Button getLoadCSV() {
		return loadCSV;
	}
	
	public FileChooser getFileChooser() {
		return fileChooser;
	}

	public Scene getScene() {
		return scene;
	}
	
	public VBox createUserCard(User user) {
		VBox card = new VBox();
		Label name,email,phone;
		name = new Label(user.getFullName().getValue());
		email = new Label(user.getEmail().getValue());
		phone = new Label(user.getPhoneNumber().getValue());
		name.setStyle("-fx-font-size: 30;");
		card.getChildren().addAll(name, email, phone);
		return card;
	}
	
	public void updateUserCard(ArrayList<User> userList) {
		for(User user: userList) {
			this.userList.getChildren().add(createUserCard(user));
		}
	}
}
