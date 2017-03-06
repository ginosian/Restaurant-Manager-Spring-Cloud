package com.restaurant.admin.service;

import com.restaurant.admin.model.Product;
import com.restaurant.admin.model.Reservation;
import com.restaurant.admin.model.Role;
import com.restaurant.admin.model.User;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface Service {

    List<User> getAllUsers();
    List<Product> getAllProducts();
    List<Reservation> getAllReservations();
    List<Role> getAllRoles();
    void addUser(User user);
    void addProduct(Product product);
    void addRole(Role role);
    void deleteUser();
    void deletProduct();
    void deleteReservation();
}
