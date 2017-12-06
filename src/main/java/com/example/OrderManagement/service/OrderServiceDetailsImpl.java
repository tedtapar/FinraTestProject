package com.example.OrderManagement.service;





import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.OrderManagement.DAO.OrderDetailsDAO;
import com.example.OrderManagement.DAO.ProductDAO;
import com.example.OrderManagement.POJO.OrderDetailsVO;
import com.example.OrderManagement.entity.OrderDetails;
import com.example.OrderManagement.entity.Product;
import com.example.OrderManagement.exception.CreditCardException;
import com.example.OrderManagement.exception.EmailException;
import com.example.OrderManagement.exception.ProductException;
import com.example.OrderManagement.utilities.DomainVOConverter;

@Service
public class OrderServiceDetailsImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsDAO orderDetailsDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	ChargeService chargeService;
	@Autowired
	EmailService emailService;
	
	/**
	 *@Autowired
     *	PaymentClient() {
     *  PaymentAPI.apiKey = "XXXXXXXXXXXXXXXXX";
     *   }
	 */
	
	
	@Override
	public boolean checkInventory(String productId, int quantity) {
		Product product= productDAO.findOne(Long.parseLong(productId));
		if(product.getQuantity()>=quantity)
			return true;
		return false;
	}



	@Override
	@Transactional
	public void placeOrder(OrderDetailsVO orderDetailsVO) throws CreditCardException,ProductException,EmailException{
		OrderDetails orderDetails= DomainVOConverter.convertOrderDetailsVOtoOrderDetails(orderDetailsVO);
		if(checkInventory(Long.toString(orderDetails.getProduct().getProductId()),(int) orderDetails.getProduct().getQuantity() )){
			if (chargeService.chargePayment(orderDetails.getCredit_card_number(), orderDetails.getAmount()) ){	
				OrderDetails orderDetailsReturned= orderDetailsDAO.save(orderDetails);
				if(orderDetailsReturned!=null){	
					emailService.sendEmail(orderDetailsReturned.toString(), EmailService.to, EmailService.from);
				}
			} 
			else
				{throw new CreditCardException("Invalid Card!");}
		}
		else
			{throw new ProductException("Product Out of Stock");}
	}
	
	
}
