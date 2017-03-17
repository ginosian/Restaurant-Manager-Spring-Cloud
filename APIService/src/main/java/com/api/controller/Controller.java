package com.api.controller;

import com.api.dto.Restaurant;
import com.api.service.RestaurantService;
import com.api.util.MockedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class Controller {

    private static boolean dataIsCreated = false;

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
    @PostMapping(path = "/restaurant/delete/{id}")
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
        createProducts();
        List<Restaurant> restaurants = restaurantService.findAllRestaurants();
        return restaurants;
    }

    public void createProducts(){
        if(dataIsCreated) return;

        Restaurant restaurant1 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant2 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant3 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant4 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant5 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant6 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant7 = restaurantService.createRestaurant(MockedData.restaurantName());

        dataIsCreated = true;
    }



}
