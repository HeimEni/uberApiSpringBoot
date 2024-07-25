package com.example.uberapi.repositories;

import com.example.uberapi.entities.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}
