package views;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.TaskController;
import models.Task;

public class TaskView {
	private TaskController taskController;
	private Scanner s = new Scanner(System.in); 
	
	public TaskView(TaskController taskController) {
		this.taskController = taskController;
	}
	
	public void view() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		tasks = taskController.getTasks();
		
		for (Task task : tasks) {
			System.out.println(task.getId() + " " + task.getTitle() + " | " + 
					task.getStatus());
		}
		s.nextLine();
		taskController.redirect();
	}
	
	public void insertView() {
		String title;
		String status;
		
		System.out.print("Insert title : ");
		title = s.nextLine();
		
		System.out.print("Insert status : ");
		status = s.nextLine();
		
		taskController.insertTask(title, status);
	}
	
	public void menu() {
		System.out.println("1. View Tasks");
		System.out.println("2. Insert Tasks");
		System.out.println("3. Update Tasks");
		System.out.println("4. Delete Tasks");
		System.out.print(">> ");
		taskController.menuHandler(s.nextLine());
	}
}
