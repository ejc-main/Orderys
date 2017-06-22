package com.revature.orderys.pojos;

//TODO: Remove if customizable ordering is not implemented...
public class ProductComponent {
	private long productId;
	private long componentId;
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
