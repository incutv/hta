package com.example.settlementsysutil;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SettlementsUtil {
	public static boolean settlementDayCheck(LocalDateTime createdAt) {
		//12시 정산    엊그제 <정산날 <내일
		LocalDate settlementTargetDay = LocalDate.now().minusDays(1); //정산날
		return createdAt.toLocalDate().isEqual(settlementTargetDay);
		
	}
}
