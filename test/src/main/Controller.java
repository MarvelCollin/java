package main;

import java.util.Scanner;

public class Controller {
	Scanner scan = new Scanner(System.in);
	
	protected String inputName() {
		String Name;
		
		do {
			System.out.print("Input nama karyawan [>=3}: ");
			Name = scan.nextLine();
		} while (Name.length() < 3 && !Name.equals("0"));
		
		return Name;
	}

	protected String inputGender() {
		String Gender;
		
		do {
			System.out.print("Input jenis kelamin [Laki-Laki/Perempuan](Case Sensitive): ");
			Gender = scan.nextLine();
		} while (!Gender.equals("Laki-Laki") && !Gender.equals("Perempuan") && !Gender.equals("0"));
		
		return Gender;
	}
	
	protected String inputJobTitle() {
		String jobTitle;
		
		do {
			System.out.print("Input jabatan [Manager/Supervisor/Admin](Case Sensitive): ");
			jobTitle = scan.nextLine();
		} while (!jobTitle.equals("Manager") && !jobTitle.equals("Supervisor") && !jobTitle.equals("Admin") && !jobTitle.equals("0"));
		
		return jobTitle;
	}
	
	protected boolean isNot0(String value) {
		if(!value.equals("0")) {
			return true;
		}
		return false;
	}
	
	protected double extraSalary(String jobTitle) {
		if(jobTitle.equals("Manager")) {
			return 10.0/100;
		}else if(jobTitle.equals("Supervisor")) {
			return 7.5/100;
		}else {
			return 5.0/100;
		}
	}
	
}
