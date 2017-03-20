package com.booking.service;


import com.booking.dto.Booking;
import model.BookingModel;
import model.Reservations;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface BookingService {

    Booking createBooking(BookingModel booking,  String token);

    Booking createBooking(Integer userId, Integer restaurantId, Integer reservationId);

    Booking findBookingById(int bookingId);

    Booking findBookingByReservationId(String reservationId);

    boolean deleteBooking(int bookingId);

    List<Booking> findAllBookings();

    Reservations findAllBookingsByUserId(Integer userId, String token);

    Reservations findAllBookingsByRestaurantId(Integer restaurantId, String token);

}
