package com.restaurant.admin.service;

import com.restaurant.admin.model.Product;
import com.restaurant.admin.model.Reservation;
import com.restaurant.admin.model.Role;
import com.restaurant.admin.model.User;
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


    public List<User> getAllUsers(){
        final String uri = SERVICE_URL + "/users";
        List<User> result = restTemplate.getForObject(uri, ArrayList.class);
        return result;

    }

    public List<Product> getAllProducts(){
        final String uri = SERVICE_URL + "/products";
        List<Product> result = restTemplate.getForObject(uri, ArrayList.class);
        return result;

    }

    public List<Reservation> getAllReservations(){
        final String uri = SERVICE_URL + "/reservations";
        List<Reservation> result = restTemplate.getForObject(uri, List.class);
        return result;

    }

    public List<Role> getAllRoles(){
        final String uri = SERVICE_URL + "/roles";
        List<Role> result = restTemplate.getForObject(uri, ArrayList.class);
        return result;

    }

    public void addUser(User user){
        final String uri = SERVICE_URL + "/user";

    }

    public void addProduct(Product product){
        final String uri = SERVICE_URL + "/product";
    }

    public void addRole(Role role){
        final String uri = SERVICE_URL + "/role";
    }

    public void deleteUser(){
        final String uri = SERVICE_URL + "/user";
    }

    public void deletProduct(){
        final String uri = SERVICE_URL + "/product";
    }

    public void deleteReservation(){
        final String uri = SERVICE_URL + "/reservation";
    }
}
