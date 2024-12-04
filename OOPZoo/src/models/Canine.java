package models;

import java.util.ArrayList;

public class Canine extends Genus{
	private Integer speed;

	public Canine(String name, String gender, Integer speed) {
		super(name, gender);
		this.speed = speed;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	@Override
	public String getMood(ArrayList<Genus> genus, Integer maxValue) {
		Integer canineCounter = getSizeOfCanine(genus);
		
		if(canineCounter == 1) {
			return "happy";
		} else if(canineCounter < maxValue) {
			return "happy";
		} else {
			return "unhappy";
		}
	}

	public void print(ArrayList<Genus> genus, Integer maxValue) {
		System.out.println(getName() + " Canine " + getMood(genus, maxValue) + " " + getGender());
	}


	
	
}
