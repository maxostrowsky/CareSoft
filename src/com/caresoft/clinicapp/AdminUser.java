package com.caresoft.clinicapp;

import java.util.*;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {

	private Integer employeeID;
	private String role;
	private ArrayList<String> securityIncidents = new ArrayList<String>();
	
	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		
	}

	
//... imports class definition...
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    private Integer getEmployeeID() {
		return employeeID;
	}


	private void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}


	private String getRole() {
		return role;
	}


	private void setRole(String role) {
		this.role = role;
	}


	private ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}


	private void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}


	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        	);
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
            );
        securityIncidents.add(report);
    }

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}

	@Override
	public boolean assignPin(int pin) {
		if(String.valueOf(pin).length() >= 6) {
			setPin(pin);
			return true;
		} else {
			System.out.println("Invalid Pin.");
			return false;
		}
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID == this.id) {
			return true;
		} else {
			authIncident();
			return false;
	}
		
	}
}
