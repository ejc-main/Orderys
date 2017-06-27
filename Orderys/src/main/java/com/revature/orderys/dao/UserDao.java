package com.revature.orderys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.User;

public interface UserDao {

	void setSessionFactory(SessionFactory sessionFactory);

	List<User> getAllUsers();

	void createUser(User u);

	User getUserById(long id);

	void updateUser(User u);

	void deleteUser(User u);

}