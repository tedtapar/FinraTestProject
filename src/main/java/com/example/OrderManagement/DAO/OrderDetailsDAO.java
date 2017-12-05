package com.example.OrderManagement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrderManagement.entity.OrderDetails;

public interface OrderDetailsDAO extends JpaRepository<OrderDetails, Long>{

}
