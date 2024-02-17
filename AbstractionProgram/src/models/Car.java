package models;

public class Car extends Vehicles {
	private int entSystem;

	public Car(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel,
			String type, int entSystem) {
		super(brand, name, licenseNumber, topSpeed, gasCap, wheel, type);
		this.entSystem = entSystem;
	}

	public int getEntSystem() {
		return entSystem;
	}

	public void setEntSystem(int entSystem) {
		this.entSystem = entSystem;
	}
	
//	@Override
//	public boolean inputType(String type) {
//		if(!type.equals("SUV") && !type.equals("Supercar") && !type.equals("Minivan")) {
//			return false;
//		}
//		
//		return true;
//	}
//	
	@Override
	public void turnOn(String value) {
		System.out.println("Turning on entertainment system...");

		if(value.equals("Supercar")) {
			System.out.println("Boosting!");
		}
	}	
	
	
	
}
