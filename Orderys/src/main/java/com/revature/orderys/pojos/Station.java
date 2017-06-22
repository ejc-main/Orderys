package com.revature.orderys.pojos;

public class Station {
	private long id;
	private long businessId;
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
