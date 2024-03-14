package main;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.Employees;

public class Main {
	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	Vector<Employees> employee = new Vector<Employees>();
	Controller c = new Controller();
	
	
	private void clear() {
		for(int i=0; i<20; i++) {
			System.out.println();
		}
	}
	
	private void insert() {
		String Code = null;
		String Name = null;
		String Gender = null;
		String jobTitle = null;
		double salary = 0;
		
		Name = c.inputName();
		Gender = c.inputGender();
		jobTitle = c.inputJobTitle();
		
		String alphabet = "qwertyuiopasdfghjklzxcvbnm";
		
		StringBuilder codeNameBuilder = new StringBuilder();
		//supaya bisa append
		
		
		for(int i=0; i<7; i++) {
			if(i<2) {
				char randomCode = alphabet.charAt(random.nextInt(alphabet.length()));
				
				codeNameBuilder.append(randomCode);
			}else if(i==2) {
				codeNameBuilder.append("-");
			}else {
				codeNameBuilder.append(random.nextInt(9));
			}
		}
		
		Code = codeNameBuilder.toString().toUpperCase();
		
		System.out.println("Berhasil menambahkan karyawan dengan id " + Code);
		
		switch(jobTitle) {
		case "Manager":
			salary = 8000000;
			break;
		case "Supervisor":
			salary = 6000000;
			break;
		case "Admin":
			salary = 4000000;
			break;
		}
		
		int currentJobTitleSize = countJobTitle(jobTitle);
		
//		System.out.println("Current Job Title : " + (currentJobTitleSize + 1));
		
		if((currentJobTitleSize + 1) % 3 == 1 && (currentJobTitleSize + 1)> 3) {
			getBonus(jobTitle);
			
			double percentSalary = c.extraSalary(jobTitle);
			
			System.out.println("Bonus sebesar " + percentSalary*100 + "% telah diberikan kepada karyawan dengan id");
			for(Employees emp : employee) {
				if(emp.getJobTitle().equals(jobTitle)) {
					System.out.print(emp.getCode()+", ");
				}
			}
		}
		
		System.out.println("Press 'Enter' to continue");
		scan.nextLine();
		employee.add(new Employees(Code, Name, Gender, jobTitle, salary));
		menu();
		
	}
	
	private int countJobTitle(String jobTitle) {
		int count = 0;
		for (Employees emp : employee) {
			if(emp.getJobTitle().equals(jobTitle)) {
				count++;
			}
		}
		return count;
	}
	
	private void getBonus(String jobTitle) {
		for(Employees emp : employee) {
			if(emp.getJobTitle().equals(jobTitle)) {
				emp.setSalary(emp.getSalary() * c.extraSalary(jobTitle) + emp.getSalary());
			}
		}
	}
	
	
	
	private void show() {
		clear();
		
		Collections.sort(employee, Comparator.comparing(Employees::getName));
		
		System.out.println("+---+--------------+-----------------+--------------+-----------+--------------+");
		System.out.printf("|%-3s| %-11s| %-16s| %-11s| %-10s| %-13s|%n", "No","Kode Karyawan","Nama Karyawan","Jenis Kelamin","Jabatan","Gaji Karyawan");
		System.out.println("+---+--------------+-----------------+--------------+-----------+--------------+");

		int number = 1;
		for(Employees emp : employee){
			System.out.printf("|%-3s| %-13s| %-16s| %-13s| %-10s| Rp%,-11.0f|%n", number++, emp.getCode(), emp.getName(), emp.getGender(), emp.getJobTitle(), emp.getSalary());
		}
		System.out.println("+---+--------------+-----------------+--------------+-----------+--------------+");

	}
	
	
	private void view() {
		show();
		
		System.out.println("Press 'Enter' to continue");
		scan.nextLine();
		menu();
		
	}
	
	private void update() {
		show();
		int choice = 0;
		
		do {
			System.out.print("Input nomor urutan karyawan yang ingin diupdate[1-" + employee.size() + "] > ");
			choice = scan.nextInt();scan.nextLine();
		} while (choice < 1 || choice > employee.size());
		
		
//		employee.get(choice - 1).setCode("JK-456");
		
		String Name = c.inputName();
		if(!Name.equals("0")) {
			employee.get(choice - 1).setName(Name);
		}
		
		String Gender = c.inputGender();
		if(!Gender.equals("0")) {
			employee.get(choice - 1).setGender(Gender);
		}
		
		String jobTitle = c.inputJobTitle();
		if(!jobTitle.equals("0")) {
			employee.get(choice - 1).setJobTitle(jobTitle);
		}
		
		System.out.println("Berhasil mengupdate karyawan dengan id " + employee.get(choice - 1).getCode());

		System.out.println("Press 'Enter' to Continue");
		scan.nextLine();
		
		menu();
	}
	
	private void delete() {
		show();
		
		System.out.println();
		
		int choice = 0;
		
		do {
            System.out.print("Input nomor urutan karyawan yang ingin dihapus[1-" + employee.size() + "]: ");
            choice = c.scan.nextInt(); c.scan.nextLine();
        } while (choice < 1 || choice > employee.size());
		
		System.out.println("Deleted " + employee.get(choice - 1).getCode());
        employee.remove(choice - 1);
        
        System.out.println("Karyawan dengan kode" + employee.get(choice - 1).getCode() + "berhasil dihapus");
        System.out.println("Press 'Enter' to Continue");
		scan.nextLine();
		
		menu();
	}
	
	private void menu() {
		int choice = 0;
		
		do {
			clear();
			System.out.println("Input [1-4]");
			System.out.println("1. Insert Employees");
			System.out.println("2. View Employees");
			System.out.println("3. Update Employees");
			System.out.println("4. Delete Employees");
			System.out.println("5. Exit");
			System.out.print("Please enter your choice : ");
			choice =scan.nextInt(); scan.nextLine();
			
		} while (choice < 1 || choice > 5);
		
		
		switch(choice) {
		case 1:
			insert();
			break;
		case 2:
			view();
			break;
		case 3:
			update();
			break;
		case 4:
			delete();
			break;
		case 5:
			break;
		}
	}
	
public Main() {
	employee.add(new Employees("IP-123", "Ipana", "Perempuan", "Manager", 8000000));
	employee.add(new Employees("ML-231", "Marvel", "Laki-Laki", "Admin", 4000000));
	employee.add(new Employees("ML-231", "Marvel", "Laki-Laki", "Admin", 4000000));
	employee.add(new Employees("ML-231", "Marvel", "Laki-Laki", "Admin", 4000000));
		menu();
//	System.out.println(c.extraSalary("Manager"));
	}

	public static void main(String[] args) {
		Main main = new Main();	
	}

}
