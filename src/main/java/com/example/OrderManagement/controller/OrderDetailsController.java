package com.example.OrderManagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.OrderManagement.POJO.OrderDetailsVO;
import com.example.OrderManagement.service.OrderDetailsService;


@RestController
public class OrderDetailsController {
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<?> placeOrder(@RequestBody OrderDetailsVO orderDetailsVO ) throws Exception  {
		
			orderDetailsService.placeOrder(orderDetailsVO);
				return new ResponseEntity<String>("Order has been placed!",HttpStatus.OK);
     }	
	
	
}
