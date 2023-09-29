package com.domanski.carservice.model;

import lombok.Builder;

@Builder
public class CarOwner {
    private String name;
    private String surname;
    private String phone;
    private String email;
}
