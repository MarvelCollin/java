package models;

import java.util.ArrayList;
import java.util.Random;

public class Feline extends Genus{

	public Feline(String name, String gender) {
		super(name, gender);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMood(ArrayList<Genus> genus, Integer maxValue) {
		Integer felineCounter = getSizeOfFeline(genus);
		
		if(felineCounter == 1) {
			return "unhappy";
		} else if(felineCounter < maxValue) {
			return "unhappy";
		} else {
			return "happy";
		}
	}

	public void print(ArrayList<Genus> genus, Integer maxValue) {
		System.out.println(getName() + " Feline " + getMood(genus, maxValue) + " " + getGender());
	}
	

}
