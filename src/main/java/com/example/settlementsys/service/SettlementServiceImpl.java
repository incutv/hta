package com.example.settlementsys.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.settlementsys.mapper.SettlementMapper;

@Service
public class SettlementServiceImpl implements SettlementService{
	private final SettlementMapper settlementRepository;
	@Autowired
	public  SettlementServiceImpl(SettlementMapper settlementRepository) {
		this.settlementRepository = settlementRepository;
	}
	@Override
	public void daySettlements(long total_Amount) {
		
	}

}
