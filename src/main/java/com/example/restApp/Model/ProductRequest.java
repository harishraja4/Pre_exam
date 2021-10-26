package com.example.restApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductRequest {
    private ProductList productList;

    public ProductRequest() {
    }
}
