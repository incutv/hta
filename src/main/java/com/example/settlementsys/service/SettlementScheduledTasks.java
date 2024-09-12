package com.example.settlementsys.service;

import com.example.settlementsys.dto.Payment;
import com.example.settlementsys.dto.Settlement;
import com.example.settlementsys.mapper.PaymentMapper;
import com.example.settlementsys.mapper.SettlementMapper;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

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
    //@SchedulerLock(name = "ScheduledTask_run")
    public void dailySettlement() {
        // 어제의 날짜를 가져옴
        LocalDate yesterday = LocalDate.now().minusDays(1);
        // 어제의 시작 시각 설정 (2024-09-05 00:00:00)
        LocalDateTime startDate = yesterday.atStartOfDay();
        // 어제의 끝 시각 설정 (2024-09-05 23:59:59)
        LocalDateTime endDate = yesterday.atTime(LocalTime.of(23, 59, 59));

        // 해당 기간 동안의 결제 내역 조회 및 집계
        Map<Long, BigDecimal> settlementMap = getSettlementMap(startDate, endDate);

        // 집계된 데이터를 처리하고 데이터베이스에 저장
        processSettlements(settlementMap, startDate.toLocalDate());
    }

    /*@Scheduled(cron = "0 * * * * ?")
    @SchedulerLock(name = "ScheduledTask_run")
    public void dailySettlement1() {
        // 어제의 날짜를 가져옴
        LocalDate yesterday = LocalDate.now().minusDays(1);
        // 어제의 시작 시각 설정 (2024-09-05 00:00:00)
        LocalDateTime startDate = yesterday.atStartOfDay();
        // 어제의 끝 시각 설정 (2024-09-05 23:59:59)
        LocalDateTime endDate = yesterday.atTime(LocalTime.of(23, 59, 59));

        // 해당 기간 동안의 결제 내역 조회 및 집계
        Map<Long, BigDecimal> settlementMap = getSettlementMap(startDate, endDate);

        // 집계된 데이터를 처리하고 데이터베이스에 저장
        processSettlements(settlementMap, startDate.toLocalDate());
    }*/

    private Map<Long, BigDecimal> getSettlementMap(LocalDateTime startDate, LocalDateTime endDate) {
        List<Payment> payments = paymentMapper.selectPaymentsBetweenDates(startDate, endDate);
        return payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getPartnerId,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Payment::getPaymentAmount,
                                BigDecimal::add
                        )
                ));
    }

    private void processSettlements(Map<Long, BigDecimal> settlementMap, LocalDate paymentDate) {
        ForkJoinPool customThreadPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        try {
            customThreadPool.submit(() -> settlementMap.forEach((partnerId, totalAmount) -> {
                Settlement settlement = Settlement.create(partnerId, totalAmount, paymentDate);
                settlementMapper.insertSettlement(settlement);
            })).get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            customThreadPool.shutdown();
        }
    }



}
