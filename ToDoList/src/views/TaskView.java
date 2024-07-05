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
		System.out.println();
		for (Task task : tasks) {
			System.out.println(task.getId() + " " + task.getTitle() + " | " + 
					task.getStatus());
		}
		System.out.println();
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
	
	public void updateView() {
		view();
		
		Integer id;
		String title;
		String status;
		
		System.out.println();
		System.out.println("Input ID : ");
		id = s.nextInt(); s.nextLine();
		System.out.println("Input Title : ");
		title = s.nextLine();
		System.out.println("Input Status : ");
		status = s.nextLine();
		
		taskController.updateTask(id, title, status);
	}
	
	public void deleteView() {
		view();
		
		Integer id;
		
		System.out.println();
		System.out.println("Input ID : ");
		id = s.nextInt(); s.nextLine();
		taskController.deleteTask(id);
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
