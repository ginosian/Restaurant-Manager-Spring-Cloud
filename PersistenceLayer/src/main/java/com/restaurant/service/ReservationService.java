package com.restaurant.service;

import com.restaurant.dto.Reservation;
import com.restaurant.service.helperModels.ChooserProduct;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface ReservationService {

    Reservation createReservationAndAddProducts(int userId, List<ChooserProduct> products);

    Reservation addProductInReservation(int productId, int amount);

    Reservation changeProductAmountInReservation(int reservationId, int productId, int amount);

    Reservation deleteProductFromReservation(int reservationId, int productId);

    Reservation changeReservationState(int reservationId, boolean isActive);

    Reservation findReservationById(int reservationId);

    List<Reservation> findAllReservations();

    List<Reservation> findAllReservationsByUserId(int userId);

    boolean deleteReservation(int reservationId);

    boolean deleteAllReservationsByUser(int userId);
}
