package dev.kush.productcategory.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ExceptionMessage(
        String message,
        HttpStatus status,
        LocalDateTime timeStamp
) {
}
