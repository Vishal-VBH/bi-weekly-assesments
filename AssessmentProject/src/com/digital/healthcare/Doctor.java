package com.digital.healthcare;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends User {

	static final String DOCTOR_ID_PREFIX = "DOC";
	private String specialization;
    private int experience;
	
	private List<Appointment> AppointmentsList;
	private List<Prescription> prescriptionsList;

	public Doctor(String id, String name, String email, roleType userRole, String specialization, int experience) {
		super(DOCTOR_ID_PREFIX + id, name, email, userRole);
		this.AppointmentsList = new ArrayList<>();
		this.prescriptionsList = new ArrayList<>();
		this.specialization = specialization;
        this.experience = experience;
	}

	 
	@Override
	public String toString() {
	    return "Doctor [id = " + id +
	           ", Doctor Name = " + name +
	           ", specialization = " + specialization +
	           ", experience = " + experience +
	           ", AppointmentsList = " + AppointmentsList +
	           ", prescriptionsList = " + prescriptionsList +
	           "]";
	}



	@Override
    public void displayDashboard() {
        System.out.println("=== Doctor Dashboard ===");
        System.out.println("Name: " + getName());
        System.out.println("Specialization: " + specialization);
        System.out.println("Experience: " + experience + " years");
    }

	public Prescription addPrescription(Prescription prescription) {
		prescriptionsList.add(prescription);
		return prescription;

	}

	public List<Appointment> viewAllAppointments() {
		
		for (Appointment appointment : AppointmentsList) {
			System.out.println("===All the Appointments===");
			System.out.println(appointment);
		}
		return AppointmentsList;

	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public List<Appointment> getAppointmentsList() {
		return AppointmentsList;
	}


	public void setAppointmentsList(List<Appointment> appointmentsList) {
		AppointmentsList = appointmentsList;
	}


	public List<Prescription> getPrescriptionsList() {
		return prescriptionsList;
	}


	public void setPrescriptionsList(List<Prescription> prescriptionsList) {
		this.prescriptionsList = prescriptionsList;
	}


	public static String getDoctorIdPrefix() {
		return DOCTOR_ID_PREFIX;
	}

}
