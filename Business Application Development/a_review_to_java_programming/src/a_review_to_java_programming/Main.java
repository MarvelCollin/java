package a_review_to_java_programming;

import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	
	public Main() {
		// Input 
//		System.out.print("Input Nama : ");
//		String name = scan.nextLine();
		
		// Output
//		System.out.println("Halo nama saya : " + name);
		
		// Arithmetic Operator 
//		System.out.println(2 + 2);
//		System.out.println(2 - 2);
//		System.out.println(2 * 2);
//		System.out.println(2 / 2);
//		System.out.println(10 % 2);
		
		// Datatype Primitive
		int age = 10;
		double price = 12.2;
		boolean isAvailable = true;
		
		System.out.println(age);
		System.out.println(price);
		System.out.println(isAvailable);
		
		// Wrapper Class
		Integer wrapperAge = 10;
		
		System.out.println(wrapperAge);
		
		// Salah satu kegunaan wrapper class adalah bisa menggunakan method
		String ageToString = wrapperAge.toString();
		System.out.println(ageToString);
	}

	public static void main(String[] args) {
		new Main();
	}

}