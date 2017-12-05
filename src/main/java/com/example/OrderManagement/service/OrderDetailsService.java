package com.example.OrderManagement.service;

import com.example.OrderManagement.POJO.OrderDetailsVO;


public interface OrderDetailsService {
	public boolean checkInventory(String productId, int quantity);
	public boolean placeOrder(OrderDetailsVO orderDetailsVO) throws Exception;
    
}
