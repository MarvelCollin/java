package main;

import java.util.Scanner;
import java.util.Vector;

import models.Car;
import models.Motorcycle;

public class Main {
	Scanner s = new Scanner(System.in);
	Functions func = new Functions();
	Vector<Car> car = new Vector<Car>();
	Vector<Motorcycle> motor = new Vector<Motorcycle>();
	
	public void menu() {
		int choice = 0;
		
		do {
			func.clr();
			System.out.println("1. Input Vehicle");
			System.out.println("2. View Vehicle");
			System.out.print("Input your choice [1-2] > ");
			choice = s.nextInt(); s.nextLine();
		} while (choice != 1 && choice != 2);
		
		switch(choice) {
		case 1: 
			insert();
			break;
		case 2:
			view();
			break;
		}
	}	
	
	public void insert() {
		func.clr();
		
		String vehicleType = null;
		do {
			System.out.print("Input Type [Car | Motorcycle] > ");
			vehicleType = s.nextLine();
		} while (!vehicleType.equals("Car") && !vehicleType.equals("Motorcycle"));
		
		String brand = func.brand();
		String name = func.name();
		String license = func.license();
		int topSpeed = func.topSpeed();
		int gasCap = func.gasCap();
		int wheel = func.wheel(vehicleType);
		String type = func.type(vehicleType);
		int entOrHelm = func.entOrHelm(vehicleType);
		
		func.enter();
		
		if(vehicleType.equals("Car")) {
			car.add(new Car(brand, name, license, topSpeed, gasCap, wheel, type, entOrHelm));
		} else {
			motor.add(new Motorcycle(brand, name, license, topSpeed, gasCap, wheel, type, entOrHelm, 0));
		}
		
		menu();
	}
	
	public void view() {
	     System.out.println("|----+------------+---------------------------+");
		 System.out.println("| No | Type       | Name                      |");
	     System.out.println("|----+------------+---------------------------+");
	     int carCounter = 0, motorCounter = 0;
	     
	     int counter = 1;
	     for(Car c : car ) {
	    	 System.out.printf("| %-2d | %-10s | %-25s |\n", counter++, "Car" , c.getName());
	    	 carCounter++;
	     }
	     
	     for(Motorcycle m : motor) {
	    	 System.out.printf("| %-2d | %-10s | %-25s |\n", counter++, "Motorcycle" , m.getName());
	    	 motorCounter++;
	     }
	     System.out.println();
	     System.out.println("|----+------------+---------------------------+");
	     System.out.println();
	     
	     int choice = 0;
	     do {
	    	 System.out.print("Pick a vehicle number to test drive [Enter '0' to exit] > ");
	    	 choice = s.nextInt(); s.nextLine();
		} while (choice < -1 || choice > counter);
	     
	    if(choice != 0) {
	    	String vechicleType = null;
	    	if (choice <= carCounter) {
	    		vechicleType = "Car";
	    	} else {
	    		vechicleType = "Motorcycle";
	    		choice = choice - carCounter;
	    	}
	    	
	    	viewDetailed(vechicleType, choice - 1);
	    }
	    
	    func.enter();
	    menu();
	}
	
	public void viewDetailed(String type, int index) {
		func.clr();
		if(type.equals("Car")) {
			System.out.println("Brand > " + car.elementAt(index).getBrand());
			System.out.println("Name > " + car.elementAt(index).getName());
			System.out.println("License Plate > " + car.elementAt(index).getLicenseNumber());
			System.out.println("Type > " + car.elementAt(index).getType());
			System.out.println("Top Speed > " + car.elementAt(index).getTopSpeed());
			System.out.println("Wheel(s) > " + car.elementAt(index).getWheel());
			System.out.println("Entertainment System > " + car.elementAt(index).getEntSystem());
			car.elementAt(index).turnOn(car.elementAt(index).getType());
		} else {
			System.out.println("Brand > " + motor.elementAt(index).getBrand());
			System.out.println("Name > " + motor.elementAt(index).getName());
			System.out.println("License Plate > " + motor.elementAt(index).getLicenseNumber());
			System.out.println("Type > " + motor.elementAt(index).getType());
			System.out.println("Top Speed > " + motor.elementAt(index).getTopSpeed());
			System.out.println("Wheel(s) > " + motor.elementAt(index).getWheel());
			System.out.println("Total Helmet > " + motor.elementAt(index).getHelmet());
			System.out.println("Helmet Price > " + motor.elementAt(index).getHelmetPrice());
			motor.elementAt(index).turnOn(motor.elementAt(index).getName());
			
			int price;
			System.out.print("Input helmet price ['0' To Skip] > Rp");
			price = s.nextInt(); s.nextLine();
			
			if(price != 0) {
				motor.elementAt(index).setHelmetPrice(price);
			}
		}
	}
	
	public Main() {
		menu();
	}

	public static void main(String[] args) {
		Main main = new Main();
	}

}
