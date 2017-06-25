package com.revature.orderys.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDER")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderSeq")
	@SequenceGenerator(allocationSize=1, name="orderSeq", sequenceName="ORDER_SEQ")
	@Column(name="ORDER_ID")
	private long id;
	
	// TODO: Find out if this is right... should it be many to one?
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User customerId;
	
	@Column(name="PAYMENT_METHOD")
	private short paymentMethod;
	
	@MapsId("orderItemId")
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="orderItemId")
	private Set<OrderItem> orderItems;
	
	public Order() {
		super();
	}

	public Order(long id, User customerId, short paymentMethod) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.paymentMethod = paymentMethod;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getCustomerId() {
		return customerId;
	}

	public void setCustomerId(User customerId) {
		this.customerId = customerId;
	}

	public short getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(short paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}
