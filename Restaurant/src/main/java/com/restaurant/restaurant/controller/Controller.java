package com.restaurant.restaurant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Martha on 2/25/2017.
 */
@RestController
public class Controller {

    @GetMapping("/")
    @ResponseBody
    public String homeTest(Principal principal) {
        String name = principal.getName();
        return "<html><h1>Welcome to the Restaurant home page!</h1><html/>" + name;
    }

//    @Autowired
//    Service service;
//
//    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public ModelAndView homeData() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject(allReservations());
//        modelAndView.setViewName("home");
//        return modelAndView;
//    }
//
//    @ModelAttribute("allReservations")
//    public List<Reservation> allReservations() {
//        return this.service.getAllReservations();
//    }

}
