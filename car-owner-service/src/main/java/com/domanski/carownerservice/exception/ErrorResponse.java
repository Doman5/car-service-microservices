package com.domanski.carownerservice.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ErrorResponse(String message, HttpStatus status) {
}
