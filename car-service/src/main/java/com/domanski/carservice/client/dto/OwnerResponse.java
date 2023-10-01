package com.domanski.carservice.client.dto;

public record OwnerResponse(String name,
                            String surname,
                            String phone,
                            String email) {
}
