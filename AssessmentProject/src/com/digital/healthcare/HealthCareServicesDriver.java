package com.digital.healthcare;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.digital.healthcare.User.roleType;

public class HealthCareServicesDriver {

	private static final String ADMIN_EMAIL = "admin@gmail.com";
	private static final String ADMIN_PASSWORDS = "1234";
	private static final Admin admin = new Admin("540", "Sam", ADMIN_EMAIL, roleType.ADMIN);
	private static final String PATIENT_PREFIX = "PAT";
	private static final String DOCTOR_PREFIX = "DOC";

	private static boolean validatePassword(String email, String password) {
		return (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORDS));
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HealthCareServices services = new HealthCareServices();

		while (true) {

			System.out.println("\nLogin as ADMIN or PATIENT or DOCTOR");
			System.out.println("Enter\n'A' for Admin\n'P' for Patient\n'D' for Doctor\n'E' to Exit:");

			String loginRoleInput = sc.nextLine();

			if (loginRoleInput.equalsIgnoreCase("E") || loginRoleInput.equalsIgnoreCase("Exit")) {
				System.out.println("Exiting System...");
				sc.close();
				return;
			}

			String loginRole = null;

			if (loginRoleInput.equalsIgnoreCase("ADMIN") || loginRoleInput.equalsIgnoreCase("A")) {
				loginRole = "ADMIN";
			} else if (loginRoleInput.equalsIgnoreCase("PATIENT") || loginRoleInput.equalsIgnoreCase("P")) {
				loginRole = "PATIENT";
			} else if (loginRoleInput.equalsIgnoreCase("DOCTOR") || loginRoleInput.equalsIgnoreCase("D")) {
				loginRole = "DOCTOR";
			} else {
				System.out.println("Invalid Role! Please enter A/ADMIN, P/PATIENT, D/DOCTOR or E?EXIT.");
				continue;
			}

			switch (loginRole) {

			case "ADMIN":

				System.out.println("Enter Admin Email: [Hint :- admin@gmail.com]");
				String email = sc.nextLine();

				System.out.println("Enter Admin Password: [Hint :- 1234] ");
				String password = sc.nextLine();

				if (!validatePassword(email, password)) {
					System.out.println("Invalid Admin Credentials");
					break;
				}

				boolean adminLoggedIn = true;

				while (adminLoggedIn) {

					System.out.println("\n1.Add Doctor");
					System.out.println("2.Remove Doctor");
					System.out.println("3.View All Doctors");
					System.out.println("4.Logout");

					int choice;

					try {
						choice = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("Invalid Input! Enter number only.");
						continue;
					}

					switch (choice) {

					case 1:
						try {
							System.out.println("Enter Doctor Id:");
							String doctorId = sc.nextLine();

							System.out.println("Enter Doctor Name:");
							String doctorName = sc.nextLine();

							System.out.println("Enter Doctor Email:");
							String doctorEmail = sc.nextLine();

							System.out.println("Enter Doctor Specialization:");
							String doctorSpecialization = sc.nextLine();

							System.out.println("Enter Doctor Experience:");
							int doctorExp = Integer.parseInt(sc.nextLine());

							Doctor doctor = new Doctor(doctorId, doctorName, doctorEmail, roleType.DOCTOR,
									doctorSpecialization, doctorExp);

							services.addDoctor(doctor);
						} catch (Exception e) {
							System.out.println("Invalid Doctor Data!");
						}
						break;

					case 2:
						System.out.println("Enter Doctor Id to Remove:");
						services.removeDoctor(sc.nextLine());
						break;

					case 3:
						services.viewAllDoctors();
						break;

					case 4:
						adminLoggedIn = false;
						break;

					default:
						System.out.println("Invalid Choice");
					}
				}
				break;

			case "PATIENT":

				System.out.println("Enter Patient Id:");
				String patientInput = sc.nextLine();

				if (patientInput == null || patientInput.trim().isEmpty()) {
					System.out.println("Invalid Patient Id");
					continue;
				}

				String fullPatientId = patientInput.startsWith("PAT") ? patientInput : PATIENT_PREFIX + patientInput;

				if (!services.patientExists(fullPatientId)) {

					System.out.println("New Patient Registration");

					System.out.println("Enter Patient Name:");
					String patientName = sc.nextLine();

					System.out.println("Enter Patient Email:");
					String patientEmail = sc.nextLine();

					Patient patient = new Patient(fullPatientId, patientName, patientEmail, roleType.PATIENT);

					services.registerPatient(patient);
					System.out.println("Patient Registered Successfully!");
				}

				boolean patientLoggedIn = true;

				while (patientLoggedIn) {

					System.out.println("\n1.Book Appointment");
					System.out.println("2.View My Appointments");
					System.out.println("3.View My Profile");
					System.out.println("4.View My Prescriptions");
					System.out.println("5.Logout");

					int patientChoice;

					try {
						patientChoice = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("Invalid Input!");
						continue;
					}

					switch (patientChoice) {

					case 1:
						try {
							System.out.println("Enter Appointment Id:");
							String appointmentId = sc.nextLine();

							System.out.println("Enter Doctor Id:");
							String docInput = sc.nextLine();

							String docId = docInput.startsWith("DOC") ? docInput : DOCTOR_PREFIX + docInput;

							System.out.println("Enter Appointment Date (YYYY-MM-DD):");
							LocalDate date = LocalDate.parse(sc.nextLine());

							services.bookAppointment(appointmentId, fullPatientId, docId, date);
						} catch (Exception e) {
							System.out.println("Invalid Appointment Data!");
						}
						break;

					case 2:
						services.viewAppointmentsByPatient(fullPatientId);
						break;

					case 3:
						services.viewPatientProfile(fullPatientId);
						break;

					case 4:
						services.viewPrescriptionsByPatient(fullPatientId);
						break;

					case 5:
						patientLoggedIn = false;
						break;

					default:
						System.out.println("Invalid Choice");
					}
				}
				break;

			case "DOCTOR":

				System.out.println("Enter Doctor Id:");
				String docInput = sc.nextLine();

				String fullDoctorId = docInput.startsWith("DOC") ? docInput : DOCTOR_PREFIX + docInput;

				if (!services.doctorExists(fullDoctorId)) {
					System.out.println("Doctor not found! Contact Admin.");
					break;
				}

				boolean doctorLoggedIn = true;

				while (doctorLoggedIn) {

					System.out.println("\n1.View My Appointments");
					System.out.println("2.Add Prescription");
					System.out.println("3.Logout");

					int doctorChoice;

					try {
						doctorChoice = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("Invalid Input!");
						continue;
					}

					switch (doctorChoice) {

					case 1:
						services.viewAppointmentsByDoctor(fullDoctorId);
						break;

					case 2:
						try {
							System.out.println("Enter Prescription Id:");
							String prescriptionId = sc.nextLine();

							System.out.println("Enter Patient Id:");
							String patInput = sc.nextLine();

							String patId = patInput.startsWith("PAT") ? patInput : PATIENT_PREFIX + patInput;

							System.out.println("Enter Medicines (comma separated):");
							List<String> medicines = List.of(sc.nextLine().split(","));

							LocalDate today = LocalDate.now();

							services.addPrescription(prescriptionId, patId, fullDoctorId, medicines, today);
						} catch (Exception e) {
							System.out.println("Invalid Prescription Data!");
						}
						break;

					case 3:
						doctorLoggedIn = false;
						break;

					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
			}
		}
	}
}
