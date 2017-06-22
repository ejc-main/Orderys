package com.revature.orderys.pojos;

import java.math.BigDecimal;
import java.sql.Date;

public class Product {
	private long id;
	private String name;
	private BigDecimal productPrice;
	private Date intendedCompletionTime;
	private String description;
	
	public Product() {
		super();
	}

	public Product(long id, String name, BigDecimal productPrice, Date intendedCompletionTime, String description) {
		super();
		this.id = id;
		this.name = name;
		this.productPrice = productPrice;
		this.intendedCompletionTime = intendedCompletionTime;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public Date getIntendedCompletionTime() {
		return intendedCompletionTime;
	}

	public void setIntendedCompletionTime(Date intendedCompletionTime) {
		this.intendedCompletionTime = intendedCompletionTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
