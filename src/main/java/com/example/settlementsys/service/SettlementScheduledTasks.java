package com.example.settlementsys.service;

import com.example.settlementsys.dto.Payment;
import com.example.settlementsys.mapper.PaymentMapper;
import com.example.settlementsys.mapper.SettlementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class SettlementScheduledTasks {
    private final PaymentMapper paymentMapper;

    private final SettlementMapper settlementMapper;

    @Autowired
    public SettlementScheduledTasks(PaymentMapper paymentMapper, SettlementMapper settlementMapper) {
        this.paymentMapper = paymentMapper;
        this.settlementMapper = settlementMapper;
    }
    // 매일 오전 3시 실행
    @Scheduled(cron = "0 * * * * ?")
    public void dailySettlement() {
        // 어제의 날짜를 가져옴
        LocalDate yesterday = LocalDate.now().minusDays(1);

        // 어제의 시작 시각 설정 (2024-09-05 00:00:00)
        LocalDateTime startDate = yesterday.atStartOfDay();

        // 어제의 끝 시각 설정 (2024-09-05 23:59:59)
        LocalDateTime endDate = yesterday.atTime(LocalTime.of(23, 59, 59));

        // select * from patments where  between #{startDate}  and #{endDate}

        // 해당 기간 동안의 결제 내역을 조회
        List<Payment> payments = paymentMapper.selectPaymentsBetweenDates(startDate, endDate);

        // 결과 처리 로직을 추가하세요.
        System.out.println("결제 내역: " + payments);


        System.out.println("크론 표현식을 사용해 특정 시간에 실행되는 작업");
    }
}
