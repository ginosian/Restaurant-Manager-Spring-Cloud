package com.booking.controller;

import com.booking.dto.Booking;
import com.booking.service.BookingService;
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


    @GetMapping(path = "/booking/{id}", produces = "application/json")
    public Booking getBooking(@PathVariable("id") int id){
        return bookingService.findBookingById(id);
    }

    @PutMapping(path = "/booking")
    public void updateBooking(Booking booking){
//        bookingService.updateBookingName(booking.getId(), booking.getBookingName());
    }

    @DeleteMapping(path = "/booking")
    public void deleteBooking(Booking booking){
        bookingService.deleteBooking(booking.getId());
    }

    @GetMapping(path = "/bookings", produces = "application/json")
    public List<Booking> getBookings(){
        List<Booking> bookings = bookingService.findAllBookings();
        return bookings;
    }

}
