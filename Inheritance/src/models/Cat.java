package models;

public class Cat extends Animal{

	public Cat(String name) {
		super(name);
	}

	@Override
	public void sound() {
		System.out.println("Nyaaa nyaaa");
	}
	
	
}
