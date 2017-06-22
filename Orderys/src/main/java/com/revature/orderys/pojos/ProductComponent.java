package com.revature.orderys.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//TODO: Remove if customizable ordering is not implemented...
@Entity
@Table(name="PRODUCT_COMPONENT")
public class ProductComponent {
	@Column(name="PRODUCT_ID")
	private long productId;
	
	@Column(name="COMPONENT_ID")
	private long componentId;
	
	@Column(name="AMOUNT")
	private int amount;
	
	public ProductComponent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductComponent(long productId, long componentId, int amount) {
		super();
		this.productId = productId;
		this.componentId = componentId;
		this.amount = amount;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getComponentId() {
		return componentId;
	}

	public void setComponentId(long componentId) {
		this.componentId = componentId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
