package com.revature.orderys.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_ITEM_TABLE")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId	
	OrderItemPrimaryKey orderItemKey;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Column(name="NOTE")
	private String note;
	
	@Column(name="TIME_FULFILLED")
	private Date timeCompleted;
	
	@Column(name="PAYMENT_METHOD")
	private short paymentMethod;
	
	@Column(name="STATUS")
	private String status;
	
	public OrderItem() {
		super();
	}

	public OrderItem(OrderItemPrimaryKey orderItemKey, int quantity, String note, Date timeCompleted,
			short paymentMethod, String status) {
		super();
		this.orderItemKey = orderItemKey;
		this.quantity = quantity;
		this.note = note;
		this.timeCompleted = timeCompleted;
		this.paymentMethod = paymentMethod;
		this.status = status;
	}

	public OrderItemPrimaryKey getOrderItemKey() {
		return orderItemKey;
	}

	public void setOrderItemKey(OrderItemPrimaryKey orderItemKey) {
		this.orderItemKey = orderItemKey;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getTimeCompleted() {
		return timeCompleted;
	}

	public void setTimeCompleted(Date timeCompleted) {
		this.timeCompleted = timeCompleted;
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
