package com.example.uberapi.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxiDTO {
    private int totalKm;
    private Long driverId;
    private Long carModelId;
}