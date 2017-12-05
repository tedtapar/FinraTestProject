package com.example.OrderManagement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrderManagement.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {
	
}
