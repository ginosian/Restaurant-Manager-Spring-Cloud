package com.restaurant.restaurant.service;

import com.restaurant.restaurant.model.Reservation;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface Service {

    List<Reservation> getAllReservations();
    void closeReservation(int reservationId);
    void updateReservation(Reservation reservation);
}
