package com.example.uberapi.services;

import com.example.uberapi.entities.Driver;
import com.example.uberapi.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DriverService{
    DriverRepository driverRepository;
    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }
    public List<Driver> getAllDrivers() {
      return driverRepository.findAll();
    };
    public void insertDriver(Driver driver) {
        driverRepository.save(driver);
    }
    public Driver findById(Long id) {
        if(driverRepository.findById(id).isPresent()){
            return driverRepository.findById(id).get();
        } else {
            return null;
        }
    }
}
