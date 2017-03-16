package com.restaurant.controller;

import com.restaurant.dto.Restaurant;
import com.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class Controller {

    @Autowired
    RestaurantService restaurantService;


    @PostMapping(path = "/restaurant")
    public void addRestaurant(String restaurantName){
        restaurantService.createRestaurant(restaurantName);
    }

    @GetMapping(path = "/restaurant/{id}", produces = "application/json")
    public Restaurant getRestaurant(@PathVariable("id") int id){
        return restaurantService.findRestaurant(id);
    }

    @PutMapping(path = "/restaurant")
    public void updateRestaurant(Restaurant restaurant){
        restaurantService.updateRestaurantName(restaurant.getId(), restaurant.getRestaurantName());
    }

    @DeleteMapping(path = "/restaurant")
    public void deleteRestaurant(Restaurant restaurant){
        restaurantService.deleteRestaurant(restaurant.getId());
    }

    @GetMapping(path = "/restaurants", produces = "application/json")
    public List<Restaurant> getRestaurants(){
        List<Restaurant> restaurants = restaurantService.findAllRestaurants();
        return restaurants;
    }

}
