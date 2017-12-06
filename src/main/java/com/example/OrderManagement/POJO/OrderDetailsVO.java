package com.example.OrderManagement.POJO;

import java.math.BigDecimal;

import com.example.OrderManagement.entity.Product;
import com.example.OrderManagement.entity.Users;

public class OrderDetailsVO {
	private String shipping_address;
	private BigDecimal amount;
	private Product product;
	private Users user;
	private String credit_card_number;
	
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getCredit_card_number() {
		return credit_card_number;
	}
	public void setCredit_card_number(String credit_card_number) {
		this.credit_card_number = credit_card_number;
	}
}
