package com.example.uberapi.controllers;

import com.example.uberapi.entities.CarModel;
import com.example.uberapi.entities.DTO.TaxiDTO;
import com.example.uberapi.entities.Taxi;
import com.example.uberapi.services.CarModelService;
import com.example.uberapi.services.DriverService;
import com.example.uberapi.services.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxi")
@CrossOrigin(origins = "http://localhost:8081")
public class TaxiController {
    TaxiService taxiService;
    CarModelService carModelService;
    DriverService driverService;
    @Autowired

    public TaxiController(DriverService driverService,TaxiService taxiService, CarModelService carModelService) {
        this.taxiService = taxiService;
        this.carModelService = carModelService;
        this.driverService = driverService;
    }
    @GetMapping("/")
    public List<Taxi> index(){
        return taxiService.getAllTaxi();
    };
    @PostMapping("/new")
    public ResponseEntity<Taxi> createDriver(@RequestBody TaxiDTO taxiDTO) {
        try {
            Taxi taxiI = new Taxi();
            taxiI.setTotalKm(taxiDTO.getTotalKm());
            taxiI.setCarModel(carModelService.findById(taxiDTO.getCarModelId()));
            taxiI.setDriver(driverService.findById(taxiDTO.getDriverId()));
            taxiService.insertTaxi(taxiI);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
