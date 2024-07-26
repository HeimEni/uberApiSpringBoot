package com.example.uberapi.entities.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModelDTO {
    private Long id;
    private String model;
    private String marque;
}
