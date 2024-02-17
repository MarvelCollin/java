package models;

public abstract class Vehicles {
	private String brand;
	private String name;
	private String licenseNumber;
	private int topSpeed;
	private int gasCap;
	private int wheel;
	private String type;
	
	public Vehicles(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel,
			String type) {
		super();
		this.brand = brand;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.topSpeed = topSpeed;
		this.gasCap = gasCap;
		this.wheel = wheel;
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	public int getGasCap() {
		return gasCap;
	}

	public void setGasCap(int gasCap) {
		this.gasCap = gasCap;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

//	public boolean inputType(String type) {
//		
//		return false;
//	}
//	
	public abstract void turnOn(String value);
		
}
