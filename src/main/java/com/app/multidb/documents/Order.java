package com.app.multidb.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "orders")
public class Order {

	@Id
	private String orderId;
	
	@Indexed
	private String customerId;
	
	@Indexed
	private String productId;
	
	private double price;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", productId=" + productId + ", price="
				+ price + "]";
	}

	public Order() {
		super();
	}

	public Order(String orderId, String customerId, String productId, double price) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.productId = productId;
		this.price = price;
	}
	
	
}
