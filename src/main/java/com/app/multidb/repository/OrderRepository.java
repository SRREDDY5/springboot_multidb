package com.app.multidb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.multidb.documents.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

	List<Order> getByCustomerIdAndProductId(String customerId, String productId);
}
