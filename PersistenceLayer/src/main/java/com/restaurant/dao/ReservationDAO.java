package com.restaurant.dao;

import com.restaurant.dto.Product;
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

    /** Gets all Products list within reservation.
     * @return list of {@link ProductInReservation} objects from db or if non exist return a list with size of 0.*/
    List<ProductInReservation> getAllProducts(int reservationId);

    ProductInReservation changeAmount(int productInReservationId, int amount);

    ProductInReservation writeProductInReservation(ProductInReservation productInReservation);
    ProductInReservation updateProductInReservation(ProductInReservation productInReservation);
    boolean reservationContainsProduct(int reservationId, int productId);

    ProductInReservation readProductInReservation(Integer productInReservationId);
    ProductInReservation readProductInReservation(String number);
    boolean deleteProductInReservation(Integer productInResrevationId);
    List<Product> getAllProductsInReservation();
}
