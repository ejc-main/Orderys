package com.revature.orderys.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RATING")
public class Rating {
	@Column(name="CUSTOMER_ID")
	private long customerId;
	
	@Column(name="PRODUCT_ID")
	private long productId;
	
	@Column(name="RATING")
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
