package com.caresoft.clinicapp;

public class User {
	protected Integer id;
	protected int pin;
	
	public User(Integer id) {
		this.id = id;
	}
	
	protected Integer getId() {
		return id;
	}
	protected void setId(Integer id) {
		this.id = id;
	}
	protected int getPin() {
		return pin;
	}
	protected void setPin(int pin) {
		this.pin = pin;
	}
	

	
	
}
    
