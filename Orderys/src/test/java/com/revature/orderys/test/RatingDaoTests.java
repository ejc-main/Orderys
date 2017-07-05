//package com.revature.orderys.test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.revature.orderys.bean.Business;
//import com.revature.orderys.bean.Product;
//import com.revature.orderys.bean.Rating;
//import com.revature.orderys.bean.RatingPrimaryKey;
//import com.revature.orderys.bean.User;
//import com.revature.orderys.dao.BusinessDao;
//import com.revature.orderys.dao.ProductDao;
//import com.revature.orderys.dao.RatingDao;
//import com.revature.orderys.dao.UserDao;
//
//public class RatingDaoTests {
//	private AbstractApplicationContext ac;
//	
//	private ProductDao productDao;
//	private BusinessDao businessDao;
//	private UserDao userDao;
//	private RatingDao ratingDao;
//	
//	private Product product;
//	private Business business;
//	private User user;
//	private Rating rating;
//	
//	@Before
//	public void setUp() throws Exception {
//		ac = new ClassPathXmlApplicationContext("beans.xml");
//		productDao = (ProductDao) ac.getBean("productDao");
//		businessDao = (BusinessDao) ac.getBean("businessDao");
//		userDao = (UserDao) ac.getBean("userDao");
//		ratingDao = (RatingDao) ac.getBean("ratingDao");
//		
//		user = new User();
//		user.setEmail("address@email.com");
//		user.setFirstName("Mary");
//		user.setLastName("Berry");
//		user.setPasswordHash("pwdHash");
//		user.setRole(User.Role.MANAGER);
//		userDao.createUser(user);
//		
//		business = new Business();
//		business.setCity("Anytown");
//		business.setCountry("USA");
//		business.setState("WA");
//		business.setName("Burger Hut");
//		business.setStreetAddress1("123 Oak Drive");
//		business.setZip("12343");
//		business.setManager(user);
//		businessDao.createBusiness(business);
//		
//		product = new Product();
//		product.setName("Steamed Cheeseburger");
//		product.setProductPrice(new BigDecimal(4.99));
//		productDao.createProduct(product);
//		
//		rating = new Rating();
//		rating.setRating((short)4);
//		rating.setRatingId(new RatingPrimaryKey(user, product));
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		ac.close();
//		ac = null;
//		
//		productDao = null;
//		businessDao = null;
//		userDao = null;
//		ratingDao = null;
//		
//		product = null;
//		business = null;
//		user = null;
//		rating = null;
//	}
//
//	@Test
//	public void testCreateAndGetRating() {
//		ratingDao.createRating(rating);
//		
//		RatingPrimaryKey key = new RatingPrimaryKey(user, product);
//		rating = ratingDao.getRatingByKey(key);
//		
//		assertNotNull(rating);
//	}
//
//	@Test
//	public void testUpdateRating() {
//		ratingDao.createRating(rating);
//		
//		short oldRating = rating.getRating();
//		rating.setRating((short) (oldRating - 1));
//		ratingDao.updateRating(rating);
//		
//		RatingPrimaryKey key = new RatingPrimaryKey(user, product);
//		rating = ratingDao.getRatingByKey(key);
//		
//		assertFalse(oldRating == rating.getRating());
//	}
//	
//	@Test
//	public void testDeleteRating() {
//		ratingDao.createRating(rating);
//		
//		RatingPrimaryKey key = new RatingPrimaryKey(user, product);
//		ratingDao.deleteRating(rating);
//		
//		rating = ratingDao.getRatingByKey(key);
//		
//		assertNull(rating);
//	}
//	
//	@Test
//	public void testGetAllRatings() {
//		ratingDao.createRating(rating);
//		
//		Product product2 = new Product();
//		product2.setName("The Burger of Fire!!!");
//		product2.setProductPrice(new BigDecimal(7.99));
//		productDao.createProduct(product2);
//		
//		Rating rating2 = new Rating();
//		rating2.setRating((short)5);
//		rating2.setRatingId(new RatingPrimaryKey(user, product2));
//		ratingDao.createRating(rating2);
//		
//		ArrayList<Rating> allRatings = (ArrayList<Rating>) ratingDao.getAllRatings();
//		
//		assertEquals(2, allRatings.size());
//	}
//}
