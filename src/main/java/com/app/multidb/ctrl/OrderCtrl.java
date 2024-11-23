package com.app.multidb.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.multidb.documents.Order;
import com.app.multidb.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderCtrl {

	@Autowired
	OrderService orderService;

	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrderByOrderId(@PathVariable String orderId) {
		Order order = orderService.getOrderById(orderId);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Order>> getOrderByOrderId() {
		List<Order> orders = orderService.getAllOrders();
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		Order response = orderService.createOrder(order);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/{customerId}/{productId}")
	public ResponseEntity<List<Order>> getOrderByCustomerIdAndProductId(@PathVariable String customerId,
			@PathVariable String productId) {
		List<Order> orders = orderService.getOrderByCustomerIdAndProductId(customerId, productId);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
}
