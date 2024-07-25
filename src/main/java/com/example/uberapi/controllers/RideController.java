package com.example.uberapi.controllers;

import com.example.uberapi.entities.DTO.RideDTO;
import com.example.uberapi.entities.Ride;
import com.example.uberapi.entities.Taxi;
import com.example.uberapi.services.ClientService;
import com.example.uberapi.services.RideService;
import com.example.uberapi.services.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ride")
@CrossOrigin(origins = "http://localhost:8081")

public class RideController {
    private RideService rideService;
    private TaxiService taxiService;
    private ClientService clientService;
    @Autowired
    public RideController(ClientService clientService,TaxiService taxiService,RideService rideService) {
        this.rideService = rideService;
        this.taxiService = taxiService;
        this.clientService = clientService;
    }
    @GetMapping("/")
    public List<Ride> getRides() {
        return rideService.getAllRides();
    }
    @PostMapping("/new")
    public ResponseEntity<Ride> createRide(@RequestBody RideDTO rideDTO) {
        try {
            Ride ride = new Ride();
            ride.setKm(rideDTO.getKm());
            ride.setTaxi(taxiService.findByTaxiId(rideDTO.getTaxiId()));
            ride.setClient(clientService.getClientById(rideDTO.getClientId()));
            ride.setLongEnd(rideDTO.getLongEnd());
            ride.setLongStart(rideDTO.getLongStart());
            ride.setLatEnd(rideDTO.getLatEnd());
            ride.setLatStart(rideDTO.getLatStart());
            rideService.insertRide(ride);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
