package main;

import controllers.TaskController;
import utils.Connect;

public class Main {
	TaskController taskController;
	
	public Main() {
		taskController = new TaskController();
		taskController.redirect();
	}

	public static void main(String[] args) {
		new Main();
	}

}
