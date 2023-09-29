package com.domanski.carservice;

import com.domanski.carservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
    List<Car> findAllByCarOwnerId(Long carOwnerId);
}
