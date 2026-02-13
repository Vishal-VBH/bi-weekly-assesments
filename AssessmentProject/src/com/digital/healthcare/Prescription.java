package com.digital.healthcare;

import java.time.LocalDate;
import java.util.List;

public class Prescription {

	private String prescriptionId;
	private String patientId;
	private String doctorId;
	private List<String> medicines;
	private LocalDate prescriptionDate;

	public Prescription(String prescriptionId, String patientId, String doctorId, List<String> medicines,
			LocalDate prescriptionDate) {
		this.prescriptionId = prescriptionId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.medicines = medicines;
		this.prescriptionDate = prescriptionDate;
	}

	public String getPatientId() {
		return patientId;
	}

	@Override
	public String toString() {
		return "Prescription ID: " + prescriptionId + "\nDoctor ID: " + doctorId + "\nMedicines: " + medicines
				+ "\nDate: " + prescriptionDate;
	}

	public String getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public List<String> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<String> medicines) {
		this.medicines = medicines;
	}

	public LocalDate getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(LocalDate prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
}
