package com.revature.orderys.bean;

// TODO: This class may not be necessary (Hibernate may take care of this...)
public class ProductProvider {
	private long productId;
	private long businessId;
	
	public ProductProvider() {
		super();
	}

	public ProductProvider(long productId, long businessId) {
		super();
		this.productId = productId;
		this.businessId = businessId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}
}
