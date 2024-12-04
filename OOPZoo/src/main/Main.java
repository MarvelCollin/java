package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Canine;
import models.Feline;
import models.Genus;

public class Main {
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Genus> genus = new ArrayList<>();
	private Integer maxFeline = 0;
	private Integer maxCanine = 0;
	
	private void updateMaxValue() {
		Integer felineCounter = 0;
		Integer canineCounter = 0;
		
		for (Genus g : genus) {
			// apakah g merupakan kelas dari feline
			if(g instanceof Feline) {
				felineCounter++;
			} else if(g instanceof Canine) {
				canineCounter++;
			}
		}
		
		
		if(maxCanine < canineCounter) {
			maxCanine = canineCounter;
		}
		
		if(maxFeline < felineCounter) {
			maxFeline = felineCounter;
		}
		
//		System.out.println("hasil " + canineCounter + " " + felineCounter);
//		System.out.println("max   " + maxCanine + " " + maxFeline);
	}
		
	// facade
	
	public void addFeline(String name, String gender) {
		genus.add(new Feline(name, gender));
		updateMaxValue();
	}
	
	public void addCanine(String name, String gender, Integer speed) {
		genus.add(new Canine(name, gender, speed));
		updateMaxValue();
	}
	
	
	public void addZoo() {
		String name;
		
		do {
			System.out.print("input name : ");
			name = scan.nextLine();
		} while (!(name.length() >= 5 && name.length() <= 15));
		
		String gender;
		do {
			System.out.print("input gender : ");
			gender = scan.nextLine();
		} while (!(gender.equals("female") || gender.equals("male")));
		
		String type;
		do {
			System.out.print("input type : ");
			type = scan.nextLine();
		} while (!(type.equals("feline") || type.equals("canine")));
		
		if(type.equals("canine")) {
			Integer speed;
			
			do {	
				System.out.print("input speed : ");
				speed = scan.nextInt(); scan.nextLine();
			} while (!(speed >= 1 && speed <= 80));
			
			addCanine(name, gender, speed);
		} else {
			addFeline(name, gender);
		}
	}
	
	public void viewZoo() {
		Integer number = 1;
		for (Genus g : genus) {
			Integer maxValue = 0;
			
			if(g instanceof Feline) {
				maxValue = maxFeline;
			} else if(g instanceof Canine) {
				maxValue = maxCanine;
			}
			
			System.out.print(number++ + ". ");
			g.print(genus, maxValue);
		}
	}
	
	public void takeWalk() {
		viewZoo();
		System.out.println();
		
		int index;
		System.out.print(">> ");
		index = scan.nextInt(); scan.nextLine();
		
		Genus currentGenus = genus.get(index);
		
		currentGenus.walk(currentGenus);
	}
	
	public void releaseZoo() {
		int index;
		
		System.out.print(">> ");
		index = scan.nextInt(); scan.nextLine();
		
		genus.remove(index);
	}
	
	public void menu() {
		int choice;
		
		do {
			System.out.println("1. Add Zoo");
			System.out.println("2. View Zoo");
			System.out.println("3. Take for a walk");
			System.out.println("4. Release Zoo");
			System.out.println("5. Exit");
			System.out.print(">> ");
			
			choice = scan.nextInt(); scan.nextLine();
		} while (!(choice >= 1 && choice <= 5));
		
		// kalau misalkan diantara 1 dan 5
		
		switch(choice) {
			case 1:
				addZoo();
				break;
			case 2: 
				viewZoo();
				break;
			case 3:
				takeWalk();
				break;
			case 4:
				releaseZoo();
				break;
			case 5:
				System.out.println("goodbye");
				break;
		}
		
		if(choice != 5) menu();
	}
	
	public Main() {
		addFeline("ivana cabul", "female");
		addFeline("ivana cabullllll", "female");
		addFeline("ivana cabul123", "female");
		addCanine("ivana cabul l nya 1", "female", 20);
		addCanine("ivana cabul l nya 10", "female", 100);
//		System.out.println(maxCanine + " " + maxFeline);\
		
		menu();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
