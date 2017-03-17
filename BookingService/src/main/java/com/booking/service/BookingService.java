package com.booking.service;


import com.booking.dto.Booking;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface BookingService {

    Booking createBooking(String userId, String restaurantId, String reservationId);

    Booking findBookingById(int bookingId);

    Booking findBookingByReservationId(String reservationId);

    boolean deleteBooking(int bookingId);

    List<Booking> findAllBookings();

    List<Booking> findAllBookingsByUserId();

    List<Booking> findAllBookingsByRestaurantId();

}
