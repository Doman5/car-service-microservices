package com.domanski.carservice.model.dto;

public record CarRequest(
        String brand,
                         String model,
                         String vinNumber,
                         Integer power,
                         Long carOwnerId) {
}
