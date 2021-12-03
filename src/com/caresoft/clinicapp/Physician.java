package com.caresoft.clinicapp;

import java.util.*;

public class Physician extends User implements HIPAACompliantUser {

	private ArrayList<String> patientNotes;
	
	public Physician(Integer id) {
		super(id);
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format(
				"Datetime Submitted: %s \n", date);
		report += String.format("Reported By ID: %s\n", this.id);
		report += String.format("Patient Name: %s\n", patientName);
		report += String.format("Notes: %s \n", notes);
		this.patientNotes.add(report);
	}

	
	public boolean assignPin(int pin) {
		if(String.valueOf(pin).length() >= 4) {
			setPin(pin);
			return true;
		} else {
			System.out.println("Invalid Pin.");
			return false;
		}
	}
	


	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID == this.id) {
			return true;
		} else {
			return false;
		}
	}
	protected Integer getId() {
			return id;
		}
	protected void setId(Integer id) {
			this.id = id;
	}
}
