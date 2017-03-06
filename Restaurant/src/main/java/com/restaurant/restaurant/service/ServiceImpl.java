package com.restaurant.restaurant.service;

import com.restaurant.restaurant.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@Repository
public class ServiceImpl implements Service {
    private static final String SERVICE_URL = "http://persistence-microservice";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Reservation> getAllReservations() {
        final String uri = SERVICE_URL + "/reservations";
        List<Reservation> result = restTemplate.getForObject(uri, ArrayList.class);
        return result;
    }

    @Override
    public void closeReservation(int reservationId) {

    }

    @Override
    public void updateReservation(Reservation reservation) {

    }
}
