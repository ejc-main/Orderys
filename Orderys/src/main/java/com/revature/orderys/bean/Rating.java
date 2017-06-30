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
	private RatingPrimaryKey ratingId;

	@Column(name="RATING", nullable=false)
	private short rating;

	@Column(name="COMMENT")
	private String comment;
	
	public Rating() {
		super();
		
		this.comment = "";
	}

	public Rating(RatingPrimaryKey ratingId, short rating, String comment) {
		super();
		this.ratingId = ratingId;
		this.rating = rating;
		this.comment = comment;
	}

	public RatingPrimaryKey getRatingId() {
		return ratingId;
	}
	
	public void setRatingId(RatingPrimaryKey ratingKey) {
		this.ratingId = ratingKey;
	}

	public short getRating() {
		return rating;
	}

	public void setRating(short rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", rating=" + rating + ", comment=" + comment + "]";
	}
}
