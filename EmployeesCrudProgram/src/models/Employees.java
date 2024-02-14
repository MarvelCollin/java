package models;

public class Employees {
	String codeName;
	String name;
	String gender;
	String position;
	double salary;
	
	public Employees(String codeName, String name, String gender, String position, double salary) {
		super();
		this.codeName = codeName;
		this.name = name;	
		this.gender = gender;
		this.position = position;
		this.salary = salary;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
