package com.example.uberapi.services;

import com.example.uberapi.entities.CarModel;
import com.example.uberapi.repositories.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarModelService {
    CarModelRepository carModelRepository;
    @Autowired
    public CarModelService(CarModelRepository carModelRepository) {
        this.carModelRepository = carModelRepository;
    }
    public List<CarModel> getAllCarModels() {
        return carModelRepository.findAll();
    };
    public void insertCarModel(CarModel carModel) {
        carModelRepository.save(carModel);
    }
    public CarModel findById(Long id) {
        if(carModelRepository.findById(id).isPresent()){
            return carModelRepository.findById(id).get();
        } else {
            return null;
        }
    }

}
