package com.example.settlementsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.settlementsys.dto.Payments;
import com.example.settlementsys.mapper.PaymentRepository;
@Service
public class PaymentRepositoryServiceImple implements PaymentRepositoryService {
	private final PaymentRepository paymentRepository;
	@Autowired
	public PaymentRepositoryServiceImple(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	@Override
	public  List<Payments> paySelect() {
		return paymentRepository.paySelect();
	}

}
