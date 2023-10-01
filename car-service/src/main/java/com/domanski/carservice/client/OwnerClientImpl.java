package com.domanski.carservice.client;

import com.domanski.carservice.client.dto.OwnerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Component
public class OwnerClientImpl implements OwnerClient{

    private final WebClient webClient;

    @Override
    public OwnerResponse getCarOwner(Long id) {
        return webClient.get().uri("http://localhost:9191/owners/" + id)
                .retrieve()
                .bodyToMono(OwnerResponse.class)
                .block();
    }
}
