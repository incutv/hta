package com.example.settlementsys.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.settlementsys.Enum.PaymentStatus;
import com.example.settlementsysutil.SettlementsUtil;

@SpringBootTest
@Transactional
public class PayTest {
	@Autowired private PaymentServiceImple payService;
	@Autowired private SettlementServiceImpl settlService;
	private double total = 0;
	@Test
	public void daySettlementTest() {
		//12시 정산    엊그제 <정산날 <내일
		payService.paySelect().stream().forEach(p ->{
			PaymentStatus.getPaymentStatus("COMPLETED").equals(p.getStatus());
//			System.out.println(PaymentStatus.getPaymentStatus("COMPLETED").equals(p.getStatus()));
			if( SettlementsUtil.settlementDayCheck(p.getCreated_At())) {
				total =+ p.getPayment_Amount();
				System.out.println(p.getPayment_Amount());
				System.out.println(total);
			}
		});
	}
	
}
