package com.example.OrderManagement;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.any;
import java.math.BigDecimal;
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
import com.example.OrderManagement.POJO.OrderDetailsVO;
import com.example.OrderManagement.entity.Product;
import com.example.OrderManagement.entity.Users;
import com.example.OrderManagement.service.ChargeService;
import com.example.OrderManagement.service.OrderServiceDetailsImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderManagementApplicationTests {
	@Mock
	ProductDAO productDAO;
	
	@Mock
	OrderDetailsDAO ordDAO;
	
	@Mock
	ChargeService chargeService ;
	
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
		ordDetails.setShippingAddress(shipping_address);
		ordDetails.setAmount(amount);
		ordDetails.setCreditCardNumber(credit_card_number);
		product=new Product(1,"xyz",20);
		user=new Users(1,"Ted","ted@xyz.com","1343243245","Dulles");
		ordDetails.setProduct(product);
		ordDetails.setUser(user);
		
	}
	
	@Test
	public void checkInvetoryTestAvailable() {	
		when(productDAO.findOne(product.getProductId())).thenReturn(product);
		Assert.assertTrue(ordService.checkInventory(Long.toString(product.getProductId()), 10));
	}

	@Test
	public void checkInvetoryTestNotAvailable() {	
		when(productDAO.findOne(product.getProductId())).thenReturn(product);
		Assert.assertFalse(ordService.checkInventory(Long.toString(product.getProductId()), 30));
	}
	
	
	@Test(expected = Test.None.class)
	public void placeOrderTest() throws Exception {	
		when(productDAO.findOne(product.getProductId())).thenReturn(product);
		when(chargeService.chargePayment(anyString(),any(BigDecimal.class))).thenReturn(true);
	    ordService.placeOrder(ordDetails);
	}
	
	
	
	
}
