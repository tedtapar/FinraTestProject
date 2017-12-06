package com.example.OrderManagement;



import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.OrderManagement.DAO.OrderDetailsDAO;
import com.example.OrderManagement.DAO.ProductDAO;
import com.example.OrderManagement.DAO.UserDAO;
import com.example.OrderManagement.POJO.OrderDetailsVO;
import com.example.OrderManagement.controller.OrderDetailsController;
import com.example.OrderManagement.entity.Product;
import com.example.OrderManagement.entity.Users;
import com.example.OrderManagement.service.ChargeService;
import com.example.OrderManagement.service.ChargeServiceImpl;
import com.example.OrderManagement.service.OrderServiceDetailsImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderManagementApplicationTests {
	@Mock
	ProductDAO productDAO;
	
	@Mock
	OrderDetailsDAO ordDAO;
	
	@Mock
	ChargeService chargeService;
	
	@InjectMocks
	OrderServiceDetailsImpl ordService;

	private OrderDetailsVO ordDetails;
	private String shipping_address="Boston";
	private BigDecimal amount=new BigDecimal("100");
	private Product product;
	private Users user;
	private String credit_card_number="1111111111111111";
	
	@Before
	public void initTest(){
		MockitoAnnotations.initMocks(this);
		ordDetails= new OrderDetailsVO();
		ordDetails.setShipping_address(shipping_address);
		ordDetails.setAmount(amount);
		ordDetails.setCredit_card_number(credit_card_number);
		product=new Product(1,"xyz",20);
		user=new Users(1,"Ted","ted@xyz.com","1343243245","Dulles");
		ordDetails.setProduct(product);
		ordDetails.setUser(user);
		
	}
	
	@Test
	public void checkInvetoryTestAvailable() {	
		when(productDAO.findOne(product.getProduct_id())).thenReturn(product);
		Assert.assertTrue(ordService.checkInventory(Long.toString(product.getProduct_id()), 10));
	}

	@Test
	public void checkInvetoryTestNotAvailable() {	
		when(productDAO.findOne(product.getProduct_id())).thenReturn(product);
		Assert.assertFalse(ordService.checkInventory(Long.toString(product.getProduct_id()), 30));
	}
	
	
	@Test(expected = Test.None.class)
	public void placeOrderTest() throws Exception {	
		when(productDAO.findOne(product.getProduct_id())).thenReturn(product);
		when(chargeService.chargePayment(credit_card_number,amount)).thenReturn(true);
	    ordService.placeOrder(ordDetails);
	}
	
	
	
	
}
