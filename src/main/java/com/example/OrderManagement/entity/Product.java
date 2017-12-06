package com.example.OrderManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	private String productName;
	private long quantity;
	
	public Product(){
		
	}
	
	public Product(long product_id, String product_name, long quantity) {
		super();
		this.productId = product_id;
		this.productName = product_name;
		this.quantity = quantity;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long product_id) {
		this.productId = product_id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String product_name) {
		this.productName = product_name;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "products [product_id=" + productId + ", product_name=" + productName + ", quantity=" + quantity + "]";
	}
}
