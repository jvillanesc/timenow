package com.poc.timeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TimeController {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/time")
    public Map<String, String> getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        Map<String, String> response = new LinkedHashMap<>();
        response.put("currentTime", now.format(FORMATTER));
        response.put("timezone", ZoneId.systemDefault().toString());
        response.put("iso8601", now.toString());
        return response;
    }
}
