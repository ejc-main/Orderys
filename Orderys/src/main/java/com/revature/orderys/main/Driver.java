package com.revature.orderys.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.orderys.bean.Rating;
import com.revature.orderys.dao.Dao;

public class Driver {

	public static void main(String[] args) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Dao dao = (Dao) ac.getBean("myDao");
		Rating r = new Rating();
		dao.makeRating(r);
		ac.close();
	}

}
