package com.domanski.carownerservice.exception;

public class OwnerNoFoundException extends RuntimeException {
    public OwnerNoFoundException(String message) {
        super(message);
    }
}
