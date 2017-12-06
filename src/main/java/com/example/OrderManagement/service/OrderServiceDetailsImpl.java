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
		if(checkInventory(Long.toString(orderDetails.getProduct().getProduct_id()),(int) orderDetails.getProduct().getQuantity() )){
			if (chargeService.chargePayment(orderDetails.getCredit_card_number(), orderDetails.getAmount()) ){	
				OrderDetails orderDetailsReturned= orderDetailsDAO.save(orderDetails);
				if(orderDetailsReturned!=null){	
					sendEmail(orderDetailsReturned);
				}
			} 
			else
				{throw new CreditCardException("Invalid Card!");}
		}
		else
			{throw new ProductException("Product Out of Stock");}
	}
	
	private void sendEmail(OrderDetails orderDetails) throws EmailException{
				/**
				 * MimeMessage message = sender.createMimeMessage();
				 * MimeMessageHelper helper = new MimeMessageHelper(message);
		         * helper.setTo("recipient-email@gmail.com");
		         * helper.setText(orderDetails);	
		         * helper.setSubject("Hi");
		         * sender.send(message);
				 */
		    }

}
