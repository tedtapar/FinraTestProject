package com.example.OrderManagement.service;

import java.math.BigDecimal;

public interface ChargeService {
	 boolean chargePayment(String creditCardNumber, BigDecimal amount);
}
