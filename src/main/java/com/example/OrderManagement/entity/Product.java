package com.example.OrderManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long product_id;
	private String product_name;
	private long quantity;
	
	public Product(){
		
	}
	
	public Product(long product_id, String product_name, long quantity) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.quantity = quantity;
	}
	
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "products [product_id=" + product_id + ", product_name=" + product_name + ", quantity=" + quantity + "]";
	}
}
