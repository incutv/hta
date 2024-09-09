package com.example.settlementsys.scheduled;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.settlementsys.dto.Payments;
import com.example.settlementsys.mapper.PaymentRepository;
import com.example.settlementsys.mapper.SettlementRepository;
import com.example.settlementsys.service.PaymentRepositoryService;
import com.example.settlementsys.service.PaymentRepositoryServiceImple;
import com.example.settlementsys.service.SettlementRepositoryServiceImpl;
@ComponentScan
public class SettlementScheduledTesks {
	private long totlaAmount = 0;
		private PaymentRepositoryServiceImple paymentService;
		private SettlementRepositoryServiceImpl settlementService;
		long total = 0;
		
	//cron -> 주기적으로 실행할 작업의 주기를 설정 왼쪽부터 초 분 시 일 월 요일(특정 요일을 선택하지 않음 -> ?)
	@Scheduled(cron="10 0 0 0 0 ?")
	public void dailySettlement() {
		List<Payments> list =  paymentService.paySelect();
		list.forEach(p -> {
			total =+ p.getPayument_Amount();
		});
		settlementService.daySettlements(total);
		total = 0;
	}
}
