package com.api.controller;

import com.api.dto.Restaurant;
import com.api.service.OauthConnectionService;
import com.api.service.RestaurantService;
import model.RestaurantCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class Controller {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    OauthConnectionService oauthConnectionService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(path = "/restaurant", produces = "application/json", consumes = "application/json")
    public Restaurant addRestaurant(@RequestBody RestaurantCreation restaurantCreation, HttpServletRequest request){
        Integer userId = oauthConnectionService.createUser(
                restaurantCreation.getUsername(),
                restaurantCreation.getPassword(),
                request.getHeader("Authorization"));
        Restaurant restaurant = restaurantService.createRestaurant(restaurantCreation.getRestaurantName(), userId);
        return restaurant;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'RESTAURANT')")
    @GetMapping(path = "/restaurant/{id}", produces = "application/json")
    public Restaurant getRestaurant(@PathVariable("id") int id){
        return restaurantService.findRestaurant(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping(path = "/restaurant/delete/{id}") // A POST mapping instead of DELETE in due to my tomcat with current configs doesn't support DELETE
    public void deleteRestaurant(@PathVariable("id") int id){
        restaurantService.deleteRestaurant(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'RESTAURANT')")
    @GetMapping(path = "/restaurants", produces = "application/json", consumes = "application/json")
    public List<Restaurant> getRestaurants(){
        List<Restaurant> restaurants = restaurantService.findAllRestaurants();
        return restaurants;
    }

}
