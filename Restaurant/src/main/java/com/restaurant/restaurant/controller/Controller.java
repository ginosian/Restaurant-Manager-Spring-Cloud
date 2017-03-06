package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.model.Reservation;
import com.restaurant.restaurant.service.Service;
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

    @RequestMapping(path = "restaurant", method = RequestMethod.GET)
    public ModelAndView homeData() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(allReservations());
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @ModelAttribute("allReservations")
    public List<Reservation> allReservations() {
        return this.service.getAllReservations();
    }

}
