package models;

public class Animal {
	String name;

	public Animal(String name) {
		super();
		this.name = name;
	}
	
	public void sound() {
		System.out.println("Animal's Sound");
	}
}
