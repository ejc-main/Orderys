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
	
	@OneToOne
	@JoinColumn(name="productid_fk", referencedColumnName="PRODUCT_ID")
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
}