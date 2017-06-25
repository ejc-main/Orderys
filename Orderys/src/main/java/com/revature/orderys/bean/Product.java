package com.revature.orderys.bean;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="PRODUCT_TABLE")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productSeq")
	@SequenceGenerator(allocationSize=1, name="productSeq", sequenceName="PRODUCT_SEQ")
	@Column(name="PRODUCT_ID")
	private long id;
	
	@OneToOne
	@JoinColumn(name="STATION_ID")
	private Station stationId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BUSINESS_ID")
	private long businessId;
	
	@Column(name="PRODUCT_PRICE")
	private BigDecimal productPrice;
	
	@Column(name="INTENDED_COMPLETION_TIME")
	private Date intendedCompletionTime;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PHOTO_URL")
	private String photoUrl;
	
	@MapsId("ratingId")
	@OneToMany(fetch=FetchType.LAZY) 
	@JoinColumn(name="orderItemId")
	private Set<Rating> ratings;
	
	public Product() {
		super();
	}

	public Product(long id, Station stationId, String name, BigDecimal productPrice, Date intendedCompletionTime, String description) {
		super();
		this.id = id;
		this.stationId = stationId;
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

	public Station getStationId() {
		return stationId;
	}
	
	public void setStationId(Station stationId) {
		this.stationId = stationId;
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
	
	public Set<Rating> getRatings() {
		return ratings;
	}
	
	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
}
