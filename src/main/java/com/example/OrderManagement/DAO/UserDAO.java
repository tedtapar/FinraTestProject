package com.example.OrderManagement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrderManagement.entity.User;

public interface UserDAO extends JpaRepository<User, Long> {

}
