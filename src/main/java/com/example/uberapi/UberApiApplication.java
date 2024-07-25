package com.example.uberapi;

import com.example.uberapi.entities.*;
import com.example.uberapi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UberApiApplication implements CommandLineRunner {
    @Autowired
    TaxiService taxiService;
    @Autowired
    DriverService driverService;
    @Autowired
    CarModelService carModelService;
    @Autowired
    ClientService clientService;
    @Autowired
    RideService rideService;
    public static void main(String[] args) {
        SpringApplication.run(UberApiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Client cLient = new Client();
        cLient.setPhoneNumber("0626485978");
        clientService.insertClient(cLient);




        CarModel carModel = new CarModel();
        carModel.setBrand("BMW");
        carModel.setModel("Galaxy");
        carModelService.insertCarModel(carModel);

        Driver driver = new Driver();
        driver.setName("Albert le taxi");
        driver.setLicenseNumber("APAIUGHOIH");
        driverService.insertDriver(driver);

        Taxi taxi = new Taxi();
        taxi.setCarModel(carModel);
        taxi.setDriver(driver);
        taxi.setTotalKm(12006);
        taxiService.insertTaxi(taxi);

        Ride ride = new Ride();
        ride.setClient(cLient);
        ride.setKm(5);
        ride.setTaxi(taxi);
        ride.setLatStart(0F);
        ride.setLatEnd(0F);
        ride.setLongEnd(0F);
        ride.setLongStart(0F);
        rideService.insertRide(ride);


    }
}
