package com.revature.orderys.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Rating;

public interface RatingDao {



	void makeRating(Rating rating);

}