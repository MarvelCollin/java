package main;

import models.Cat;
import models.Dog;

public class Main {

	public static void main(String[] args) {
		Dog d = new Dog("Stiphen");
		
		d.sound();
		
		Cat c = new Cat("Catherine");
		
		c.sound();
	}

}
