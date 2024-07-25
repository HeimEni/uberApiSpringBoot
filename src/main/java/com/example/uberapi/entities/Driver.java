package com.example.uberapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Driver {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String licenseNumber;
}
