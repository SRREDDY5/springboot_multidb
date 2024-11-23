package com.app.multidb.service;

import java.util.List;

import com.app.multidb.documents.Order;

public interface OrderService {

	Order createOrder(Order order);
	
	Order updateOrder(Order order);
	
	List<Order> getOrderByCustomerIdAndProductId(String customerId, String productId);
	
	Order getOrderById(String orderId);
	
	List<Order> getAllOrders();
}
