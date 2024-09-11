package com.example.settlementsys.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.settlementsys.dto.Payments;

import java.util.List;

@Mapper
public interface PaymentMapper {
	  public List<Payments> paySelect(String dateString);
}
