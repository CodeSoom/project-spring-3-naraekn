package com.naraekn.ref.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 서버의 상태를 체크하는 HTTP 요청을 처리합니다.
 */
@RestController
@RequestMapping("/health-check")
public class HealthCheckController {
    /**
     * 상태 체크를 요청한 시간을 리턴합니다.
     * @return 요청 시간
     */
    @GetMapping
    String healthCheck() {
        Date dateTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        return formatter.format(dateTime);
    }
}
