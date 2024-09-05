package com.example.settlementsys.service;

import com.example.settlementsys.dto.Notice;
import com.example.settlementsys.mapper.NoticeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper noticeReadMapper;

    @Autowired
    public NoticeServiceImpl(NoticeMapper noticeReadMapper) {
        this.noticeReadMapper = noticeReadMapper;
    }

    @Override
    public List<Notice> getAllNotices() {
        return noticeReadMapper.findAll();
    }

    @Override
    public List<Notice> getTop10Views() {
        // 구현 해야함.. 내부 로직은 없음
        return Collections.emptyList();
    }
}
