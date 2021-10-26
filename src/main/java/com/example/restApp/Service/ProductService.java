package com.example.restApp.Service;

import com.example.restApp.Model.Product;
import com.example.restApp.Model.ProductList;
import com.example.restApp.Model.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    public ProductList sortProduct(ProductList productList){
        System.out.println(productList);
        List<Product> productListSort=productList.getProductList().stream()
                .sorted(Comparator.comparing(Product::getProductId).thenComparing(Product::getLaunchDate)
                        .reversed()).collect(Collectors.toList());
       productList.setProductList(productListSort);
       return productList;

    }
}
