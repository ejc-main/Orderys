package com.revature.orderys.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Embeddable
public class RatingPrimaryKey implements Serializable {
	private static final long serialVersionUID = 5178716734900342018L;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid_fk", referencedColumnName="USER_ID")
	@JsonIgnore
	private User userId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="productid_fk", referencedColumnName="PRODUCT_ID")
	@JsonIgnore
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

	@Override
	public String toString() {
		return "RatingPrimaryKey [userId=" + userId + ", productId=" + productId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RatingPrimaryKey other = (RatingPrimaryKey) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
}
