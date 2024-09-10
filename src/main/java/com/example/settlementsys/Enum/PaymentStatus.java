package com.example.settlementsys.Enum;



import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

@Getter
public enum PaymentStatus {
	COMPLETED("COMPLETED"), PENDING("PENDING"), FAILED("FAILED");
	private final String status;
	@Autowired
	PaymentStatus(String status) {
		this.status = status;
	}
	public static PaymentStatus getPaymentStatus(String payStatus){
		for(PaymentStatus status : PaymentStatus.values()) {
			if(status.getStatus().equals(payStatus)) {
				return status;
			}
		}
		return null;
	} 
}
