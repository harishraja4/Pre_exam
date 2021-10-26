package com.example.restApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ProductList {
    private List<Product> productList;

    public ProductList() {
    }
}
