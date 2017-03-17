package com.restaurant.controller;

import com.restaurant.dto.Product;
import com.restaurant.dto.Reservation;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import com.restaurant.service.helperModels.ChooserProduct;
import com.restaurant.util.MockedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class ProductController {
    private static boolean dataIsCreated = false;

    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;

    @PostMapping(path = "/product")
    public void addProduct(String productName, Integer restaurantId){
        productService.createProduct(productName, restaurantId);
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

    public void createProducts(){
        if(dataIsCreated) return;

        Product product1 = productService.createProduct(MockedData.productName(), 1);
        Product product2 = productService.createProduct(MockedData.productName(), 2);
        Product product3 = productService.createProduct(MockedData.productName(), 3);
        Product product4 = productService.createProduct(MockedData.productName(), 4);
        Product product5 = productService.createProduct(MockedData.productName(), 5);
        Product product6 = productService.createProduct(MockedData.productName(), 6);
        Product product7 = productService.createProduct(MockedData.productName(), 7);
        Product product8 = productService.createProduct(MockedData.productName(), 1);
        Product product9 = productService.createProduct(MockedData.productName(), 1);
        Product product10 = productService.createProduct(MockedData.productName(), 2);
        Product product11 = productService.createProduct(MockedData.productName(), 2);
        Product product12 = productService.createProduct(MockedData.productName(), 2);

        List<ChooserProduct> products1 = new LinkedList<>();
        products1.add(new ChooserProduct(product1.getId(), 2));
        products1.add(new ChooserProduct(product2.getId(), 8));
        products1.add(new ChooserProduct(product3.getId(), 5));
        List<ChooserProduct> products2 = new LinkedList<>();
        products2.add(new ChooserProduct(product4.getId(), 20));
        products2.add(new ChooserProduct(product5.getId(), 0));

        Reservation reservation1 = reservationService.createReservationAndAddProducts(products1, 1);
        Reservation reservation2 = reservationService.createReservationAndAddProducts(products2, 1);
        Reservation reservation3 = reservationService.createReservationAndAddProducts(products1, 1);
        Reservation reservation4 = reservationService.createReservationAndAddProducts(products2, 2);
        Reservation reservation5 = reservationService.createReservationAndAddProducts(products1, 2);
        Reservation reservation6 = reservationService.createReservationAndAddProducts(products2, 2);
        Reservation reservation7 = reservationService.createReservationAndAddProducts(products1, 2);

        reservationService.changeReservationState(reservation2.getId(), false);
        reservationService.changeReservationState(reservation3.getId(), false);
        reservationService.changeReservationState(reservation4.getId(), false);
        reservationService.changeReservationState(reservation5.getId(), false);
        reservationService.changeReservationState(reservation6.getId(), false);

        dataIsCreated = true;
    }

}
