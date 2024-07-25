package com.example.uberapi.controllers;

import com.example.uberapi.entities.Client;
import com.example.uberapi.entities.DTO.CarModelDTO;
import com.example.uberapi.services.CarModelService;
import com.example.uberapi.entities.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carModel")
@CrossOrigin(origins = "http://localhost:8081")

public class CarModelController {
    private CarModelService carModelService;
    @Autowired
    public CarModelController(CarModelService carModelService) {
        this.carModelService = carModelService;
    }
    @GetMapping("/")
    public List<CarModel> getAllCarModels() {
        return carModelService.getAllCarModels();
    }
    @PostMapping("/new")
    public ResponseEntity<CarModel> createCarModel(@RequestBody CarModelDTO carModelDTO) {
        try {
            CarModel carModel = new CarModel();
            carModel.setModel(carModelDTO.getModel());
            carModel.setBrand(carModelDTO.getMarque());
            carModelService.insertCarModel(carModel);
            System.out.println(carModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
