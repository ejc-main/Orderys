package com.revature.orderys.main;

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
		User u = new User("markworth@gmail.com","Mark","Borth",User.Role.MANAGER);
		dao.createUser(u);
		ac.close();
	}

}
