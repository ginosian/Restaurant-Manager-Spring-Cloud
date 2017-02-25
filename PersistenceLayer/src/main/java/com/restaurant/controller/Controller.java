package com.restaurant.controller;

import com.restaurant.dto.Product;
import com.restaurant.dto.Role;
import com.restaurant.dto.User;
import com.restaurant.service.OrderService;
import com.restaurant.service.ProductService;
import com.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@RestController
public class Controller {

    public static int counter =  0;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User addOrUpdateUser(){
        return createRandomUser();
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Product addOrUpdateProduct(){
        return productService.createOrUpdate(new Product("product" + counter++, "businessKey" + counter++));
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public Role addOrUpdateRole(){
        return userService.createRole(new Role(("role" + Integer.toString(counter++)), Integer.toString(counter++)));
    }

    private User createRandomUser(){
        Role role = userService.createRole(new Role(Integer.toString(counter++), Integer.toString(counter++)));
        List<Role> roles = new ArrayList<Role>(1);
        roles.add(role);
        return userService.createOrUpdate(new User("user" + (++counter), "aa", new ArrayList<Role>(roles)));
    }

}
