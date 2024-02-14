package main;


import java.util.Random;
import java.util.Scanner;

import models.Employees;

public class Main {
	private Scanner s = new Scanner(System.in);
	private Random random = new Random();
	
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
		
		String alphabeth = "QWERTYUIOPASDFGHJKLZXCVBNM";
		
		StringBuilder codeNameBuilder = new StringBuilder();
		
		for(int i = 0; i < 7; i++) {
			//MM
			if(i < 2) {
				char randomCode = alphabeth.charAt(random.nextInt(alphabeth.length()));
				codeNameBuilder.append(randomCode);
			} else if(i == 2) {
				codeNameBuilder.append("-");
			} else {
				codeNameBuilder.append(random.nextInt(9));
			}
		}
		
		codeName = codeNameBuilder.toString();
		System.out.println("Employees Code Name is " + codeName);
		
		switch(position) {
		case "Manager":
			salary = 8000000;
			break;
		case "Supervisor":
			salary = 6000000;
			break;
		case "Programmer":
			salary = 4000000;
			break;
		}
		
		System.out.printf("%s's Salary -> %.0f\n", name, salary);

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
		insert();
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}

}
