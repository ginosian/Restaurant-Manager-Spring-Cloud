package com.restaurant.controller;

import com.restaurant.dto.Product;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;

    @PostMapping(path = "/product")
    public void addProduct(String productName){
        productService.createProduct(productName);
    }

    @GetMapping(path = "/product/{id}", produces = "application/json")
    public Product getProduct(@PathVariable("id") int id){
        return productService.findProduct(id);
    }

    @PutMapping(path = "/product")
    public void updateProduct(Product product){
        productService.updateProductName(product.getId(), product.getProductName());
    }

    @DeleteMapping(path = "/product")
    public void deleteProduct(Product product){
        productService.deleteProduct(product.getId());
    }

    @GetMapping(path = "/products", produces = "application/json")
    public List<Product> getProducts(){
        List<Product> products = productService.findAllProducts();
        return products;
    }

}
