package com.example.OrderManagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long order_id;
	private String shipping_address;
	private double amount;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id")
	private Product product;
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;
	private long credit_card_number;
	
	
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getCredit_card_number() {
		return credit_card_number;
	}
	public void setCredit_card_number(long credit_card_number) {
		this.credit_card_number = credit_card_number;
	}
	@Override
	public String toString() {
		return "OrderDetails [order_id=" + order_id + ", shipping_address=" + shipping_address + ", amount=" + amount
				+ ", product=" + product + ", user=" + user + ", credit_card_number=" + credit_card_number + "]";
	}
	
	
	
}
