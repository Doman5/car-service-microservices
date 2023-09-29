package com.domanski.carownerservice.client;

import com.domanski.carownerservice.model.dto.CarResponse;

import java.util.List;

public interface CarServiceClient {
    List<CarResponse> getCarsByUserId(Long id);
}
