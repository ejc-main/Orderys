package com.revature.orderys.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class OrderItemPrimaryKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name="orderid_fk", referencedColumnName="ORDER_ID")
	Order order;
	
	@OneToOne
	@JoinColumn(name="productid_fk", referencedColumnName="PRODUCT_ID")
	Product product;
	
	public OrderItemPrimaryKey() {
		super();
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
	
	
}