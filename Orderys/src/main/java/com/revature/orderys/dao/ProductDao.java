package com.revature.orderys.dao;

import java.util.List;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Product;

public interface ProductDao {


	List<Product> getAllProducts();

	List<Product> getAllProductsByBusiness(Business business);
	
	void createProduct(Product p);

	Product getProductById(long id);

	void updateProduct(Product p);

	void deleteProduct(Product p);

}