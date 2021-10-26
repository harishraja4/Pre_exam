package com.example.restApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Supply {
    private String productId;
    private Double quantity;
}
