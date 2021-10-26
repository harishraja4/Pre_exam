package com.example.restApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class StoreRequest {
    private String storeNo;
    private String productId;
    private Double reqQty;
    private String reqDate;
}
