package com.revature.orderys.pojos;

public class Station {
	private long id;
	private long businessId;
	
	public Station() {
		super();
	}

	public Station(long id, long businessId) {
		super();
		this.id = id;
		this.businessId = businessId;
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
}
