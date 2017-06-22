package com.revature.orderys.bean;

public class OrderItem {
	private long productId;
	private long orderId;
	private int quantity;
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
