package com.example.restApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AvailabilityRequest {
    private String productId;

    public AvailabilityRequest() {
    }
}
