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
			} else if(i ==-+
					2) {
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
		} while (name.length() < 3);
		
		
		return name;
	}
}	
