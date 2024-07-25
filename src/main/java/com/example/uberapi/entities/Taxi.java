package com.example.uberapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Taxi {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="driver_id", nullable = false)
    private Driver driver;
    @ManyToOne
    @JoinColumn(name="car_model_id", nullable = false)
    private CarModel carModel;
    private Integer totalKm;
}
