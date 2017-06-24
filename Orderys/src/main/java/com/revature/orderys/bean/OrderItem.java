package com.revature.orderys.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_ID")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="PRODUCT_ID")
	private long productId;
	
	@Column(name="ORDER_ID")
	private long orderId;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Column(name="NOTE")
	private String note;
	
	public OrderItem() {
		super();
	}

	public OrderItem(long productId, long orderId, int quantity, String note) {
		super();
		this.productId = productId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.note = note;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
