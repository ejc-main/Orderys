package com.revature.orderys.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Rating")
public class Rating implements Serializable {
	private static final long serialVersionUID = -8703568968425115709L;

	@Column(name="CUSTOMER_ID")
	private long customerId;

	@Id
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
