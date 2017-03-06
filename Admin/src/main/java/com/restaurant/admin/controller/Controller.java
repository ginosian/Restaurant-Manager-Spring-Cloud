package com.restaurant.admin.controller;

import com.restaurant.admin.model.Product;
import com.restaurant.admin.model.Reservation;
import com.restaurant.admin.model.Role;
import com.restaurant.admin.model.User;
import com.restaurant.admin.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@RestController
public class Controller {

    @Autowired
    Service service;

    @RequestMapping(path = "admin", method = RequestMethod.GET)
    public ModelAndView homeData() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(allUsers());
        modelAndView.addObject(allProducts());
        modelAndView.addObject(allReservations());
        modelAndView.addObject(allRoles());
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @ModelAttribute("allUsers")
    public List<User> allUsers() {
        return this.service.getAllUsers();
    }

    @ModelAttribute("allProducts")
    public List<Product> allProducts() {
        return this.service.getAllProducts();
    }

    @ModelAttribute("allReservations")
    public List<Reservation> allReservations() {
        return this.service.getAllReservations();
    }

    @ModelAttribute("allRoles")
    public List<Role> allRoles() {
        return this.service.getAllRoles();
    }
}
