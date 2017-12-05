package com.example.OrderManagement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrderManagement.entity.Users;

public interface UserDAO extends JpaRepository<Users, Long> {

}
