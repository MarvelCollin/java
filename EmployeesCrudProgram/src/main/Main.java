package main;


import java.util.Scanner;

import models.Employees;

public class Main {
	private Scanner s = new Scanner(System.in);
	
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
		menu();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}

}
