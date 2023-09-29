package com.domanski.carservice.model.dto;

import lombok.Builder;

@Builder
public record CarResponse(Long id,
                          String brand,
                          String model,
                          String vinNumber,
                          Integer power) {
}
