package com.revature.orderys.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="USER_TABLE")
public class User implements Serializable {
	private static final long serialVersionUID = -5465335613036224628L;

	public User(long id, String email, String passwordHash, String firstName, String lastName, Role role) {
		super();
		this.id = id;
		this.email = email;
		this.passwordHash = passwordHash;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSeq")
	@SequenceGenerator(allocationSize=1, name="userSeq", sequenceName="USER_SEQ")
	@Column(name="USER_ID")
	private long id;
	
	@Column(name="EMAIL", nullable=false, unique=true)
	private String email;
	
	@Column(name="PASSWORD_HASH", nullable=false)
	private String passwordHash;
	
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="USER_ROLE", nullable=false)
	private Role role;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="EMPLOYEE_STATION",
						joinColumns=@JoinColumn(name="EMPLOYEE_ID"),
						inverseJoinColumns=@JoinColumn(name="STATION_ID"))
	private List<Station> employeeStations;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="customer")
	private List<Order> orders;
	
	@MapsId("ratingId")
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="orderItemId")
	private List<Rating> ratings;
	
	@OneToOne
	@JoinColumn(name="BUSINESS_ID")
	private Business businessManaged;
	
	public static enum Role {
		CUSTOMER,
		EMPLOYEE,
		MANAGER
	}
	
	public User() {
		super();
	}

	public User(long id, String email, String firstName, String lastName, Role role) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	public User(String email, String firstName, String lastName, Role role) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	

	public User(String email, String passwordHash, String firstName, String lastName, Role role) {
		super();
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
	
	public List<Station> getEmployeeStations() {
		return employeeStations;
	}
	
	public void setEmployeeStations(List<Station> employeeStations) {
		this.employeeStations = employeeStations;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public List<Rating> getRatings() {
		return ratings;
	}
	
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	public Business getBusinessManaged() {
		return businessManaged;
	}
	
	public void setBusinessManaged(Business businessManaged) {
		this.businessManaged = businessManaged;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", passwordHash=" + passwordHash + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", role=" + role + ", employeeStations=" + employeeStations + ", orders="
				+ orders + ", ratings=" + ratings + ", businessManaged=" + businessManaged + "]";
	}
}
