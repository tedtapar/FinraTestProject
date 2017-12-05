package com.example.OrderManagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.OrderManagement.POJO.OrderDetailsVO;
import com.example.OrderManagement.service.OrderDetailsService;
import com.example.OrderManagement.utilities.CustomErrorType;

@RestController
public class OrderDetailsController {
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<?> placeOrder(@RequestBody OrderDetailsVO orderDetailsVO ) throws Exception  {
		
			if(orderDetailsService.placeOrder(orderDetailsVO)){
				return new ResponseEntity<String>("Order has been placed!",HttpStatus.OK);
			}
			else{
				return new ResponseEntity(new CustomErrorType("Unable to place the Order!"), HttpStatus.INTERNAL_SERVER_ERROR);
		    }
     }	
}
