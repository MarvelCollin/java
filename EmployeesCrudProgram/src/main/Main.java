package main;


import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.Employees;

public class Main {
	private Scanner s = new Scanner(System.in);
	private Functions func = new Functions();
	private Vector<Employees> employee = new Vector<Employees>();

	private void clr() {
		for(int i = 0; i < 40; i++) {
			System.out.println();
		}
	}
	
	private void insert() {
		clr();
		String codeName = null;
		String name = null;
		String gender = null;
		String position = null;
		double salary = 0;
		
		do {
			System.out.print("Input Employees Name [min : 3]> ");
			name = s.nextLine();
		} while (name.length() < 3);
		
		do {
			System.out.print("Input " + name + "'s Gender [Male | Female] > ");
			gender = s.nextLine();
		} while(!gender.equals("Male") && !gender.equals("Female"));
		
		do {
			System.out.print("Input " + name + "'s Position [Manager | Supervisor | Programmer] > ");
			position = s.nextLine();
		} while (!position.equals("Manager") && !position.equals("Supervisor") && !position.equals("Programmer"));
		
		codeName = func.codeNameMaker();
		System.out.println("Employees Code Name is " + codeName);
		
		salary = func.salaryMaker(position);
		System.out.printf("%s's Salary -> %.0f\n", name, salary);
		
		employee.add(new Employees(codeName, name, gender, position, salary));
	}
	
	private void show() {
		clr();
		employee.add(new Employees("IP-1231", "Ipana", "Female", "asdijas", 12312));
		employee.add(new Employees("MC-123", "Aolin", "Male", "asdijas", 12312));  
		
		Collections.sort(employee, Comparator.comparing(Employees::getName));
		
		System.out.println("+---+-----------+----------------+-----------+------------+------------------+");
		System.out.printf("|%-3s| %-10s| %-15s| %-10s| %-11s| %-17s|%n", "No", "Code Name", "Name", "Gender", "Position", "Salary");
		System.out.println("+---+-----------+----------------+-----------+------------+------------------+");
		int number = 1;
		for (Employees e : employee) {
			System.out.printf("|%-3d| %-10s| %-15s| %-10s| %-11s| Rp%,-15.0f|%n",
					number++, e.getCodeName(), e.getName(),
					e.getGender(), e.getPosition(), e.getSalary());
		}
		System.out.println("+---+-----------+----------------+-----------+------------+------------------+");
	}
	
	private void view() {
		show();
		
		System.out.println("Enter anything to continue...");
		s.nextLine();
		menu();
	}
	
	private void update() {
		show();
		
		int choice = 0;
		
		do {
			System.out.print("Input number to update > ");
			choice = s.nextInt(); s.nextLine();
		} while (choice < 1 || choice > employee.size());
		
		
	}
	
	private void menu() {
		int choice = 1;
		do {
			clr();
			System.out.println("Input [1-5]");
			System.out.println("1. Insert Employees");
			System.out.println("2. View Employees");
			System.out.println("3. Update Employees");
			System.out.println("4. Delete Employees");
			System.out.println("5. Exit Program");
			System.out.print("Please input your choices > ");
			choice = s.nextInt(); s.nextLine();
		} while (choice < 1 || choice > 5);
		
		switch(choice) {
		case 1:
			insert();
			break;
		case 2:
			System.out.println("View");
			break;
		case 3:
			System.out.println("Update");
			break;
		case 4:
			System.out.println("Delete");
			break;
		case 5:
			break;
		}
	}
	
	public Main() {
//		menu();
		view();
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}

}
