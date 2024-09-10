package com.example.settlementsys.mapper;

import com.example.settlementsys.dto.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface PaymentMapper {
    List<Payment> selectPaymentsBetweenDates(@Param("startDate") LocalDateTime startDate,
                                             @Param("endDate") LocalDateTime endDate);
}
