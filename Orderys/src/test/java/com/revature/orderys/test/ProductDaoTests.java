package com.revature.orderys.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Product;
import com.revature.orderys.bean.Station;
import com.revature.orderys.bean.User;
import com.revature.orderys.dao.BusinessDao;
import com.revature.orderys.dao.ProductDao;
import com.revature.orderys.dao.StationDao;
import com.revature.orderys.dao.UserDao;

public class ProductDaoTests {

	private AbstractApplicationContext ac;
	
	private ProductDao productDao;
	
	private Product product;
	
	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		productDao = (ProductDao) ac.getBean("productDao");
		
		product = new Product();
		product.setName("Garlicky Potato Wedges");
		product.setProductPrice(new BigDecimal(5.99));
	}

	@After
	public void tearDown() throws Exception {
		ac.close();
		
		ac = null;
		product = null;
		productDao = null;
	}

	@Test
	public void testCreateAndGetProduct() {
		productDao.createProduct(product);
		long id = product.getId();
		
		product = productDao.getProductById(id);
		assertNotNull(product);
		
		product = productDao.getProductById(555);
		assertNull(product);
	}

	@Test
	public void testUpdateProduct() {
		String description = "Savory and delicious.";
		product.setDescription(description);
		
		productDao.updateProduct(product);
		
		product = productDao.getProductById(product.getId());
		
		assertTrue(product.getDescription().equals(description));
	}
	
	// TODO: Adjust once database is being persisted.
	@Test
	public void testGetAllProducts() {
		Product secondProduct = new Product();
		secondProduct.setName("Sparkling Water");
		secondProduct.setProductPrice(new BigDecimal(1.75));
		
		productDao.createProduct(product);
		productDao.createProduct(secondProduct);
		
		ArrayList<Product> allProducts = (ArrayList<Product>) productDao.getAllProducts();
		
		assertEquals(2, allProducts.size());
	}
	
	@Test
	public void testDeleteProduct() {
		productDao.createProduct(product);
		long id = product.getId();
		
		productDao.deleteProduct(product);
		
		product = productDao.getProductById(id);
		
		assertNull(product);
	}
}
