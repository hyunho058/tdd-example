package com.example.tddexample.kiosk.unit.spring.api.comon.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public record ApiResponse<T>(int code,
                             HttpStatus status,
                             String message,
                             T data) {

    public ApiResponse(HttpStatus status, String message) {
        this(
                status.value(),
                status,
                message,
                null
        );
    }

    public ApiResponse(HttpStatus status, T data) {
        this(
                status.value(),
                status,
                status.name(),
                data
        );
    }
}
