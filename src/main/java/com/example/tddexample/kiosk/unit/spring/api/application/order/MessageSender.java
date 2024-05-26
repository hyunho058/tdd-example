package com.example.tddexample.kiosk.unit.spring.api.application.order;

public interface MessageSender {
    boolean send(String from, String to, String subject, String content);
}
