package com.restaurant.controller;

import com.restaurant.dto.Product;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PreAuthorize("hasAnyAuthority('RESTAURANT')")
    @PostMapping(path = "/product")
    public void addProduct(String productName){
        productService.createProduct(productName);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'RESTAURANT')")
    @GetMapping(path = "/product/{id}", produces = "application/json")
    public Product getProduct(@PathVariable("id") int id){
        return productService.findProduct(id);
    }

    @PreAuthorize("hasAnyAuthority('RESTAURANT')")
    @PostMapping(path = "/product/update", produces = "application/json")  // A POST mapping instead of PUT in due to my tomcat with current configs doesn't support PUT
    public Product updateProduct(Product product){
        return productService.updateProductName(product.getId(), product.getProductName());
    }

    @PreAuthorize("hasAnyAuthority('RESTAURANT')")
    @PostMapping(path = "/product/delete/{id}")  // A POST mapping instead of DELETE in due to my tomcat with current configs doesn't support DELETE
    public void deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'RESTAURANT')")
    @GetMapping(path = "/products", produces = "application/json")
    public List<Product> getProducts(){
//        createProducts();
        List<Product> products = productService.findAllProducts();
        return products;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'RESTAURANT')")
    @PostMapping(path = "/products", produces = "application/json")
    public List<Product> getProductsByIds(List<Integer> ids){
        List<Product> products = productService.findAllProducts(ids);
        return products;
    }

}
