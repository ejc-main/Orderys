package com.revature.orderys.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STATION_TABLE")
public class Station implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="STATION_ID")
	private long id;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BUSINESS_ID")
	private Business businessId;
	
	@Column(name="STATION_NAME")
	private String stationName;
	
	@ManyToMany(mappedBy="employeeStations")
	private Set<User> employees;
	
	public Station() {
		super();
	}

	public Station(long id, Business businessId, String stationName) {
		super();
		this.id = id;
		this.businessId = businessId;
		this.stationName = stationName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Business getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Business businessId) {
		this.businessId = businessId;
	}	
	
	public String getStationName() {
		return stationName;
	}
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	public Set<User> getEmployees() {
		return employees;
	}
	
	public void setEmployees(Set<User> employees) {
		this.employees = employees;
	}
}
