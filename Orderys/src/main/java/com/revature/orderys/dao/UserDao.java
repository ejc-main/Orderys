package com.revature.orderys.dao;

import java.util.List;

import com.revature.orderys.bean.User;

public interface UserDao {

	List<User> getAllUsers();

	void createUser(User u);

	User getUserById(long id);

	void updateUser(User u);

	void deleteUser(User u);

	User getUserByEmail(String email);

}