package main;

import java.util.Scanner;

public class Functions {
	private Scanner s = new Scanner(System.in);
	
	public Functions() {
		
	}
	
	public String brand() {
		String brand = null;
		do {
			System.out.print("Input brand [>= 5] > ");
			brand = s.nextLine();
		} while (brand.length() < 5);
		
		
		return brand;
	}
	
	public String name() {
		String name = null;
		
		do {
			System.out.print("Input name [>= 5] > ");
			name = s.nextLine();
		} while (name.length() < 5);
		
		return name;
	}
	
	public static boolean validateLicense(String license) {
        if (license == null || license.isEmpty())
            return false;

        String[] parts = license.split(" ");

        if (parts.length != 3)
            return false;

        String firstPart = parts[0];
        if (firstPart.length() != 1 || !Character.isUpperCase(firstPart.charAt(0)))
            return false;

        String secondPart = parts[1];
        if (secondPart.length() < 1 || secondPart.length() > 4)
            return false;
        for (char c : secondPart.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }

        String thirdPart = parts[2];
        if (thirdPart.length() < 1 || thirdPart.length() > 3)
            return false;
        for (char c : thirdPart.toCharArray()) {
            if (!Character.isUpperCase(c))
                return false;
        }

        return true;
    }
	
	public String license() {
		String license = null;
		
		do {
			System.out.print("Input License > ");
			license = s.nextLine();
		} while (!validateLicense(license));
		
		return license;
	}
	
	public int topSpeed() {
		int topSpeed = 0;
		
		do {
			System.out.print("Input top speed [100 <= Top Speed >= 250] > ");
			topSpeed = s.nextInt();  s.nextLine();
		} while (topSpeed < 100 || topSpeed > 250);
		
		return topSpeed;
	}
	
	public int gasCap() {
		int gasCap = 0;
		
		do {
			System.out.print("Input gas capacity [30 <= gasCap >= 60] > ");
			gasCap = s.nextInt(); s.nextLine();
		} while (gasCap < 30 || gasCap > 60);
		
		return gasCap;
	}
	
	public int wheel(String type) {
		int minWheel, maxWheel, wheel;
		
		if(type.equals("Car")) {
			minWheel = 4;
			maxWheel = 6;
		} else {
			minWheel = 2;
			maxWheel = 3;
		}
		
		do {
			System.out.print("Input wheel [" + minWheel + " <= wheel >= " + maxWheel + "] > ");
			wheel = s.nextInt(); s.nextLine();
		} while (wheel < minWheel || wheel > maxWheel);
		
		return wheel;
 	}		
	
	public String type(String vehicleType) {
		String type = null;
		if(vehicleType.equals("Car")) {
			do {
				System.out.print("Input type [SUV | Supercar | Minivan] > ");
				type = s.nextLine();
			} while (!type.equals("SUV") && !type.equals("Supercar") && !type.equals("Minivan"));
		} else {
			do {
				System.out.print("Input type [Automatic | Manual] > ");
				type = s.nextLine();
			} while (!type.equals("Automatic") && !type.equals("Manual"));
		}
		
		return type;
	}
	
	public int entOrHelm(String type) {
		String str = type.equals("Car") ? "entertainment system" : "helmet";
		int amount = 0;

		do {
			System.out.print("Input " + str + " [>= 1] > ");
			amount = s.nextInt(); s.nextLine();			
		} while (amount < 1);
		
		return amount;
	}
	
	public void enter() {
		System.out.println("Enter to return");
		s.nextLine();
		clr();
	}
	
	public void clr() {
		for(int i = 0; i < 40; i++) {
			System.out.println();
		}
	}
	

}
