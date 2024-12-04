package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
	private StringProperty fullName, email, phoneNumber;
	
	public User(String fullName, String email, String phoneNumber) {
		this.fullName = new SimpleStringProperty(fullName);
		this.email = new SimpleStringProperty(email);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		
		this.email.setValue(phoneNumber);
	}

	public User(StringProperty fullName, StringProperty email, StringProperty phoneNumber) {
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public StringProperty getFullName() {
		return fullName;
	}

	public void setFullName(StringProperty fullName) {
		this.fullName = fullName;
	}

	public StringProperty getEmail() {
		return email;
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	public StringProperty getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(StringProperty phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
