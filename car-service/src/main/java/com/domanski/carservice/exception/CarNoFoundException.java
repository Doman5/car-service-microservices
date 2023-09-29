package com.domanski.carservice.exception;

public class CarNoFoundException extends RuntimeException {
    public CarNoFoundException(String message) {
        super(message);
    }
}
