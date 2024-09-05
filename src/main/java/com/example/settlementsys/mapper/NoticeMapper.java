package com.example.settlementsys.mapper;

import com.example.settlementsys.dto.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    public List<Notice> findAll();

    public List<Notice> findTop10Views();


}
