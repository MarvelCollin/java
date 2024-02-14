package main;

import java.util.Random;

public class Functions {
	private Random random = new Random();
	
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
}	
