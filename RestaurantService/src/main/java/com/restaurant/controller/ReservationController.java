package com.restaurant.controller;

import com.restaurant.dto.Reservation;
import com.restaurant.service.ReservationService;
import com.restaurant.service.helperModels.ChooserProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping(path = "/reservation")
    public void createResrvation(List<ChooserProduct> products){
        reservationService.createReservationAndAddProducts(products);
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
    @PostMapping(path = "/reservations", produces = "application/json")
    public List<Reservation> getReservations(List<Integer> ids){
        List<Reservation> reservations =  reservationService.findAllReservations(ids);
        return reservations;
    }

    @PreAuthorize("hasAnyAuthority('RESTAURANT')")
    @PostMapping(path = "/reservations/closed", produces = "application/json")
    public List<Reservation> getClosedReservations(List<Integer> ids){
        List<Reservation> reservations =  reservationService.getAllClosedReservations();
        return reservations;
    }

}
