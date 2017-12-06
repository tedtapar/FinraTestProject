package com.example.OrderManagement.utilities;

import com.example.OrderManagement.POJO.OrderDetailsVO;
import com.example.OrderManagement.POJO.ProductVO;
import com.example.OrderManagement.POJO.UserVO;
import com.example.OrderManagement.entity.OrderDetails;
import com.example.OrderManagement.entity.Product;
import com.example.OrderManagement.entity.Users;

public class DomainVOConverter {

	public static Product convertProdVOtoProd(ProductVO prodVO){
		Product product = new Product();
		product.setProductName(prodVO.getProductName());
		product.setQuantity(prodVO.getQuantity());
		return product;
	}  
	
	public static Users convertUserVotoUser(UserVO userVO){
		Users user= new Users();
		user.setName(userVO.getName());
		user.setEmail(userVO.getEmail());
		user.setAddress(userVO.getAddress());
		user.setPhoneNumber(userVO.getPhoneNumber());
		return user;
	}
	
	public static OrderDetails convertOrderDetailsVOtoOrderDetails(OrderDetailsVO orderdDetailsVO){
		OrderDetails orderDetails= new OrderDetails();
		orderDetails.setUser(orderdDetailsVO.getUser());
		orderDetails.setProduct(orderdDetailsVO.getProduct());
		orderDetails.setAmount(orderdDetailsVO.getAmount());
		orderdDetailsVO.setCreditCardNumber(orderdDetailsVO.getCreditCardNumber());
		orderDetails.setShippingAddress(orderdDetailsVO.getShippingAddress());
		return orderDetails;
	}
}
