package com.revature.orderys.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ORDER_ITEM_TABLE")
public class OrderItem implements Serializable {
	
	private static final long serialVersionUID = 5236751285429294295L;

	@EmbeddedId	
	OrderItemPrimaryKey orderItemKey;
	
	@Column(name="QUANTITY", nullable=false)
	private int quantity;
	
	@Column(name="NOTE")
	private String note;
	
	@Column(name="TIME_PLACED", nullable=false)
	private Date timePlaced;
	
	@Column(name="TIME_COMPLETED")
	private Date timeCompleted;
	
	@Column(name="STATUS", nullable=false)
	private Status status;
	
	static enum Status {
		PENDING,
		COMPLETED
	}
	
	public OrderItem() {
		super();
	}

	public OrderItem(OrderItemPrimaryKey orderItemKey, int quantity, String note, Date timePlaced, Date timeCompleted,
			Status status) {
		super();
		this.orderItemKey = orderItemKey;
		this.quantity = quantity;
		this.note = note;
		this.timePlaced = timePlaced;
		this.timeCompleted = timeCompleted;
		this.status = status;
	}

	/**
	 * Sets timePlaced to the current time on creation of OrderItem
	 * object.
	 */
	@PrePersist 
	protected void onCreate() {
		timePlaced = new Date();
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
	
	public Date getTimePlaced() {
		return timePlaced;
	}
	
	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}
	
	public Date getTimeCompleted() {
		return timeCompleted;
	}

	public void setTimeCompleted(Date timeCompleted) {
		this.timeCompleted = timeCompleted;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemKey=" + orderItemKey + ", quantity=" + quantity + ", note=" + note + ", timePlaced="
				+ timePlaced + ", timeCompleted=" + timeCompleted + ", status=" + status + "]";
	}
}
