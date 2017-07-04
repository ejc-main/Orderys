package com.revature.orderys.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Maps the fields of a table in the Orderys database. This table represents
 * a business where users can place orders.
 * 
 * The business table has a number of required (non-nullable) fields:
 * <ul>
 * 	<li>name</li>
 * 	<li>manager</li>
 * 	<li>streetAddress1</li>
 * 	<li>city</li>
 * 	<li>state</li>
 * 	<li>country</li>
 * 	<li>zip</li>
 * </ul>
 * <br>
 * Of these, manager must be a unique object.
 * 
 * @author Null Terminators
 *
 */
@Component
@Entity
@Table(name="BUSINESS_TABLE")
public class Business implements Serializable {

	private static final long serialVersionUID = 1168516909188344278L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="businessSeq")
	@SequenceGenerator(allocationSize=1, name="businessSeq", sequenceName="BUSINESS_SEQ")
	@Column(name="BUSINESS_ID")
	private long id;
	
	@Column(name="BUSINESS_NAME", nullable=false)
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false, unique=true)
	@JsonIgnore
	private User manager;
	
	@Column(name="STREET_ADDRESS_1", nullable=false)
	private String streetAddress1;
	
	@Column(name="STREET_ADDRESS_2")
	private String streetAddress2;
	
	@Column(name="CITY", nullable=false)
	private String city;
	
	@Column(name="STATE", nullable=false)
	private String state;
	
	@Column(name="COUNTRY", nullable=false)
	private String country;
	
	@Column(name="ZIP", nullable=false)
	private String zip;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="business")
	@JsonIgnore
	private List<Station> stations;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="orderedAt")
	@JsonIgnore
	private List<OrderItem> orderItems;
	
	public Business() {
		super();
	}

	public Business(long id, String name, User manager, String streetAddress1, String streetAddress2, String city, String state,
			String country, String zip) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.streetAddress1 = streetAddress1;
		this.streetAddress2 = streetAddress2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public String getStreetAddress1() {
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public List<Station> getStations() {
		return stations;
	}
	
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	@Override
	public String toString() {
		return "Business [id=" + id + ", name=" + name + ", manager=" + manager + ", streetAddress1=" + streetAddress1
				+ ", streetAddress2=" + streetAddress2 + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", zip=" + zip + ", stations=" + stations + "]";
	}
}
