package com.example.OrderManagement.POJO;

import java.math.BigDecimal;

import com.example.OrderManagement.entity.Product;
import com.example.OrderManagement.entity.Users;

public class OrderDetailsVO {
	private String shippingAddress;
	private BigDecimal amount;
	private Product product;
	private Users user;
	private String creditCardNumber;
	
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shipping_address) {
		this.shippingAddress = shipping_address;
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
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String credit_card_number) {
		this.creditCardNumber = credit_card_number;
	}
}
