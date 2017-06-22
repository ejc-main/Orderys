package com.revature.orderys.pojos;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Remove if customizable ordering is not implemented...
@Entity
@Table(name="COMPONENT")
public class Component {
	@Id
	@Column(name="COMPONENT_ID")
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PRICE")
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
