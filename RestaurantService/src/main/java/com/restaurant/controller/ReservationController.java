package com.restaurant.controller;

import com.restaurant.dto.Reservation;
import com.restaurant.service.ReservationService;
import com.restaurant.service.helperModels.ChooserProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping(path = "/reservation")
    public void createResrvation(Integer restaurantId, List<ChooserProduct> products){
        reservationService.createReservationAndAddProducts(products, restaurantId);
    }

    @GetMapping(path = "/reservation/{id}", produces = "application/json")
    public Reservation getReservation(@PathVariable("id") int id){
        return reservationService.findReservationById(id);
    }

    @PutMapping(path = "/reservation")
    public void updateReservation(Reservation reservation){
        reservationService.updateReservation(reservation);
    }

    @DeleteMapping(path = "/reservation")
    public void deleteReservation(Reservation reservation){
        reservationService.deleteReservation(reservation.getId());
    }

    @GetMapping(path = "/reservations", produces = "application/json")
    public List<Reservation> getReservations(){
        List<Reservation> reservations =  reservationService.findAllReservations();
        return reservations;
    }

}
