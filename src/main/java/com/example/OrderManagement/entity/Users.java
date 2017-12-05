package com.example.OrderManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long user_id;
	private String name;
	private String email;
	private String phone_number;
	private String address;
	
	public Users(){
		
	}
	
	public Users(long user_id, String name, String email, String phone_number, String address) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
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
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", name=" + name + ", email=" + email + ", phone_number=" + phone_number
				+ ", address=" + address + "]";
	}

	
	
}
