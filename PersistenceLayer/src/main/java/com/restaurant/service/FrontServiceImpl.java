package com.restaurant.service;

import com.restaurant.DataModel.GlobalEntity;
import com.restaurant.DataModel.GlobalEntityAllImpl;
import com.restaurant.dto.Product;
import com.restaurant.dto.ProductInReservation;
import com.restaurant.dto.Reservation;
import com.restaurant.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Martha on 2/28/2017.
 */
@Service
public class FrontServiceImpl implements FrontService{

    ReentrantLock lock = new ReentrantLock();

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;

    @Override
    public GlobalEntity getAllData() {
        List<User> userList = userService.getAllUsers();
        List<Product> products = productService.getAllProducts();
        List<ProductInReservation> productInReservations = productService.getAllProductsInReservation();
        List<Reservation> reservations = reservationService.getAllReservations();


        HashMap<String, List<User>> usersMap = new HashMap<>();
        usersMap.put("User", userList);

        HashMap<String, List<Product>> productMap = new HashMap<>();
        productMap.put("Product", products);

        HashMap<String, List<ProductInReservation>> productInReservationsMap = new HashMap<>();
        productInReservationsMap.put("ProductInReservation", productInReservations);

        HashMap<String, List<Reservation>> reservationsMap = new HashMap<>();
        reservationsMap.put("Reservations", reservations);

        GlobalEntity globalEntity = new GlobalEntityAllImpl(usersMap, productMap, reservationsMap, productInReservationsMap);
        return globalEntity;
    }
}
