package com.revature.orderys.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Rating")
public class Rating implements Serializable {
	private static final long serialVersionUID = -8703568968425115709L;

	@EmbeddedId
	private RatingPrimaryKey ratingId;

	@Column(name="RATING")
	private short rating;

	public Rating() {
		super();
	}

	public Rating(RatingPrimaryKey ratingId, short rating) {
		super();
		this.ratingId = ratingId;
		this.rating = rating;
	}

	public RatingPrimaryKey getRatingId() {
		return ratingId;
	}
	
	public void setRatingId(RatingPrimaryKey ratingId) {
		this.ratingId = ratingId;
	}

	public short getRating() {
		return rating;
	}

	public void setRating(short rating) {
		this.rating = rating;
	}
}
