package com.example.settlementsys.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Settlements {
	private long id;
	private int partner_Id;
	private double total_Amount;
	private String status;
	private LocalDateTime time;
	private LocalDateTime created_At;
	private LocalDateTime updated_At;
	
	public LocalDateTime getCreatedAt() {
        return created_At;
    }
}
