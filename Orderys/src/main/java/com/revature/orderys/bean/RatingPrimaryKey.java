package com.revature.orderys.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class RatingPrimaryKey implements Serializable {
	private static final long serialVersionUID = 5178716734900342018L;

	@OneToOne
	@JoinColumn(name="userid_fk", referencedColumnName="USER_ID")
	private User userId;
	
	@OneToOne
	@JoinColumn(name="productid_fk", referencedColumnName="PRODUCT_ID")
	private Product productId;
	
	public RatingPrimaryKey() {
		super();
	}

	public RatingPrimaryKey(User userId, Product productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}
}
