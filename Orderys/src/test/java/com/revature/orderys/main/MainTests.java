package com.revature.orderys.main;

import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.User;
import com.revature.orderys.service.Service;

@Transactional
public class MainTests {

//	@Test
//	public void test() {
//		System.out.println("Running MainTests.java");
//		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		//user test block
//		UserDao dao = (UserDao) ac.getBean("userDao");
//		User u = new User("wowot@gmail.com","wwwt","atot","afkaowk",User.Role.CUSTOMER);
//		dao.createUser(u);
//		
////		ArrayList<User> users=(ArrayList<User>) dao.getAllUsers();
////		for(User user:users){
////			System.out.println(user.getEmail());
////		}
////		User u1 = dao.getUserById(5);
////		System.out.println(u1.getFirstName()+"   "+u1.getLastName());
////		dao.deleteUser(u);
//		
//		//station test block
////		StationDao dao = (StationDao) ac.getBean("stationDao");
////		Station s = new Station();
//		
//		ac.close();
//	}
	public static void main(String[] args) {
		Service service = new Service();
//		service.addNewUser("email", "passwordHash", "firstName", "lastName", "CUSTOMER");
//		User u = service.getUserById(1);
//		System.out.println(u.getEmail());
//		System.out.println("stop");
		
	}

}
