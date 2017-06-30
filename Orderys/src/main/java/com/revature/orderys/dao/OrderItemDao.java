package com.revature.orderys.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Order;
import com.revature.orderys.bean.OrderItem;
import com.revature.orderys.bean.OrderItemPrimaryKey;
import com.revature.orderys.bean.User;

public interface OrderItemDao {

	List<OrderItem> getAllOrderItems();

	List<OrderItem> getOrderItemsByBusiness(Business business);

	List<OrderItem> getOrderItemsByOrder(Order order);

	List<OrderItem> getOrderItemByEmployee(User user);

	void createOrderItem(OrderItem orderItem);

	OrderItem getOrderItemByKey(OrderItemPrimaryKey key);

	void updateOrderItem(OrderItem orderItem);

	void deleteOrderItem(OrderItem orderItem);

}