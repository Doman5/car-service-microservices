package com.domanski.carownerservice;

import com.domanski.carownerservice.model.CarOwner;
import com.domanski.carownerservice.model.dto.CarOwnerRequest;
import com.domanski.carownerservice.model.dto.CarOwnerResponse;

public class CarOwnerMapper {
    public static CarOwnerResponse mapToCarOwnerResponse(CarOwner carOwner) {
        return CarOwnerResponse.builder()
                .name(carOwner.getName())
                .surname(carOwner.getSurname())
                .email(carOwner.getEmail())
                .phone(carOwner.getPhone())
                .build();
    }

    public static CarOwner mapToCarOwner(CarOwnerRequest carOwnerRequest) {
        return CarOwner.builder()
                .name(carOwnerRequest.name())
                .surname(carOwnerRequest.surname())
                .email(carOwnerRequest.email())
                .phone(carOwnerRequest.phone())
                .build();
    }
}
