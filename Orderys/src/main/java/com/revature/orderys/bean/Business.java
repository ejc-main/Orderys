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
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User manager;
	
	@Column(name="STREET_ADDRESS_1")
	private String streetAddress1;
	
	@Column(name="STREET_ADDRESS_2")
	private String streetAddress2;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="ZIP")
	private String zip;
	
	// TODO: Check annotation
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="STATION_ID")
	private List<Station> stations;
	
	public Business() {
		super();
	}

	public Business(long id, User managerId, String streetAddress1, String streetAddress2, String city, String state,
			String country, String zip) {
		super();
		this.id = id;
		this.manager = managerId;
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
}
