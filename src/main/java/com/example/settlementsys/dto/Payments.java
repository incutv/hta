package com.example.settlementsys.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Payments {
    private long id;
    private long partner_Id;
    private long user_Id;
    private long order_Id;
    private double payment_Amount;
    private LocalDateTime payment_Date;
    private String payment_Method;
    private long pgprovider_Id;
    private String status;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;
    
    
    public LocalDateTime getCreatedAt() {
        return created_At;
    }

}
