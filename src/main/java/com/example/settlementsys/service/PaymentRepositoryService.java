package com.example.settlementsys.service;

import java.util.List;

import com.example.settlementsys.dto.Payments;

public interface PaymentRepositoryService {
	List<Payments> paySelect();
}
