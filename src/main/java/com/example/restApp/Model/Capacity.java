package com.example.restApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Data
public class Capacity {
    private String storeNo;
    private String productId;
    private LocalDate date;
    private Double availQty;
}
