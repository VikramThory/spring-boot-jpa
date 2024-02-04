package com.vikram.singh.springbootjpa.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.Map;

public record ValidatorExceptionModel(Map<String, String> message, HttpStatus httpStatus, ZonedDateTime timestamp) {
}
