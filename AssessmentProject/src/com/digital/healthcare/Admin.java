package com.digital.healthcare;

import java.util.List;

public class Admin extends User {

	static final String ADMIN_ID_PREFIX = "ADMIN";

	List<Doctor> listOfDoctors;

	public Admin(String id, String name, String email, roleType userRole) {
		super(ADMIN_ID_PREFIX + id, name, email, userRole);

	}

	 @Override
	    public void displayDashboard() {
	        System.out.println("=== Admin Dashboard ===");
	        System.out.println("Name: " + getName());
	        System.out.println("Id: "+ getId());
	        System.out.println("email: "+ getEmail());
	        System.out.println("User Role: "+ getUserRole());
	    }

	public Doctor addDoctor(Doctor doctor) {
		try {
			if(listOfDoctors.isEmpty()) {
				throw new DoctorNotAvailableException("Doctor Not Available....");
			}
		}catch(DoctorNotAvailableException e) {
			e.getMessage();
		}
		listOfDoctors.add(doctor);
		return doctor;
	}

	public Doctor removeDoctor(Doctor doctor) {
		listOfDoctors.remove(doctor);

		return doctor;
	}

}
