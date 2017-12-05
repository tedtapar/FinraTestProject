package com.example.OrderManagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.OrderManagement.POJO.OrderDetailsVO;
import com.example.OrderManagement.service.OrderDetailsService;

@RestController
public class OrderDetailsController {
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody OrderDetailsVO orderDetailsVO , RedirectAttributes rediAtrb) throws Exception  {
		
			orderDetailsService.placeOrder(orderDetailsVO);
			rediAtrb.addFlashAttribute("successMsg", "The Order has been placed Successfully!");
			return "redirect:/main";
		
	}
	
}
