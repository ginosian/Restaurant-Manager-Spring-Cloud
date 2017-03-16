package com.booking.service;


import com.restaurant.dto.Booking;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface BookingService {

    Booking createBooking(String bookingName);

    Booking findBooking(int bookingId);

    Booking findBooking(String bookingName);

    boolean deleteBooking(int bookingId);

    List<Booking> findAllBookings();
}
