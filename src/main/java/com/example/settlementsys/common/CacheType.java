package com.example.settlementsys.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CacheType {
    NOTICE_FINDALL("NoticeMapper.findAll", 10, 10000);

    private final String cacheName;
    private final int expiredAfterWrite;
    private final int maximumSize;
}