package models;

public class Employees {

	String Code;
	String Name;
	String Gender;
	String jobTitle;
	double salary;
	
	public Employees(String code, String name, String gender, String jobTitle, double salary) {
		super();
		Code = code;
		Name = name;
		Gender = gender;
		this.jobTitle = jobTitle;
		this.salary = salary;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	

}
