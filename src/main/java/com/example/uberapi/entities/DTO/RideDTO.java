package com.example.uberapi.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDTO {
    private Long id;
    private Long taxiId;
    private Long clientId;
    private Float latStart;
    private Float latEnd;
    private Float longStart;
    private Float longEnd;
    private Integer km;
}
