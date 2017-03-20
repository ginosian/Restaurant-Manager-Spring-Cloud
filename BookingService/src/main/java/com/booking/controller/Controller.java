package com.booking.controller;

import com.booking.dto.Booking;
import com.booking.service.BookingService;
import model.BookingModel;
import model.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class Controller {

    @Autowired
    BookingService bookingService;

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping(path = "/booking", produces = "application/json", consumes = "application/json") // A POST mapping instead of PUT in due to my tomcat with current configs doesn't support PUT
    public void addBooking(@RequestBody BookingModel booking, HttpServletRequest request, HttpServletResponse response){
        Booking result = bookingService.createBooking(booking, request.getHeader("Authorization"));
        response.setHeader("Location", "http://localhost:1110/restaurant/reservation/" + result.getReservationId());
        response.setStatus(HttpServletResponse.SC_FOUND);
    }

    @PreAuthorize("hasAnyAuthority('USER', 'RESTAURANT')")
    @GetMapping(path = "/booking/{id}", produces = "application/json")
    public Booking getBooking(@PathVariable("id") int id){
        return bookingService.findBookingById(id);
    }

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping(path = "/booking/update") // A POST mapping instead of PUT in due to my tomcat with current configs doesn't support PUT
    public void updateBooking(@RequestBody Booking booking){
//        bookingService.updateBookingName(booking.getId(), booking.getBookingName());
    }

    @PreAuthorize("hasAnyAuthority('RESTAURANT')")
    @PostMapping(path = "/booking/delete/{id}") // A POST mapping instead of DELETE in due to my tomcat with current configs doesn't support DELETE
    public void deleteBooking(@PathVariable("id") int id){
        bookingService.deleteBooking(id);
    }


    @PreAuthorize("hasAnyAuthority('RESTAURANT')")
    @GetMapping(path = "/bookings", produces = "application/json")
    public List<Booking> getBookings(){
        List<Booking> bookings = bookingService.findAllBookings();
        return bookings;
    }

    @PreAuthorize("hasAnyAuthority('USER', 'RESTAURANT')")
    @GetMapping(path = "/bookings/user/{id}", produces = "application/json")
    public Reservations getBookings(@PathVariable("id") int id, HttpServletRequest request){
        return bookingService.findAllBookingsByUserId(id, request.getHeader("Authorization"));
    }

}
