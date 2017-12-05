package com.example.OrderManagement.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.OrderManagement.DAO.OrderDetailsDAO;
import com.example.OrderManagement.DAO.ProductDAO;
import com.example.OrderManagement.POJO.OrderDetailsVO;
import com.example.OrderManagement.entity.OrderDetails;
import com.example.OrderManagement.entity.Product;
import com.example.OrderManagement.utilities.DomainVOConverter;

@Service
public class OrderServiceDetailsImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsDAO orderDetailsDAO;
	@Autowired
	ProductDAO productDAO;
	
	/**
	 *@Autowired
     *	PaymentClient() {
     *  PaymentAPI.apiKey = "XXXXXXXXXXXXXXXXX";
     *   }
	 */
	
	
	@Override
	public boolean checkInventory(String productId, int quantity) {
		Product product= productDAO.findOne(Long.parseLong(productId));
		if(product.getQuantity()>0)
			return true;
		return false;
	}

	public boolean verifyCard(String creditCardNumber, double amount){
		
		if(chargePayment(creditCardNumber, amount)){
			return true;
		}
		return false;
	}
	
	
	public boolean chargePayment(String creditCardNumber, double amount) {
		
		if(isValid(creditCardNumber)){
			amount= addAdditionalFee(amount);
			//Charge the card with the amount;
        	return true;
		}
		
		return false;
	}
	
	private boolean isValid(String CreditCardNumber){
		/**
		 * Call the 3rd party API for verification, for simplicity 
		 * the credit card number has been hard coded
		 */
		if(Long.parseLong(CreditCardNumber)==0000000000000000)
			return true;
		else
			return false;
	}
	
	private double addAdditionalFee(double amount){
		double additionalFee=amount*0.005;
		return amount+additionalFee;
	}
	@Override
	@Transactional
	public boolean placeOrder(OrderDetailsVO orderDetailsVO) throws Exception{
		if (verifyCard(Long.toString(orderDetailsVO.getCredit_card_number()),orderDetailsVO.getAmount())){
			OrderDetails orderDetails= DomainVOConverter.convertOrderDetailsVOtoOrderDetails(orderDetailsVO);
			OrderDetails orderDetailsReturned= orderDetailsDAO.save(orderDetails);
			if(orderDetailsReturned!=null){	
				sendEmail(orderDetailsReturned);
				return true;
			}
		}
		return false;
	}
	
	private void sendEmail(OrderDetails orderDetails) throws Exception{
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
