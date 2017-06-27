//package com.revature.orderys.bean;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//// TODO: Remove if customizable ordering is not implemented...
//@Entity
//@Table(name="COMPONENT")
//public class Component implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="componentSeq")
//	@SequenceGenerator(allocationSize=1, name="componentSeq", sequenceName="COMPONENT_SEQ")
//	@Column(name="COMPONENT_ID")
//	private long id;
//	
//	@Column(name="NAME")
//	private String name;
//	
//	@Column(name="PRICE")
//	private BigDecimal price;
//	
//	public Component() {
//		super();
//	}
//
//	public Component(long id, String name, BigDecimal price) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public BigDecimal getPrice() {
//		return price;
//	}
//
//	public void setPrice(BigDecimal price) {
//		this.price = price;
//	}	
//}
