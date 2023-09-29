package com.domanski.carownerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CarOwnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarOwnerServiceApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		return WebClient.create("http://localhost:9191/cars");
	}

}
