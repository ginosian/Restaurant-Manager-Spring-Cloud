package com.restaurant.guest.service;

import com.restaurant.guest.model.Product;
import com.restaurant.guest.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@Repository
public class ServiceImpl implements Service{
    private static final String SERVICE_URL = "http://persist";

    @Autowired
    RestTemplate restTemplate;

    public List<Product> getAllProducts() {
        final String uri = SERVICE_URL + "/products";
        List<Product> result = restTemplate.getForObject(uri, ArrayList.class);
        return result;
    }

    public List<Reservation> getAllReservationsByUser() {
        final String uri = SERVICE_URL + "/reservations";
        List<Reservation> result = restTemplate.getForObject(uri, List.class);
        return result;
    }

    public void addReservation(Reservation reservation) {

    }

    public void closeReservation(int reservationId) {

    }

    public void updateReservation(Reservation reservation) {

    }
}
