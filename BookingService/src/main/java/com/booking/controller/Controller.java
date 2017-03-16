package com.restaurant.controller;

import com.restaurant.dto.Booking;
import com.restaurant.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class Controller {

    @Autowired
    BookingService bookingService;


    @PostMapping(path = "/restaurant")
    public void addRestaurant(String restaurantName){
        bookingService.createRestaurant(restaurantName);
    }

    @GetMapping(path = "/restaurant/{id}", produces = "application/json")
    public Booking getRestaurant(@PathVariable("id") int id){
        return bookingService.findRestaurant(id);
    }

    @PutMapping(path = "/booking")
    public void updateRestaurant(Booking booking){
        bookingService.updateRestaurantName(booking.getId(), booking.getRestaurantName());
    }

    @DeleteMapping(path = "/booking")
    public void deleteRestaurant(Booking booking){
        bookingService.deleteRestaurant(booking.getId());
    }

    @GetMapping(path = "/restaurants", produces = "application/json")
    public List<Booking> getRestaurants(){
        List<Booking> bookings = bookingService.findAllRestaurants();
        return bookings;
    }

}
