package com.restaurant.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.guest.service.Service;

/**
 * Created by Martha on 2/25/2017.
 */
@RestController
public class Controller {

    @Autowired
    Service service;

    @GetMapping(value = "/guest")
    public Object addOrUpdateUser(){
        return service.getEntity();
    }
}
