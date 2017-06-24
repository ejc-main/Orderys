package com.revature.orderys.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSeq")
	@SequenceGenerator(allocationSize=1, name="userSeq", sequenceName="USER_SEQ")
	@Column(name="USER_ID")
	private long id;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD_HASH")
	private String passwordHash;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="ROLE")
	private Role role;
	
	enum Role {
		CUSTOMER,
		EMPLOYEE,
		MANAGER
	}
	
	public User() {
		super();
	}

	public User(long id, String email, String passwordHash, String firstName, String lastName, Role role) {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}	
}
