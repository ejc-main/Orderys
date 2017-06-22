package com.revature.orderys.pojos;

public class Rating {
	private long customerId;
	private long productId;
	private short rating;
	
	public Rating() {
		super();
	}

	public Rating(long customerId, long productId, short rating) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.rating = rating;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public short getRating() {
		return rating;
	}

	public void setRating(short rating) {
		this.rating = rating;
	}
}
