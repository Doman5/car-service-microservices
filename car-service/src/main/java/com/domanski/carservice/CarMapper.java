package com.domanski.carservice;

import com.domanski.carservice.model.dto.CarRequest;
import com.domanski.carservice.model.dto.CarResponse;
import com.domanski.carservice.model.Car;

public class CarMapper {


    public static CarResponse mapToCarResponse(Car car) {
        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .power(car.getPower())
                .vinNumber(car.getVinNumber())
                .build();
    }

    public static CarResponse mapToCarShortResponse(Car car) {
        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .power(car.getPower())
                .vinNumber(car.getVinNumber())
                .build();
    }

    public static Car mapToCar(CarRequest carRequest) {
        return Car.builder()
                .brand(carRequest.brand())
                .vinNumber(carRequest.vinNumber())
                .power(carRequest.power())
                .model(carRequest.model())
                .carOwnerId(carRequest.carOwnerId())
                .build();
    }
}
