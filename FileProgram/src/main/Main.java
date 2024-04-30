package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Data;


public class Main {
	List < Data > datas = new ArrayList <> ();
	String filePath = "data.txt";
	Data data;
	Scanner s = new Scanner(System.in);

	private void enter() {
		System.out.println("Please input anything to continue [dont forget to enter]");
		s.nextLine();
	}
	
	private void init() {
		 try {
	            List <String> lines = Files.readAllLines(Paths.get(filePath));

	            for (String line: lines) {
	            	addToArrayList(line);
	            }
	        } catch (IOException e) {
	            System.out.println("Failed");
	        }
	}
	
	private void addToArrayList(String text) {
		String[] parts = text.split("#", 2);

        data = new Data(parts[0], Integer.parseInt(parts[1]));
        datas.add(data);
	}
	
	private void writeFile(String text) {
		try {
			addToArrayList(text);

			FileWriter w = new FileWriter(filePath, true);
			BufferedWriter buff = new BufferedWriter(w);
			buff.write(text + "\n");
			buff.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void printData() {
		for (Data data: datas) {
            System.out.println("Name : " + data.getName() + " Balance : " + data.getBalance());
        }
	}
	
	private void update() {
		
	}

	private void addMenu() {
		String name, balance;
		System.out.print("Input name > ");
		name = s.nextLine();

		System.out.print("Input balance > ");
		balance = s.nextLine();
		
		String text = name + "#" + balance;
//		writeFile(text);
		enter();
		menu();
	}
	
	private void displayMenu() {
		
	}
	
	private void updateMenu() {
		
	}
	
	private void deleteMenu() {
		
	}
	
	private void menu() {
		int choice;
		System.out.println("1. Add");
		System.out.println("2. View");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		System.out.print("Input Choice > ");
		choice = s.nextInt(); s.nextLine();
		
		switch(choice) {
		case 1: 
			addMenu();
			break;
		case 2:
			displayMenu();
			break;
		case 3: 
			updateMenu();
			break;
		case 4: 
			deleteMenu();
			break;
		default: 
			menu();
			break;
		}
	}
	
    public Main() {
        // letakin file txt ke projectnya bukan di dalam src
    	init();
//    	writeFile("asdaasdasdasdass#12312341");
    	menu();
    }

    public static void main(String[] args) {
        new Main();
    }

}