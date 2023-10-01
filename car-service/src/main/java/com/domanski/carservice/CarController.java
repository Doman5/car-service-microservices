package com.domanski.carservice;

import com.domanski.carservice.model.dto.CarFullInfoResponse;
import com.domanski.carservice.model.dto.CarRequest;
import com.domanski.carservice.model.dto.CarResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/{id}")
    public ResponseEntity<CarFullInfoResponse> getCar(@PathVariable Long id) {
        CarFullInfoResponse response = carService.getCar(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CarResponse>> getAllCarsShortInfo() {
        List<CarResponse> allCars = carService.getAllCars();
        return ResponseEntity.ok(allCars);
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<List<CarResponse>> getAllCarsByUserId(@PathVariable Long id) {
        List<CarResponse> responses = carService.getAllCarsByUserId(id);
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<CarResponse> saveCar(@RequestBody @Valid CarRequest carRequest) {
        CarResponse carResponse = carService.saveCar(carRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carResponse);
    }
}
