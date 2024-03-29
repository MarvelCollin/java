package main;

import java.util.Random;
import java.util.Scanner;

public class Functions {
	private Random random = new Random();
	public Scanner s = new Scanner(System.in);
	
	protected String codeNameMaker() {
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
		
		return codeNameBuilder.toString();
	}
	
	protected double salaryMaker(String position) {
		switch(position) {
		case "Manager":
			return 8000000;
		case "Supervisor":
			return 6000000;
		case "Programmer":
			return 4000000;
		}
		
		return 0;
	}
	
	protected String inputName() {
		String name = null;
		do {
			System.out.print("Input Employees Name [min : 3]> ");
			name = s.nextLine();
		} while (name.length() < 3 && !name.equals("0"));
		
		
		return name;
	}
	
	protected String inputGender(String name) {
		String gender;
		do {
			System.out.print("Input " + name + "'s Gender [Male | Female] > ");
			gender = s.nextLine();
		} while(!gender.equals("Male") && !gender.equals("Female") && !gender.equals("0"));
		
		return gender;
	}
	
	protected String inputPosition(String name) {
		String position;
		do {
			System.out.print("Input " + name + "'s Position [Manager | Supervisor | Programmer] > ");
			position = s.nextLine();
		} while (!position.equals("Manager") && !position.equals("Supervisor") 
				&& !position.equals("Programmer") && !position.equals("0"));
		return position;
	}
	
	protected void clr() {
		for(int i = 0; i < 40; i++) {
			System.out.println();
		}
	}
	
	protected void enter() {
		System.out.println("Press Anything to Continue");
		s.nextLine();
		clr();
	}
	
	protected boolean isNot0(String value) {
		if(!value.equals("0")) {
			return true;
		}
		
		return false;
	}
	
	protected double extraSalary(String position) {
		if(position.equals("Manager")) {
			return 10/100;
		} else if(position.equals("Supervisor")) {
			return 7.5/100;
		} else {
			return 5/100;
		}
	}
	
}	
