package com.example.settlementsys.controller;

import com.example.settlementsys.dto.Notice;
import com.example.settlementsys.dto.Payments;
import com.example.settlementsys.mapper.PaymentMapper;
import com.example.settlementsys.service.NoticeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/demo")
public class DemoController {
    private final NoticeService noticeService;
    private final PaymentMapper paymentRepository;

    public DemoController(NoticeService noticeService,PaymentMapper paymentRepository){
        this.noticeService=noticeService;
        this.paymentRepository = paymentRepository;
    }

//    @GetMapping("")
//    public ResponseEntity<Object> findAll() {
//        List<Notice> notices = noticeService.getAllNotices();
//        return new ResponseEntity<>(notices, HttpStatus.OK);
//        List<Payments> payments = paymentRepository.paySelect();
//        return new ResponseEntity<>(payments, HttpStatus.OK);
//    }

    @GetMapping("/top10Views")
    public ResponseEntity<Object> findTop10Views() {
        List<Notice> notices = noticeService.getTop10Views();
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }
}
