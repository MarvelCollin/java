package main;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

import models.Employees;

public class Main {
	Functions func = new Functions();
	private Vector<Employees> employee = new Vector<Employees>();

	int currentManager = 0, currentSupervisor = 0, currentProgrammer = 0;
	
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
		
		int currentPositionSize = countPosition(position);
		System.out.println("Current " + position + " is " + currentPositionSize + 1);
		
		if((currentPositionSize + 1) % 3 == 1 && currentPositionSize != 1) {
			getBonus(position);
			
			double percentSalary = func.extraSalary(position);
			
			System.out.println("Bonus with total " + percentSalary * 100 + "% given to " );
			for(Employees e : employee) {
				if(e.getPosition().equals(position)) {
					System.out.print(e.getCodeName() + ", ");
				}
			}
		}
		
		
		System.out.println();
		employee.add(new Employees(codeName, name, gender, position, salary));
		
		func.enter();
		show();
		func.enter();
		menu();
	}
	
	private int countPosition(String position) {
		int counter = 0;
		for(Employees e : employee) {
			if(e.getPosition().equals(position)) {
				counter++;
			}
		}
		return counter;
	}
	
	private void getBonus(String position) {
		for(Employees e : employee) {
			if(e.getPosition().equals(position)) {
				e.setSalary(e.getSalary() * func.extraSalary(position) + e.getSalary());
			}
		}
	}
	
	private void show() {
		func.clr();
//		Collections.sort(employee, Comparator.comparing(Employees::getName));
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
		if(func.isNot0(name)) {
			employee.get(choice - 1).setName(name);
		} else {
			name = employee.get(choice - 1).getName();
		}

		String gender = func.inputGender(name);
		if(func.isNot0(gender)) employee.get(choice - 1).setGender(gender);
	
		
		String position = func.inputPosition(name);
		if(func.isNot0(position)) {
			String inputChoice = null;
			do {
				System.out.println("Are you sure want to change the position to " + position + " ?");
				System.out.print("It will change the entire salary and reset[Y/N] > ");
				inputChoice = func.s.nextLine();
				if(inputChoice.equals("Y")) {
					employee.get(choice - 1).setPosition(position);
					double salary = func.salaryMaker(position);
					employee.get(choice - 1).setSalary(salary);
					System.out.println();
					System.out.println("Changed salary to Rp." + salary);
				}
			} while (!inputChoice.equals("Y") && !inputChoice.equals("N"));
		}
		
		func.enter();
		show();
		func.enter();
		menu();
	}
	
	private void delete() {
		show();
		
		System.out.println();
		
		int choice = 0;
		do {
			System.out.print("Input number to Delete[1-" + employee.size() + "] > ");
			choice = func.s.nextInt(); func.s.nextLine();
		} while (choice < 1 || choice > employee.size());
		
		String inputChoice = null;
		do {
			System.out.print("Are you sure want to Delete " + 
					employee.get(choice - 1).getName() + " ?[Y/N] > ");
			inputChoice = func.s.nextLine();
		} while (!inputChoice.equals("Y") && !inputChoice.equals("N"));
		
		if(inputChoice.equals("Y")) {
			System.out.println("Deleted " + employee.get(choice - 1).getCodeName());
			employee.remove(choice - 1);
		}
		
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
			delete();
			break;
		case 5:
			break;
		}
		
	}
	
	public Main() {
		employee.add(new Employees("SA-1231", "ASlda", "Male", "Supervisor", 6000000));
		employee.add(new Employees("SA-1231", "ASlda", "Male", "Supervisor", 6000000));
		employee.add(new Employees("SA-1231", "ASlda", "Male", "Supervisor", 6000000));
		menu();
//		System.out.println("asdasd");
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}

}
