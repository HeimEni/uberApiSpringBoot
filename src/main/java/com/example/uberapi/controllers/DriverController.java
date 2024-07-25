package com.example.uberapi.controllers;

import com.example.uberapi.entities.Driver;
import com.example.uberapi.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/driver")
@CrossOrigin(origins = "http://localhost:8081")

public class DriverController {
    private DriverService driverService;
    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/")
    public List<Driver> getDriver() {
        return driverService.getAllDrivers();
    }
}
