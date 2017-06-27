package com.revature.orderys.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME_PLACED", nullable=false)
	private Date timePlaced;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME_FULFILLED")
	private Date timeCompleted;
	
	@Column(name="STATUS", nullable=false)
	private String status;
	
	public OrderItem() {
		super();
	}

	public OrderItem(OrderItemPrimaryKey orderItemKey, int quantity, String note, Date timePlaced, Date timeCompleted,
			String status) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
