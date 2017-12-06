package com.example.OrderManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long userId;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	
	public Users(){
		
	}
	
	public Users(long user_id, String name, String email, String phone_number, String address) {
		super();
		this.userId = user_id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phone_number;
		this.address = address;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long user_id) {
		this.userId = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phone_number) {
		this.phoneNumber = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + userId + ", name=" + name + ", email=" + email + ", phone_number=" + phoneNumber
				+ ", address=" + address + "]";
	}

	
	
}
