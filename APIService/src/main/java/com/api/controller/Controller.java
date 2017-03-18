package com.api.controller;

import com.api.dto.Restaurant;
import com.api.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class Controller {

    @Autowired
    RestaurantService restaurantService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(path = "/restaurant")
    public void addRestaurant(@RequestBody String restaurantName){
        restaurantService.createRestaurant(restaurantName);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'RESTAURANT')")
    @GetMapping(path = "/restaurant/{id}", produces = "application/json")
    public Restaurant getRestaurant(@PathVariable("id") int id){
        return restaurantService.findRestaurant(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping(path = "/restaurant/delete/{id}") // A POST mapping instead of DELETE in due to my tomcat with current configs doesn't support DELETE
    public void deleteRestaurant(@PathVariable("id") int id){
        try {
            Thread.sleep(14000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        restaurantService.deleteRestaurant(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'RESTAURANT')")
    @GetMapping(path = "/restaurants", produces = "application/json")
    public List<Restaurant> getRestaurants(){
        List<Restaurant> restaurants = restaurantService.findAllRestaurants();
        return restaurants;
    }

}
