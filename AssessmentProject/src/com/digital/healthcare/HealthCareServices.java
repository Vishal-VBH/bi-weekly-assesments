package com.digital.healthcare;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HealthCareServices {

	private Map<String, Patient> patients;
	private Map<String, Doctor> doctors;
	private List<Appointment> appointments;
	private Map<String, List<Prescription>> prescriptions;
	
	
	public boolean patientExists(String patientId) {
	    return patients.containsKey(patientId);
	}


	public HealthCareServices() {
		this.patients = new HashMap<>();
		this.doctors = new HashMap<>();
		this.appointments = new ArrayList<>();
		this.prescriptions = new HashMap<>();
	}

	public Patient registerPatient(Patient patient) {
		patients.put(patient.getId(), patient);
		return patient;

	}
	
	public void viewPatientProfile(String patientId) {
	    Patient patient = patients.get(patientId);
	    if (patient == null) {
	        System.out.println("Patient not found!");
	        return;
	    }
	    System.out.println("\n----- PATIENT PROFILE -----");
	    System.out.println("Patient ID   : " + patient.getId());
	    System.out.println("Patient Name : " + patient.getName());
	    System.out.println("Patient Email: " + patient.getEmail());
	}


	public Doctor addDoctor(Doctor doctor) {
		doctors.put(doctor.getId(), doctor);
		System.out.println("Doctors registered Successfully..");

		return doctor;
	}

	public Appointment bookAppointment(String appointmentId, String patientId, String doctorId, LocalDate date) {
		System.out.println("Looking for patient id: " + patientId);

		if (!patients.containsKey(patientId)) {
			System.err.println(patientId);
			System.out.println("Patient not found!");
			return null;
		}

		if (!doctors.containsKey(doctorId)) {
			System.out.println("Doctor not found!");
			return null;
		}

		for (Appointment ap : appointments) {
			if (ap.getDoctor().getId().equals(doctorId) && ap.getLocalDate().equals(date)) {

				System.out.println("Doctor already booked at this Date!");
				return null;
			}
		}

		Patient patient = patients.get(patientId);
		Doctor doctor = doctors.get(doctorId);

		Appointment appointment = new Appointment(appointmentId, patient, doctor, date);

		appointments.add(appointment);

		System.out.println("Appointment booked successfully!");
		return appointment;
	}

	public void viewAppointmentsByPatient(String patientId) {
		boolean found = false;
		for (Appointment ap : appointments) {
			if (ap.getPatient().getId().equals(patientId)) {
				System.out.println(ap);
				System.out.println("Doctor ID " + ap.getDoctor().getId());
				System.out.println("Doctor Name " + ap.getDoctor().getName());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No appointments found for this patient.");
		}
	}

	public void addPrescription(String prescriptionId, String patientId, String doctorId, List<String> medicines,
			LocalDate date) {

		if (!patients.containsKey(patientId)) {
			System.out.println("Patient not found!");
			return;
		}

		Prescription prescription = new Prescription(prescriptionId, patientId, doctorId, medicines, date);

		prescriptions.computeIfAbsent(patientId, k -> new ArrayList<>()).add(prescription);

		System.out.println("Prescription added successfully!");
	}

	public void viewPrescriptionsByPatient(String patientId) {

		List<Prescription> patientPrescriptions = prescriptions.get(patientId);

		if (patientPrescriptions == null || patientPrescriptions.isEmpty()) {
			System.out.println("No prescriptions found.");
			return;
		}

		for (Prescription p : patientPrescriptions) {
			System.out.println(p);
			System.out.println("-----------------------");
		}
	}

	public void removeDoctor(String doctorId) {
		doctors.remove(doctorId);
		System.out.println("Doctor removed successfully....");
	}

	public void viewAllDoctors() {
		//will view based on experience
	    doctors.values()
	           .stream()
	           .sorted((d1, d2) -> Integer.compare(d2.getExperience(), d1.getExperience()))
	           .forEach(System.out::println);
	}



	public void viewAppointmentsByDoctor(String doctorId) {

	    boolean found = false;

	    for (Appointment ap : appointments) {

	        if (ap.getDoctor().getId().equals(doctorId)) {

	            System.out.println(ap);
	            System.out.println("Patient ID: " + ap.getPatient().getId());
	            System.out.println("Patient Name: " + ap.getPatient().getName());
	            System.out.println("--------------------------");

	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("No appointments found.");
	    }
	}

	public boolean doctorExists(String doctorId) {
	    return doctors.containsKey(doctorId);
	}


}
