package com.example.uberapi.services;

import com.example.uberapi.entities.Taxi;
import com.example.uberapi.repositories.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TaxiService{
    TaxiRepository taxiRepository;
    @Autowired
    public TaxiService(TaxiRepository taxiRepository) {
        this.taxiRepository = taxiRepository;
    }

    public List<Taxi> getAllTaxi(){
        return taxiRepository.findAll();
    }
    public Taxi findByTaxiId(long taxiId){
        if(taxiRepository.findById(taxiId).isPresent())
            return taxiRepository.findById(taxiId).get();
        return null;
    }
    public void insertTaxi(Taxi taxi){
        taxiRepository.save(taxi);
    };
}
