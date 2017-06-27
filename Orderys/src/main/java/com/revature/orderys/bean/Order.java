package com.revature.orderys.bean;

import java.io.Serializable;
import java.util.List;

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

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ORDER_TABLE")
public class Order implements Serializable {

	private static final long serialVersionUID = 7379274681923492528L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderSeq")
	@SequenceGenerator(allocationSize=1, name="orderSeq", sequenceName="ORDER_SEQ")
	@Column(name="ORDER_ID")
	private long id;
	
	// TODO: Change to many to one?
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User customer;
	
	@Column(name="PAYMENT_METHOD", nullable=false)
	private short paymentMethod;
	
	@MapsId("orderItemId")
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="orderItemId")
	private List<OrderItem> orderItems;
	
	public Order() {
		super();
	}

	public Order(long id, User customer, short paymentMethod) {
		super();
		this.id = id;
		this.customer = customer;
		this.paymentMethod = paymentMethod;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomerId(User customer) {
		this.customer = customer;
	}

	public short getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(short paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", paymentMethod=" + paymentMethod + ", orderItems="
				+ orderItems + "]";
	}
}
