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
public class OrderItemPrimaryKey implements Serializable {
	
	private static final long serialVersionUID = -3594529445590675729L;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="orderid_fk", referencedColumnName="ORDER_ID")
	@JsonIgnore
	Order order;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="productid_fk", referencedColumnName="PRODUCT_ID")
	@JsonIgnore
	Product product;
	
	public OrderItemPrimaryKey() {
		super();
	}

	public OrderItemPrimaryKey(Order order, Product product) {
		this.order = order;
		this.product = product;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderItemPrimaryKey [order=" + order + ", product=" + product + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		OrderItemPrimaryKey other = (OrderItemPrimaryKey) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	
}