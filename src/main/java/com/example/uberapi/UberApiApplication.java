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
        cLient.setPhoneNumber("06458948");
        cLient.setName("Jeanne d'Arc");
        clientService.insertClient(cLient);

        Client cLient2 = new Client();
        cLient2.setPhoneNumber("06597846");
        cLient2.setName("Louis XIV");
        clientService.insertClient(cLient2);




        CarModel carModel = new CarModel();
        carModel.setBrand("BMW");
        carModel.setModel("M5");
        carModelService.insertCarModel(carModel);

        CarModel carModel2 = new CarModel();
        carModel2.setBrand("Renault");
        carModel2.setModel("Clio");
        carModelService.insertCarModel(carModel2);

        CarModel carModel3 = new CarModel();
        carModel3.setBrand("Mercedes");
        carModel3.setModel("Classe A");
        carModelService.insertCarModel(carModel3);

        Driver driver = new Driver();
        driver.setName("Albert Jesus");
        driver.setLicenseNumber("LicenseNumber#1");
        driverService.insertDriver(driver);

        Driver driver2 = new Driver();
        driver2.setName("Jean le feutre");
        driver2.setLicenseNumber("LicenseNumber#1");
        driverService.insertDriver(driver2);

        Taxi taxi = new Taxi();
        taxi.setCarModel(carModel);
        taxi.setDriver(driver);
        taxi.setTotalKm(12006);
        taxiService.insertTaxi(taxi);

        Taxi taxi2 = new Taxi();
        taxi2.setCarModel(carModel2);
        taxi2.setDriver(driver2);
        taxi2.setTotalKm(11056);
        taxiService.insertTaxi(taxi2);

        Ride ride = new Ride();
        ride.setClient(cLient);
        ride.setKm(5);
        ride.setTaxi(taxi);
        ride.setLatStart(0F);
        ride.setLatEnd(0F);
        ride.setLongEnd(0F);
        ride.setLongStart(0F);
        rideService.insertRide(ride);

        Ride ride2 = new Ride();
        ride2.setClient(cLient);
        ride2.setKm(5);
        ride2.setTaxi(taxi2);
        ride2.setLatStart(0F);
        ride2.setLatEnd(0F);
        ride2.setLongEnd(0F);
        ride2.setLongStart(0F);
        rideService.insertRide(ride2);


    }
}
