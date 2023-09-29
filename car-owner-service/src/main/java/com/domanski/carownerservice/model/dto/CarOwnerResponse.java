package com.domanski.carownerservice.model.dto;

import lombok.Builder;

@Builder
public record CarOwnerResponse(String name,
                               String surname,
                               String email,
                               String phone) {
}
