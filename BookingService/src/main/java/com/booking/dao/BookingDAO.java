package com.booking.dao;


import com.restaurant.dto.Booking;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface BookingDAO {

    /** Updates given entity, comparing identity is its generated id
     * @param booking instance of {@link Booking}
     * @return {@link Booking} entity updated.*/
    Booking updateBooking(Booking booking);

    /** Persists given entity
     * @param booking instance of {@link Booking}
     * @return {@link Booking} entity with generated Id from db.*/
    Booking writeBooking(Booking booking);

    /** Checks by username
     * @param bookingname unique name of booking
     * @return false if doesn't exist.*/
    boolean containsBookingByName(String bookingname);

    /** Checks by username
     * @param bookingId unique id of booking
     * @return false if doesn't exist.*/
    boolean containsBookingById(int bookingId);

    /** Finds specified booking.
     * @param bookingId generated id of booking.
     * @return {@link Booking} object from db or null if doesn't exist.*/
    Booking readBooking(Integer bookingId);

    /** Finds specified booking.
     * @param number business key of booking.
     * @return {@link Booking} object from db or null if doesn't exist.*/
    Booking readBooking(String number);

    /** Deletes specified booking.
     * @param bookingId generated id of booking.
     * @return true if booking was successfully deleted or did not exist.*/
    boolean deleteBooking(Integer bookingId);

    /** Gets all bookings.
     * @return list of {@link Booking} objects from db or if non exist return a list with size of 0.*/
    List<Booking> getAllBookings();



}
