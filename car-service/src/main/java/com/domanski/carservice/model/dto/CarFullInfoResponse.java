package com.domanski.carservice.model.dto;

import com.domanski.carservice.client.dto.OwnerResponse;
import lombok.Builder;

@Builder
public record CarFullInfoResponse(CarResponse car,
                                  OwnerResponse owner) {
}
