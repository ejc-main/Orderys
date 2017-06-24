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
	private User customerId;

	@Id
	@Column(name="PRODUCT_ID")
	private Product productId;

	@Column(name="RATING")
	private short rating;

	public Rating() {
		super();
	}

	public Rating(User customerId, Product productId, short rating) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.rating = rating;
	}

	public User getCustomerId() {
		return customerId;
	}

	public void setCustomerId(User customerId) {
		this.customerId = customerId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public short getRating() {
		return rating;
	}

	public void setRating(short rating) {
		this.rating = rating;
	}
}
