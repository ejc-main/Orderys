package com.revature.orderys.main;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.User;
import com.revature.orderys.dao.UserDaoImpl;

@Transactional
public class Driver {

	public static void main(String[] args) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDaoImpl dao = (UserDaoImpl) ac.getBean("userDao");
//		User u = new User(1,"atat@gmail.com","atot","atot",User.Role.CUSTOMER);
//		dao.createUser(u);
		
//		ArrayList<User> users=(ArrayList<User>) dao.getAllUsers();
//		for(User user:users){
//			System.out.println(user.getEmail());
//		}
		User u = dao.getUserById(1);
		System.out.println(u.getFirstName()+"   "+u.getLastName());
		dao.deleteUser(u);
		ac.close();
	}

}
