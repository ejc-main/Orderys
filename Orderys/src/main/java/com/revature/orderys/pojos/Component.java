package com.revature.orderys.pojos;

import java.math.BigDecimal;

// TODO: Remove if customizable ordering is not implemented...
public class Component {
	private long id;
	private String name;
	private BigDecimal price;
	
	public Component() {
		super();
	}

	public Component(long id, String name, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}	
}
