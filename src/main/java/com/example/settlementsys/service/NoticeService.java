package com.example.settlementsys.service;

import com.example.settlementsys.dto.Notice;

import java.util.List;


public interface NoticeService {
    List<Notice> getAllNotices();

    List<Notice> getTop10Views();
}
