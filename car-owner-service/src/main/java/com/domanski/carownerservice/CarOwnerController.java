package com.domanski.carownerservice;

import com.domanski.carownerservice.model.dto.CarOwnerRequest;
import com.domanski.carownerservice.model.dto.CarOwnerResponse;
import com.domanski.carownerservice.model.dto.CarOwnerWithCarsResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owners")
public class CarOwnerController {

    private final CarOwnerService ownerService;

    @GetMapping("/{id}")
    public ResponseEntity<CarOwnerResponse> getOwnerById(@PathVariable Long id) {
        CarOwnerResponse response = ownerService.getCarOwner(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CarOwnerResponse> postOwner(@RequestBody @Valid CarOwnerRequest request) {
        CarOwnerResponse response = ownerService.saveCarOwner(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarOwnerResponse> updateOwner(@PathVariable Long id, @RequestBody @Valid CarOwnerRequest request) {
        CarOwnerResponse response = ownerService.updateCarOwner(id, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/cars")
    public ResponseEntity<CarOwnerWithCarsResponse> getUsersCars(@PathVariable Long id) {
        CarOwnerWithCarsResponse response = ownerService.getUsersCars(id);
        return ResponseEntity.ok(response);
    }
}
