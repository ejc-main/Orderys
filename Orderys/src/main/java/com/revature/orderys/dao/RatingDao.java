package com.revature.orderys.dao;

import java.util.List;

import com.revature.orderys.bean.Rating;
import com.revature.orderys.bean.RatingPrimaryKey;

public interface RatingDao {


	List<Rating> getAllRatings();

	void createRating(Rating r);

	Rating getRatingByKey(RatingPrimaryKey key);

	void updateRating(Rating r);

	void deleteRating(Rating r);

}