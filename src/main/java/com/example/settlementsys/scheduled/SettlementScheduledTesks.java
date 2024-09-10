package com.example.settlementsys.scheduled;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.settlementsys.dto.Payments;
import com.example.settlementsys.mapper.PaymentMapper;
import com.example.settlementsys.mapper.SettlementMapper;
import com.example.settlementsys.service.PaymentService;
import com.example.settlementsys.service.PaymentServiceImple;
import com.example.settlementsys.service.SettlementServiceImpl;
@ComponentScan
public class SettlementScheduledTesks {
		private PaymentServiceImple paymentService;
		private SettlementServiceImpl settlementService;
		double total = 0;
		
	//cron -> 주기적으로 실행할 작업의 주기를 설정 왼쪽부터 초 분 시 일 월 요일(특정 요일을 선택하지 않음 -> ?)
		//cron =  " 0 59 23 0 0 ?" 
	@Scheduled(cron="10 0 0 0 0 ?")
	public void dailySettlement() {
	}
}
