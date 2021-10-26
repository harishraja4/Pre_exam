package com.example.restApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Product {
    private String productId;
    private String productName;
    private String unitOfMeasure;
    private Date launchDate;
}
