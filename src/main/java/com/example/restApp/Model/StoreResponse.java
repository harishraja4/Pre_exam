package com.example.restApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class StoreResponse {
    private String storeNo;
    private String productId;
    private Double availQty;
    private String reqDate;
    private String status;
}
