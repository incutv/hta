package com.example.settlementsys.mapper;



import org.apache.ibatis.annotations.Mapper;

import com.example.settlementsys.dto.Settlements;


@Mapper
public interface SettlementRepository {
	public Settlements daySettlements(long total_Amount);
}
