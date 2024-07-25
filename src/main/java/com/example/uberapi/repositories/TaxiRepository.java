package com.example.uberapi.repositories;

import com.example.uberapi.entities.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Taxi, Long> {
}
