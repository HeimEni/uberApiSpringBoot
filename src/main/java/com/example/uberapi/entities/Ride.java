package com.example.uberapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ride {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="taxi_id", nullable = false)
    private Taxi taxi;
    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;
    private Float latStart;
    private Float latEnd;
    private Float longStart;
    private Float longEnd;
    private Integer km;
}
