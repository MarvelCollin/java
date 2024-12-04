package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.User;
import view.UserView;

public class UserController {
	private UserView userView;
	private ArrayList<User> userList;
	
	public UserController() {
		userView = new UserView();
		userList = new ArrayList<>();
		addEvent();
	}
	
	private void addEvent() {
		userView.getLoadCSV().setOnMouseClicked(e -> {
			FileChooser fc = userView.getFileChooser();
			fc.getExtensionFilters().add(new ExtensionFilter(""
					+ "CSV File", "*.csv"));
			File file = fc.showOpenDialog(null);
			if(file != null) {
				loadUserData(file);
			}
		});
	}
	
	private void loadUserData(File file) {
		try {
			BufferedReader read = new BufferedReader(new FileReader(file));
			String input;
			
			try {
				while((input = read.readLine()) != null) {
					String split[] = input.split(",");
					userList.add(new User(split[0], split[1], split[2]));
				}
			
				read.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		userView.getUserTable().getItems().clear();
		userView.getUserTable().getItems().addAll(userList);
		
		userView.updateUserCard(userList);
	}

	public UserView getUserView() {
		return userView;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}
	
}
