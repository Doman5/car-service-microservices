package com.domanski.carservice;

import com.domanski.carservice.client.OwnerClient;
import com.domanski.carservice.client.dto.OwnerResponse;
import com.domanski.carservice.exception.CarNoFoundException;
import com.domanski.carservice.model.Car;
import com.domanski.carservice.model.dto.CarFullInfoResponse;
import com.domanski.carservice.model.dto.CarRequest;
import com.domanski.carservice.model.dto.CarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final OwnerClient ownerClient;
    private final CarRepo carRepo;

    public List<CarResponse> getAllCars() {
        return carRepo.findAll().stream()
                .map(CarMapper::mapToCarResponse)
                .toList();
    }

    public CarFullInfoResponse getCar(Long id) {
        Car car = carRepo.findById(id)
                .orElseThrow(() -> new CarNoFoundException("Car with %d no found".formatted(id)));
        OwnerResponse carOwner = ownerClient.getCarOwner(car.getCarOwnerId());
        CarResponse carResponse = CarMapper.mapToCarResponse(car);
        return new CarFullInfoResponse(carResponse, carOwner);
    }

    public CarResponse saveCar(CarRequest carRequest) {
        Car carToSave = CarMapper.mapToCar(carRequest);
        Car savedCar = carRepo.save(carToSave);
        return CarMapper.mapToCarResponse(savedCar);
    }

    public List<CarResponse> getAllCarsByUserId(Long ownerId) {
        return carRepo.findAllByCarOwnerId(ownerId).stream()
                .map(CarMapper::mapToCarResponse)
                .toList();
    }
}
