package main;


import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

import models.Employees;

public class Main {
//	private Scanner s = new Scanner(System.in);
	Functions func = new Functions();
	private Vector<Employees> employee = new Vector<Employees>();
	
	private void insert() {
		func.clr();
		String codeName = null;
		String name = null;
		String gender = null;
		String position = null;
		double salary = 0;
		
		name = func.inputName();
		gender = func.inputGender(name);
		position = func.inputPosition(name);

		codeName = func.codeNameMaker();
		System.out.println("Employees Code Name is " + codeName);
		
		salary = func.salaryMaker(position);
		System.out.printf("%s's Salary -> %.0f\n", name, salary);
		
		employee.add(new Employees(codeName, name, gender, position, salary));
	}
	
	private void show() {
		func.clr();
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
		func.enter();
		menu();
	}
	
	private void update() {
		show();
		
		int choice = 0;
		
		do {
			System.out.print("Input number to update[1-" + employee.size() + "] > ");
			choice = func.s.nextInt(); func.s.nextLine();
		} while (choice < 1 || choice > employee.size());
		
//		employee[1]; array -> get
//		string -> indexOf
		
		String name = func.inputName();
		if(func.isNot0(name)) employee.get(choice - 1).setName(name);

		String gender = func.inputGender(name);
		if(func.isNot0(gender)) employee.get(choice - 1).setGender(gender);
		
		String position = func.inputPosition(name);
		if(func.isNot0(position)) employee.get(choice - 1).setPosition(position);
		
		func.enter();
		
		menu();
		
	}
	
	private void menu() {
		int choice = 1;
		do {
			func.clr();
			System.out.println("Input [1-5]");
			System.out.println("1. Insert Employees");
			System.out.println("2. View Employees");
			System.out.println("3. Update Employees");
			System.out.println("4. Delete Employees");
			System.out.println("5. Exit Program");
			System.out.print("Please input your choice > ");
			choice = func.s.nextInt(); func.s.nextLine();
		} while (choice < 1 || choice > 5);
		
		switch(choice) {
		case 1:
			insert();
			break;
		case 2:
			view();
			break;
		case 3:
			update();
			break;
		case 4:
			System.out.println("Delete");
			break;
		case 5:
			break;
		}
	}
	
	public Main() {
		employee.add(new Employees("IP-1231", "Ipana", "Female", "asdijas", 12312));
		employee.add(new Employees("MC-123", "Aolin", "Male", "asdijas", 12312));  
		menu();
//		System.out.println("asdasd");
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}

}
