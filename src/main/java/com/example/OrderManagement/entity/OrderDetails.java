package com.example.OrderManagement.entity;

import java.math.BigDecimal;

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
	private BigDecimal amount;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id")
	private Product product;
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private Users user;
	private String credit_card_number;
	
	
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
	@Override
	public String toString() {
		return "OrderDetails [order_id=" + order_id + ", shipping_address=" + shipping_address + ", amount=" + amount
				+ ", product=" + product + ", user=" + user + ", credit_card_number=" + credit_card_number + "]";
	}
	
	
	
}
