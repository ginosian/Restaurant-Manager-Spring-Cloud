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
public class UserContoller {

    public static boolean usersAreCreated = false;


    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;


    public void createProducts(){
        if(usersAreCreated) return;

        Product product1 = productService.createProduct(MockedData.productName());
        Product product2 = productService.createProduct(MockedData.productName());
        Product product3 = productService.createProduct(MockedData.productName());
        Product product4 = productService.createProduct(MockedData.productName());
        Product product5 = productService.createProduct(MockedData.productName());
        Product product6 = productService.createProduct(MockedData.productName());
        Product product7 = productService.createProduct(MockedData.productName());
        Product product8 = productService.createProduct(MockedData.productName());
        Product product9 = productService.createProduct(MockedData.productName());
        Product product10 = productService.createProduct(MockedData.productName());
        Product product11 = productService.createProduct(MockedData.productName());
        Product product12 = productService.createProduct(MockedData.productName());

        List<ChooserProduct> products1 = new LinkedList<>();
        products1.add(new ChooserProduct(product1.getId(), 2));
        products1.add(new ChooserProduct(product2.getId(), 8));
        products1.add(new ChooserProduct(product3.getId(), 5));
        List<ChooserProduct> products2 = new LinkedList<>();
        products2.add(new ChooserProduct(product4.getId(), 20));
        products2.add(new ChooserProduct(product5.getId(), 0));

        Reservation reservation1 = reservationService.createReservationAndAddProducts(products1);
        Reservation reservation2 = reservationService.createReservationAndAddProducts(products2);
        Reservation reservation3 = reservationService.createReservationAndAddProducts(products1);
        Reservation reservation4 = reservationService.createReservationAndAddProducts(products2);
        Reservation reservation5 = reservationService.createReservationAndAddProducts(products1);
        Reservation reservation6 = reservationService.createReservationAndAddProducts(products2);
        Reservation reservation7 = reservationService.createReservationAndAddProducts(products1);

        reservationService.changeReservationState(reservation2.getId(), false);
        reservationService.changeReservationState(reservation3.getId(), false);
        reservationService.changeReservationState(reservation4.getId(), false);
        reservationService.changeReservationState(reservation5.getId(), false);
        reservationService.changeReservationState(reservation6.getId(), false);

        usersAreCreated = true;
    }
}
