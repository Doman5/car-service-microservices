package com.domanski.carservice.client;

import com.domanski.carservice.client.dto.OwnerResponse;

public interface OwnerClient {
    OwnerResponse getCarOwner(Long id);
}
