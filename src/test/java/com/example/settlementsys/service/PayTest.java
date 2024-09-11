package com.example.settlementsys.service;


import java.time.LocalDate;

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
	String dateString = LocalDate.now().minusMonths(1).toString();
	
	@Test
	public void daySettlementTest() {
		//12시 정산    엊그제 <정산날 <내일
		System.out.println(dateString);
		payService.paySelect(dateString).stream().forEach(p ->{
			if( SettlementsUtil.settlementDayCheck(p.getPayment_Date()) && p.getStatus().equals("COMPLETED")) {
				total += p.getPayment_Amount();
				System.out.println(p.getPayment_Amount());
			} else {
				System.out.println("no");
			}
			System.out.println(total);
			
		});
	}
	
}
