package com.digital.healthcare;

public class AppointmentNotFoundException extends RuntimeException{

	public AppointmentNotFoundException(String message) {
		super(message);
	}

}
