package com.domanski.carownerservice;

import com.domanski.carownerservice.model.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOwnerRepo extends JpaRepository<CarOwner,Long> {
}
