package com.domanski.carownerservice;

import com.domanski.carownerservice.client.CarServiceClient;
import com.domanski.carownerservice.model.dto.CarOwnerRequest;
import com.domanski.carownerservice.model.dto.CarOwnerResponse;
import com.domanski.carownerservice.exception.OwnerNoFoundException;
import com.domanski.carownerservice.model.CarOwner;
import com.domanski.carownerservice.model.dto.CarOwnerWithCarsResponse;
import com.domanski.carownerservice.model.dto.CarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarOwnerService {

    private final CarOwnerRepo carOwnerRepo;
    private final CarServiceClient carServiceClient;

    public CarOwnerResponse getCarOwner(Long id) {
        CarOwner carOwner = carOwnerRepo.findById(id)
                .orElseThrow(() -> new OwnerNoFoundException("Car owner with id: %d no exist".formatted(id)));
        return CarOwnerMapper.mapToCarOwnerResponse(carOwner);
    }

    public CarOwnerResponse saveCarOwner(CarOwnerRequest carOwnerRequest) {
        CarOwner ownerToSave = CarOwnerMapper.mapToCarOwner(carOwnerRequest);
        CarOwner savedOwner = carOwnerRepo.save(ownerToSave);
        return CarOwnerMapper.mapToCarOwnerResponse(savedOwner);
    }

    public CarOwnerResponse updateCarOwner(Long id, CarOwnerRequest ownerEditRequest) {
        CarOwner oldOwner = carOwnerRepo.findById(id)
                .orElseThrow(() -> new OwnerNoFoundException("Car owner with id: %d no exist".formatted(id)));
        if(checkIfOwnerAreDifferent(ownerEditRequest, oldOwner)) {
            CarOwner ownerToSave = prepareUpdatedOwner(id, ownerEditRequest);
            CarOwner savedOwner = carOwnerRepo.save(ownerToSave);
            return CarOwnerMapper.mapToCarOwnerResponse(savedOwner);
        }
        return CarOwnerMapper.mapToCarOwnerResponse(oldOwner);
    }

    private static CarOwner prepareUpdatedOwner(Long id, CarOwnerRequest ownerEditRequest) {
        CarOwner ownerToSave = CarOwnerMapper.mapToCarOwner(ownerEditRequest);
        ownerToSave.setId(id);
        return ownerToSave;
    }


    public CarOwnerWithCarsResponse getUsersCars(Long id) {
        CarOwner owner = carOwnerRepo.findById(id)
                .orElseThrow(() -> new OwnerNoFoundException("Car owner with id: %d no exist".formatted(id)));
        List<CarResponse> usersCars = carServiceClient.getCarsByUserId(id);
        return prepareCarOwnerWithCarsResponse(owner, usersCars);
    }

    private boolean checkIfOwnerAreDifferent(CarOwnerRequest newOwner, CarOwner oldOwner) {
        CarOwner carOwner = CarOwnerMapper.mapToCarOwner(newOwner);
        return !oldOwner.equals(carOwner);
    }

    private CarOwnerWithCarsResponse prepareCarOwnerWithCarsResponse(CarOwner owner, List<CarResponse> usersCars) {
        return CarOwnerWithCarsResponse.builder()
                .name(owner.getName())
                .surname(owner.getSurname())
                .email(owner.getEmail())
                .phone(owner.getPhone())
                .cars(usersCars)
                .build();
    }
}
