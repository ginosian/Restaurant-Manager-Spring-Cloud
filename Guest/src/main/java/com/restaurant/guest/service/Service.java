package com.restaurant.guest.service;

import com.restaurant.guest.model.Product;
import com.restaurant.guest.model.Reservation;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface Service {

    List<Product> getAllProducts();
    List<Reservation> getAllReservationsByUser();
    void addReservation(Reservation reservation);
    void closeReservation(int reservationId);
    void updateReservation(Reservation reservation);
}
