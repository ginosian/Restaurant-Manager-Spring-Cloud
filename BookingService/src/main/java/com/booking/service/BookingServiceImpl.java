package com.booking.service;

import com.booking.dao.BookingDAO;
import com.booking.dto.Booking;
import com.booking.util.BusKeyGen;
import com.booking.util.Validate;
import model.BookingModel;
import model.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private static final String RESTAURANT_SERVICE_URL = "http://restaurant";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BookingDAO bookingDAO;

    @Override
    public Booking createBooking(BookingModel booking,  String token) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(booking))return null;
        if(!Validate.valid(booking.getUserId(), booking.getRestaurantId()))return null;
        if(!Validate.valid(booking.getProducts()))return null;
        // Operate
        final String uri = RESTAURANT_SERVICE_URL + "/reservation";

        // Forms request header
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.set("Authorization", token);
        header.set("Content-Type", "application/json;charset=UTF-8");

//         Forms request body
        HttpEntity<Object> httpEntity = new HttpEntity<>(booking.getProducts(), header);

        ResponseEntity<Integer> reservationId = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Integer.class);
        Booking bookingObject = new Booking(BusKeyGen.nextKey(), booking.getRestaurantId(), booking.getUserId(), reservationId.getBody());
        return bookingDAO.writeBooking(bookingObject);
    }

    @Override
    public Booking createBooking(Integer userId, Integer restaurantId, Integer reservationId) {
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
    public Reservations findAllBookingsByUserId(Integer userId, String token) {
        List<Booking> bookings = bookingDAO.getAllBookingsByUserId(userId);
        List<Integer> reservationsIds = new ArrayList<>();
        for (Booking booking : bookings){
            reservationsIds.add(booking.getReservationId());
        }

        final String uri = RESTAURANT_SERVICE_URL + "/reservations";

        // Forms request header
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.set("Authorization", token);
        header.set("Content-Type", "application/json;charset=UTF-8");

//         Forms request body
        HttpEntity<Object> httpEntity = new HttpEntity<>(reservationsIds, header);

        ResponseEntity<Reservations> reservations = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Reservations.class);
        return reservations.getBody();
    }

    @Override
    public Reservations findAllBookingsByRestaurantId(Integer restaurantId, String token) {
        List<Booking> bookings = bookingDAO.getAllBookingsByRestaurantId(restaurantId);
        List<Integer> reservationsIds = new ArrayList<>();
        for (Booking booking : bookings){
            reservationsIds.add(booking.getReservationId());
        }

        final String uri = RESTAURANT_SERVICE_URL + "/reservations";

        // Forms request header
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.set("Authorization", token);
        header.set("Content-Type", "application/json;charset=UTF-8");

//         Forms request body
        HttpEntity<Object> httpEntity = new HttpEntity<>(reservationsIds, header);

        ResponseEntity<Reservations> reservations = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Reservations.class);
        return reservations.getBody();
    }
}
