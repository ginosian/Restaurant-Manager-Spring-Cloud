package com.restaurant.controller;

import com.restaurant.dto.ProductInReservation;
import com.restaurant.dto.Reservation;
import com.restaurant.service.ReservationService;
import model.BookingProduct;
import model.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping(path = "/reservation", produces = "application/json", consumes = "application/json")
    public Integer createResrvation(@RequestBody List<BookingProduct> products){
        Reservation reservation = reservationService.createReservationAndAddProducts(products);
        return reservation.getId();
    }

    @PreAuthorize("hasAnyAuthority('USER', 'RESTAURANT')")
    @GetMapping(path = "/reservation/{id}", produces = "application/json")
    public Reservation getReservation(@PathVariable("id") int id){
        return reservationService.findReservationById(id);
    }

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping(path = "/reservation/update") // A POST mapping instead of PUT in due to my tomcat with current configs doesn't support PUT
    public void updateReservation(Reservation reservation){
        reservationService.updateReservation(reservation);
    }

    @PreAuthorize("hasAnyAuthority('RESTAURANT')")
    @PostMapping(path = "/reservation/delete/{id}") // A POST mapping instead of DELETE in due to my tomcat with current configs doesn't support DELETE
    public void deleteReservation(@PathVariable("id") int id){
        reservationService.deleteReservation(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'RESTAURANT')")
    @GetMapping(path = "/reservations", produces = "application/json")
    public List<Reservation> getReservations(){
        List<Reservation> reservations =  reservationService.findAllReservations();
        return reservations;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'RESTAURANT')")
    @PostMapping(path = "/reservations", produces = "application/json", consumes = "application/json")
    public Reservations getReservations(@RequestBody List<Integer> ids){
        List<Reservation> reservations =  reservationService.findAllReservations(ids);
        List<BookingProduct> bookingProducts = new ArrayList<>();
        for(Reservation reservation : reservations){
            for(ProductInReservation productInReservation : reservation.getProducts()){
                bookingProducts.add(new BookingProduct(productInReservation.getProduct().getProductName(), productInReservation.getAmount()));
            }
        }
        Reservations result = new Reservations();
        result.setReservationsList(bookingProducts);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('RESTAURANT')")
    @GetMapping(path = "/reservations/closed", produces = "application/json")
    public Reservations getClosedReservations(){
        List<Reservation> reservations =  reservationService.getAllClosedReservations();
        List<BookingProduct> bookingProducts = new ArrayList<>();
        for(Reservation reservation : reservations){
            for(ProductInReservation productInReservation : reservation.getProducts()){
                bookingProducts.add(new BookingProduct(productInReservation.getProduct().getProductName(), productInReservation.getAmount()));
            }
        }
        Reservations result = new Reservations();
        result.setReservationsList(bookingProducts);
        return result;
    }

}
