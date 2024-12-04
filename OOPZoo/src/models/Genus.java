package models;

import java.util.ArrayList;
import java.util.Random;

public abstract class Genus {
	private String name;
	private String gender;
	
	public Genus(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	
	public abstract String getMood(ArrayList<Genus> genus, Integer maxValue);
	
	public Integer getSizeOfCanine(ArrayList<Genus> genus) {
		Integer canineCounter = 0;
		
		for (Genus g : genus) {
			if(g instanceof Canine) {
				canineCounter++;
			}
		}
		
		return canineCounter;
	}
	
	public Integer getSizeOfFeline(ArrayList<Genus> genus) {
		Integer felineCounter = 0;
		
		for (Genus g : genus) {
			if(g instanceof Feline) {
				felineCounter++;
			}
		}
		
		return felineCounter;
	}
	
	public abstract void print(ArrayList<Genus> genus, Integer maxValue);
	
	public void walk(Genus curentGenus) {
		Random rand = new Random();
		
		int randomNumber = rand.nextInt(0, 2); // 0 sampai 1
		
		if(randomNumber == 0) {
			System.out.println("GAMAU JALAN ANJAY");
		} else {
			if(curentGenus instanceof Feline) {
				System.out.println("ini feline sih");
				return;
			}
			
			int duration = rand.nextInt(0, 61);
			Integer speed = ((Canine) curentGenus).getSpeed();
			int total_range = duration * speed;
			System.out.println("walk for " + duration + " speed : " + speed + " total range : " + total_range);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
