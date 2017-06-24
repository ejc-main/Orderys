package com.revature.orderys.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_ID")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId	
	OrderItemPrimaryKey orderItemId;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Column(name="NOTE")
	private String note;
	
	public OrderItem() {
		super();
	}
	
	public OrderItem(OrderItemPrimaryKey orderItemId, int quantity, String note) {
		super();
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.note = note;
	}

	public OrderItemPrimaryKey getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(OrderItemPrimaryKey orderItemId) {
		this.orderItemId = orderItemId;
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
}
