package com.digital.healthcare;

import java.util.ArrayList;
import java.util.List;

public class Patient extends User {

	static final String PATIENT_ID_PREFIX = "PAT";

	private List<MedicalRecord> medicalRecordList;
	private List<Prescription> prescriptionsList;
	
	
	//checking teh prefix
	private static String applyPrefix(String id) {
	    if (id == null || id.isBlank()) {
	        return PATIENT_ID_PREFIX;  
	    }

	    if (id.startsWith(PATIENT_ID_PREFIX)) {
	        return id;
	    }

	    return PATIENT_ID_PREFIX + id;
	}
	public Patient(String id, String name, String email, roleType userRole) {
	    super(applyPrefix(id), name, email, userRole);
	    this.medicalRecordList = new ArrayList<>();
	    this.prescriptionsList = new ArrayList<>();
	}


	 @Override
	public String toString() {
		return "Patient [medicalRecordList=" + medicalRecordList + ", prescriptionsList=" + prescriptionsList + "]";
	}

	 @Override
	    public void displayDashboard() {
	        System.out.println("=== Patient Dashboard ===");
	        System.out.println("Name: " + getName());
	        System.out.println("Medical History: " + medicalRecordList.size() + " records");
	        System.out.println("Prescriptions: " + prescriptionsList.size() + " prescriptions");
	    }

	 public void viewPrescriptions() {
		
		
	 }
}
