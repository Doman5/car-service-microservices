package com.domanski.carownerservice.model.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CarOwnerWithCarsResponse(String name,
                                       String surname,
                                       String email,
                                       String phone,
                                       List<CarResponse> cars) {
}
