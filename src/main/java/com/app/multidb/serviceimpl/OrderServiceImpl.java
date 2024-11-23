package com.app.multidb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.multidb.documents.Order;
import com.app.multidb.repository.OrderRepository;
import com.app.multidb.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order updateOrder(Order order) {

		Order dbOrder = orderRepository.findById(order.getOrderId()).get();
		dbOrder.setCustomerId(order.getCustomerId());
		dbOrder.setProductId(order.getProductId());

		return orderRepository.save(dbOrder);

	}

	@Override
	public List<Order> getOrderByCustomerIdAndProductId(String customerId, String productId) {
		return orderRepository.getByCustomerIdAndProductId(customerId, productId);
	}

	@Override
	public Order getOrderById(String orderId) {
		return orderRepository.findById(orderId).get();
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
}
