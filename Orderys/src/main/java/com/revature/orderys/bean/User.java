package com.revature.orderys.bean;

public class User {
	private long id;
	private String email;
	private String passwordHash;
	private String firstName;
	private String lastName;
	private short role;
	
	public User() {
		super();
	}

	public User(long id, String email, String passwordHash, String firstName, String lastName, short role) {
		super();
		this.id = id;
		this.email = email;
		this.passwordHash = passwordHash;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public short getRole() {
		return role;
	}

	public void setRole(short role) {
		this.role = role;
	}	
}
