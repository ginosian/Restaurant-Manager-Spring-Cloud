package com.restaurant.service;

import com.restaurant.dto.Reservation;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface ReservationService {

    /** Checks by Reservation generated id, if Reservation exists updates it, if not creates new Reservation.
     * @param reservation instance of {@link Reservation}
     * @return {@link Reservation} object from db or null if doesn't exist.*/
    Reservation writeOrUpdateReservation(Reservation reservation);

    /** Finds specified Reservation.
     * @param reservationId generated id of Reservation.
     * @return {@link Reservation} object from db or null if doesn't exist.*/
    Reservation readReservation(int reservationId);

    /** Finds specified Reservation.
     * @param number Reservation business key.
     * @return {@link Reservation} object from db or null if doesn't exist.*/
    Reservation readReservation(String number);

    /** Deletes specified Reservation.
     * @param reservationId generated id of Reservation.
     * @return true if Reservation was successfully deleted or did not exist.*/
    boolean deleteReservation(int reservationId);

    /** Gets all Reservations.
     * @return list of {@link Reservation} objects from db or if non exist return a list with size of 0.*/
    List<Reservation> getAllReservations();

    /** Gets all Reservations.
     * @param userId id of user created reservations
     * @return list of {@link Reservation} objects from db or if non exist return a list with size of 0.*/
    List<Reservation> getAllReservationsByUser(int userId);



    /** Adds or updates product in reservation.
     * @param reservationId  id of reservation.
     * @param isActive Indicates weather reservation is active or not.
     * @return {@link Reservation} object from db or null if doesn't exist.*/
    Reservation changeReservationState(int reservationId, boolean isActive);
}
