package com.revature.orderys.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="RATING_TABLE")
public class Rating implements Serializable {
	private static final long serialVersionUID = -8703568968425115709L;

	@EmbeddedId
	private RatingPrimaryKey ratingKey;

	@Column(name="RATING", nullable=false)
	private short rating;

	@Column(name="REVIEW")
	private String review;
	
	public Rating() {
		super();
		
		this.review = "";
	}

	public Rating(RatingPrimaryKey ratingKey, short rating, String review) {
		super();
		this.ratingKey = ratingKey;
		this.rating = rating;
		this.review = review;
	}

	public RatingPrimaryKey getRatingId() {
		return ratingKey;
	}
	
	public void setRatingId(RatingPrimaryKey ratingKey) {
		this.ratingKey = ratingKey;
	}

	public short getRating() {
		return rating;
	}

	public void setRating(short rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}
	
	public void setComment(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Rating [ratingKey=" + ratingKey + ", rating=" + rating + ", review=" + review + "]";
	}
}
