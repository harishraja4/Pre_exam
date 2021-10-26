package com.example.restApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AvailabilityResponse {
    private String productId;
    private Double availability;
}
