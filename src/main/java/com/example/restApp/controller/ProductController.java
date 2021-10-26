package com.example.restApp.controller;

import com.example.restApp.Model.ProductList;
import com.example.restApp.Model.ProductRequest;
import com.example.restApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/sortProducts")
    public ProductList sortProducts(@RequestBody ProductList productList){
       return  productService.sortProduct(productList);
    }
}
