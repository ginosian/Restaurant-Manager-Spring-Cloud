package com.booking.service;

import com.booking.dao.BookingDAO;
import com.restaurant.dto.Booking;
import com.restaurant.util.BusKeyGen;
import com.restaurant.util.Validate;
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
    public Booking createBooking(String bookingName) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(bookingName))return null;
        if(bookingDAO.containsBookingByName(bookingName))return null;
        // Operate
        Booking bookingObject = new Booking(bookingName, BusKeyGen.nextKey());
        return bookingDAO.writeBooking(bookingObject);
    }

    @Override
    public Booking findBooking(int bookingId) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(bookingId))return null;
        if(!bookingDAO.containsBookingById(bookingId))return null;
        // Persist
        return bookingDAO.readBooking(bookingId);
    }

    @Override
    public Booking findBooking(String bookingName) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(bookingName)) return null;
        // Persist
        return bookingDAO.readBooking(bookingName);
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
}
