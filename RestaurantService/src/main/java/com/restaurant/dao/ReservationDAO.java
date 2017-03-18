package com.restaurant.dao;

import com.restaurant.dto.ProductInReservation;
import com.restaurant.dto.Reservation;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface ReservationDAO {

    /** Persists given entity
     * @param reservation instance of {@link Reservation}
     * @return {@link Reservation} entity with generated Id from db.*/
    Reservation writeReservation(Reservation reservation);

    /** Finds specified Reservation.
     * @param reservationId generated id of Reservation.
     * @return {@link Reservation} object from db or null if doesn't exist.*/
    Reservation readReservation(int reservationId);

    /** Deletes specified Reservation.
     * @param reservationId generated id of Reservation.
     * @return true if Reservation was successfully deleted or did not exist.*/
    boolean deleteReservation(int reservationId);

    /** Gets all Reservations.
     * @return list of {@link Reservation} objects from db or if non exist return a list with size of 0.*/
    List<Reservation> getAllReservations();

    List<Reservation> getAllReservations(List<Integer> ids);

    /** Gets all Products list within reservation.
     * @return list of {@link ProductInReservation} objects from db or if non exist return a list with size of 0.*/
    List<ProductInReservation> getAllProducts(int reservationId);

    Reservation updateReservation(Reservation reservation);

    ProductInReservation readProductInReservation(Integer productInReservationId);

    boolean deleteProductInReservation(Integer productInResrevationId);

    void deleteProductInReservationByProduct(Integer productId);

    ProductInReservation findProductInReservationById(Integer productInReservationId);

    List<Reservation> readAllClosedReservations();

}
