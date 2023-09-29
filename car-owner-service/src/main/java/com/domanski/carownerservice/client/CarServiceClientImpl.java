package com.domanski.carownerservice.client;

import com.domanski.carownerservice.model.dto.CarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarServiceClientImpl implements CarServiceClient {

    private final WebClient webClient;

    @Override
    public List<CarResponse> getCarsByUserId(Long id) {
        return webClient.get().uri("/owner/" + id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CarResponse>>() {})
                .block();
    }
}
