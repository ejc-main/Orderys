package com.revature.orderys.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Check;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCT_TABLE")
@Check(constraints = "PRODUCT_PRICE > 0")
public class Product implements Serializable {
	private static final long serialVersionUID = 4341819973903627363L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productSeq")
	@SequenceGenerator(allocationSize=1, name="productSeq", sequenceName="PRODUCT_SEQ")
	@Column(name="PRODUCT_ID")
	private long id;
	
	@OneToOne
	@JoinColumn(name="STATION_ID")
	private Station station;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="PRODUCT_PRICE", nullable=false)
	private BigDecimal productPrice;
	
	@Column(name="INTENDED_COMPLETION_TIME")
	private long intendedCompletionTime;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PHOTO_URL")
	private String photoUrl;
	
	@MapsId("ratingId")
	@OneToMany(fetch=FetchType.LAZY) 
	@JoinColumn(name="orderItemId")
	private List<Rating> ratings;
	
	public Product() {
		super();
	}

	public Product(long id, Station station, String name, BigDecimal productPrice, long intendedCompletionTime, String description) {
		super();
		this.id = id;
		this.station = station;
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

	public Station getStation() {
		return station;
	}
	
	public void setStation(Station station) {
		this.station = station;
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

	public long getIntendedCompletionTime() {
		return intendedCompletionTime;
	}

	public void setIntendedCompletionTime(long intendedCompletionTime) {
		this.intendedCompletionTime = intendedCompletionTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Rating> getRatings() {
		return ratings;
	}
	
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", station=" + station + ", name=" + name + ", productPrice=" + productPrice
				+ ", intendedCompletionTime=" + intendedCompletionTime + ", description=" + description + ", photoUrl="
				+ photoUrl + ", ratings=" + ratings + "]";
	}
}
