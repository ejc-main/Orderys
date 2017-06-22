package com.revature.orderys.pojos;

import java.sql.Date;

public class Order {
	private long id;
	private long customerId;
	private Date timePlaced;
	private Date timeFulfilled;
	private short paymentMethod;
	private String status;
	
	public Order() {
		super();
	}

	public Order(long id, long customerId, Date timePlaced, Date timeFulfilled, short paymentMethod, String status) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.timePlaced = timePlaced;
		this.timeFulfilled = timeFulfilled;
		this.paymentMethod = paymentMethod;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Date getTimePlaced() {
		return timePlaced;
	}

	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}

	public Date getTimeFulfilled() {
		return timeFulfilled;
	}

	public void setTimeFulfilled(Date timeFulfilled) {
		this.timeFulfilled = timeFulfilled;
	}

	public short getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(short paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
