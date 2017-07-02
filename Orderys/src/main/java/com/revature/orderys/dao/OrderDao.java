package com.revature.orderys.dao;

import java.util.List;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Order;
import com.revature.orderys.bean.User;

public interface OrderDao {

	List<Order> getAllOrders();

	void createOrder(Order o);

	Order getOrderById(long id);

	List<Order> getOrdersByCustomer(User c);

	List<Order> getOrdersByBusiness(Business b);

	void updateOrder(Order o);

	void deleteOrder(Order o);

}