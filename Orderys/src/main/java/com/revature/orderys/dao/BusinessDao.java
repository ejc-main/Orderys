package com.revature.orderys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.User;

public interface BusinessDao {


	List<Business> getAllBusinesses();

	void createBusiness(Business b);

	Business getBusinessById(long id);

	Business getBusinessByManager(User m);

	void updateBusiness(Business b);

	void deleteBusiness(Business b);

}