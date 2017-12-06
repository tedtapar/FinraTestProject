package com.example.OrderManagement.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
@Service
public class ChargeServiceImpl implements ChargeService {

	@Override
	public boolean chargePayment(String creditCardNumber, BigDecimal amount) {
		return true;
	}

}
