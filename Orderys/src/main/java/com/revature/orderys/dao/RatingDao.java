package com.revature.orderys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Rating;

public interface RatingDao {



	List<Rating> getAllRatings();

	void createRating(Rating r);

	Rating getRatingById(long id);

	void updateRating(Rating r);

	void deleteRating(Rating r);

}