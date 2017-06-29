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

	@Column(name="COMMENT")
	private String comment;
	
	public Rating() {
		super();
		
		this.comment = "";
	}

	public Rating(RatingPrimaryKey ratingKey, short rating, String comment) {
		super();
		this.ratingKey = ratingKey;
		this.rating = rating;
		this.comment = comment;
	}

	public RatingPrimaryKey getRatingKey() {
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

	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
}
