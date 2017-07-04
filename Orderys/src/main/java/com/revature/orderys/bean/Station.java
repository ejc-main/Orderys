package com.revature.orderys.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name="STATION_TABLE")
public class Station implements Serializable {
	private static final long serialVersionUID = -529102517553725487L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stationSeq")
	@SequenceGenerator(allocationSize=1, name="stationSeq", sequenceName="STATION_SEQ")
	@Column(name="STATION_ID")
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Business business;
	
	@Column(name="STATION_NAME", nullable=false)
	private String stationName;
		
	@ManyToMany(mappedBy="employeeStations")
	private List<User> employees;
	
	public Station() {
		super();
	}

	public Station(long id, Business business, String stationName) {
		super();
		this.id = id;
		this.business = business;
		this.stationName = stationName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}	
	
	public String getStationName() {
		return stationName;
	}
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	public List<User> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", business=" + business + ", stationName=" + stationName + ", employees="
				+ employees + "]";
	}
}
