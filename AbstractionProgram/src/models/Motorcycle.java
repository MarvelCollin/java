package models;

public class Motorcycle extends Vehicles {
	private int helmet;
	private int helmetPrice;
	
	public Motorcycle(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel,
			String type, int helmet, int helmetPrice) {
		super(brand, name, licenseNumber, topSpeed, gasCap, wheel, type);
		this.helmet = helmet;
		this.helmetPrice = helmetPrice;
	}

	public int getHelmet() {
		return helmet;
	}

	public int getHelmetPrice() {
		return helmetPrice;
	}

	public void setHelmetPrice(int helmetPrice) {
		this.helmetPrice = helmetPrice;
	}

	public void setHelmet(int helmet) {
		this.helmet = helmet;
	}
	
//	@Override
//	public boolean inputType(String type) {
//		if(!type.equals("Automatic") && !type.equals("Manual")) {
//			return false;
//		}
//		
//		return true;
//	}
	
	@Override
	public void turnOn(String value) {
		System.out.println(value + "is standing!");

	}
	
	

}
