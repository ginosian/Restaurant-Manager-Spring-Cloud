package com.restaurant.controller;

import com.restaurant.dto.Product;
import com.restaurant.dto.Role;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import com.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@RestController
public class TestController {

    public static int counter =  0;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<Product> addOrUpdateUser(){
        return null;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Product addOrUpdateProduct(){
        return null;
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public Role addOrUpdateRole(){
        return null;
    }
}
