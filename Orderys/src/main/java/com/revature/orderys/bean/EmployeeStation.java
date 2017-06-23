package com.revature.orderys.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Find out if this table is still necessary...
// Reasoning: Employees are now only assigned to one business.
//				This table may be redundant.
@Entity
@Table(name="EMPLOYEE_STATION")
public class EmployeeStation {
	@Column(name="STATION_ID")
	private long stationId;
	
	@Column(name="EMPLOYEE_ID")
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
