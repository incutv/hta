package com.example.settlementsys.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long id;                       // 결제 고유 ID
    private Long partnerId;                // 파트너 ID
    private Long userId;                   // 결제를 한 사용자 ID
    private Long orderId;                  // 관련 주문 ID
    private BigDecimal paymentAmount;      // 결제 금액
    private LocalDateTime paymentDate;              // 결제 일시
    private String paymentMethod;          // 결제 수단 (예: 카드, 계좌이체, 페이팔 등)
    private Long pgProviderId;             // PG사 ID (결제 대행사 식별자, 계좌이체의 경우 NULL)
    private String status;                 // 결제 상태 (예: Completed, Pending, Failed 등)
    private LocalDateTime createdAt;       // 레코드 생성 시각
    private LocalDateTime updatedAt;       // 레코드 업데이트 시각
}
