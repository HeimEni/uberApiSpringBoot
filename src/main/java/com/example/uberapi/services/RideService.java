package com.example.uberapi.services;

import com.example.uberapi.entities.Ride;
import com.example.uberapi.repositories.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RideService {
    RideRepository rideRepository;
    @Autowired

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }
    public void insertRide(Ride ride) {
        rideRepository.save(ride);
    }
}
