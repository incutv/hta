package com.example.settlementsys.mapper;

import com.example.settlementsys.dto.Settlement;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SettlementMapper {
    public void insertSettlement(Settlement settlement);
}
