package com.example.settlementsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.settlementsys.dto.Payments;
import com.example.settlementsys.mapper.PaymentMapper;
@Service
public class PaymentServiceImple implements PaymentService {
	private final PaymentMapper paymentRepository;
	@Autowired
	public PaymentServiceImple(PaymentMapper paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	@Override
	public  List<Payments> paySelect() {
		return paymentRepository.paySelect();
	}

}
