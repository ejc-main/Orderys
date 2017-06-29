package com.revature.orderys.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductDaoTest {
	
	private AbstractApplicationContext ac;

	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("beans.xml");
	}

	@After
	public void tearDown() throws Exception {
		ac.close();
		ac = null;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
