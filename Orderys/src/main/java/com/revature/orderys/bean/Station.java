package com.revature.orderys.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATION_TABLE")
public class Station implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="STATION_ID")
	private long id;
	
	@Column(name="BUSINESS_ID")
	private long businessId;
	
	@Column(name="STATION_NAME")
	private String stationName;
	
	public Station() {
		super();
	}

	public Station(long id, long businessId, String stationName) {
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

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}	
	
	public String getStationName() {
		return stationName;
	}
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
}
