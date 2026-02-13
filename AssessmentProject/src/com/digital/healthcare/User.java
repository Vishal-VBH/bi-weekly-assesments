package com.digital.healthcare;

public abstract class User {

	protected String id;
	protected String name;
	protected String email;
	protected String userRole;
	
	public enum roleType{
		PATIENT,
		DOCTOR,
		ADMIN
	}
	
	
	public User(String id, String name, String email , roleType role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		if(role == roleType.ADMIN) {
			userRole = "ADMIN";
		}else if(role == roleType.DOCTOR) {
			userRole = "DOCTOR";
		}else if(role == roleType.PATIENT) {
			userRole = "PATIENT";
		}else {
			throw new InvalidUserException("User is not suitable for any role ...");
		}
	}

	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUserRole() {
		return userRole;
	}



	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}



	public abstract void displayDashboard();



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", userRole=" + userRole + "]";
	}
}
