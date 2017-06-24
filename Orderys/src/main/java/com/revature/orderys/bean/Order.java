package com.revature.orderys.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDER")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderSeq")
	@SequenceGenerator(allocationSize=1, name="orderSeq", sequenceName="ORDER_SEQ")
	@Column(name="ORDER_ID")
	private long id;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private long customerId;
	
	@Column(name="TIME_PLACED")
	private Date timePlaced;
	
	@Column(name="TIME_FULFILLED")
	private Date timeFulfilled;
	
	@Column(name="PAYMENT_METHOD")
	private short paymentMethod;
	
	@Column(name="STATUS")
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
