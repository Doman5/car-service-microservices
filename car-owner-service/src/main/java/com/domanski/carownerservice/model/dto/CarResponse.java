package com.domanski.carownerservice.model.dto;

public record CarResponse(
        Long id,
        String brand,
        String model,
        String vinNumber,
        Integer power) {
}
