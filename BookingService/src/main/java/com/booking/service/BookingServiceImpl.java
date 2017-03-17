package com.booking.service;

import com.booking.dao.BookingDAO;
import com.booking.dto.Booking;
import com.booking.util.BusKeyGen;
import com.booking.util.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingDAO bookingDAO;

    @Override
    public Booking createBooking(String userId, String restaurantId, String reservationId) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(userId, reservationId, reservationId))return null;
        // Operate
        Booking bookingObject = new Booking(BusKeyGen.nextKey(), restaurantId, userId, reservationId);
        return bookingDAO.writeBooking(bookingObject);
    }

    @Override
    public Booking findBookingById(int bookingId) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(bookingId))return null;
        if(!bookingDAO.containsBookingById(bookingId))return null;
        // Persist
        return bookingDAO.readBooking(bookingId);
    }

    @Override
    public Booking findBookingByReservationId(String reservationId) {
        return null;
    }

    @Override
    public boolean deleteBooking(int bookingId) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(bookingId)) return false;
        // Persist
        return bookingDAO.deleteBooking(bookingId);
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingDAO.getAllBookings();
    }

    @Override
    public List<Booking> findAllBookingsByUserId() {
        return null;
    }

    @Override
    public List<Booking> findAllBookingsByRestaurantId() {
        return null;
    }
}
