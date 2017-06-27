package com.revature.orderys.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Station;
import com.revature.orderys.bean.User;
import com.revature.orderys.dao.StationDao;
import com.revature.orderys.dao.UserDao;

@Transactional
public class Driver {

	public static void main(String[] args) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		//user test block
		UserDao dao = (UserDao) ac.getBean("userDao");
		User u = new User("wowot@gmail.com","wwwt","atot","afkaowk",User.Role.CUSTOMER);
		dao.createUser(u);
		
//		ArrayList<User> users=(ArrayList<User>) dao.getAllUsers();
//		for(User user:users){
//			System.out.println(user.getEmail());
//		}
//		User u1 = dao.getUserById(5);
//		System.out.println(u1.getFirstName()+"   "+u1.getLastName());
//		dao.deleteUser(u);
		
		//station test block
//		StationDao dao = (StationDao) ac.getBean("stationDao");
//		Station s = new Station();
		
		ac.close();
	}

}
