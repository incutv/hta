package com.example.settlementsys.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Settlement {
    private Long id;                       // 정산 고유 ID
    private Long partnerId;             // 정산이 관련된 파트너 ID
    private BigDecimal totalAmount;        // 총 정산 금액
    private String status;                 // 정산 상태 (예: pending, completed)
    private LocalDate paymentDate;         // 거래 일자 (시간만)
    private LocalDateTime createdAt;       // 레코드 생성 시각
    private LocalDateTime updatedAt;       // 레코드 업데이트 시각

    // 정적 팩토리 메서드
    public static Settlement create(Long partnerId, BigDecimal totalAmount, LocalDate paymentDate) {
        Settlement settlement = new Settlement();
        settlement.setPartnerId(partnerId);
        settlement.setTotalAmount(totalAmount);
        settlement.setStatus("completed");
        settlement.setPaymentDate(paymentDate);
        settlement.setCreatedAt(LocalDateTime.now());
        settlement.setUpdatedAt(LocalDateTime.now());
        return settlement;
    }
}
