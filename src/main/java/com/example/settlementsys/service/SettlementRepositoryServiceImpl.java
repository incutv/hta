package com.example.settlementsys.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.settlementsys.mapper.SettlementRepository;

@Service
public class SettlementRepositoryServiceImpl implements SettlementRepositoryService{
	private final SettlementRepository settlementRepository;
	@Autowired
	public  SettlementRepositoryServiceImpl(SettlementRepository settlementRepository) {
		this.settlementRepository = settlementRepository;
	}
	@Override
	public void daySettlements(long total_Amount) {
		
	}

}
