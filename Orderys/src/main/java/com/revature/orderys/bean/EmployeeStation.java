package com.revature.orderys.bean;

// TODO: Find out if this table is still necessary...
// Reasoning: Employees are now only assigned to one business.
//				This table may be redundant.
public class EmployeeStation {
	private long stationId;
	private long employeeId;
	
	public EmployeeStation() {
		super();
	}

	public EmployeeStation(long stationId, long employeeId) {
		super();
		this.stationId = stationId;
		this.employeeId = employeeId;
	}

	public long getStationId() {
		return stationId;
	}

	public void setStationId(long stationId) {
		this.stationId = stationId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}	
}
