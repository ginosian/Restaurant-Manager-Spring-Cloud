package com.restaurant.DataModel;

import com.restaurant.dto.Product;
import com.restaurant.dto.ProductInReservation;
import com.restaurant.dto.Reservation;
import com.restaurant.dto.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Martha on 2/28/2017.
 */
public class GlobalEntityAllImpl implements GlobalEntity{

    private Map<String, List<User>> users = new HashMap<>();
    private Map<String, List<Product>> products = new HashMap<>();
    private Map<String, List<Reservation>> reservations = new HashMap<>();
    private Map<String, List<ProductInReservation>> productInReservation = new HashMap<>();

    public GlobalEntityAllImpl(Map<String, List<User>> users,
                               Map<String, List<Product>> products,
                               Map<String, List<Reservation>> reservations,
                               Map<String, List<ProductInReservation>> productInReservation) {
        this.users = users;
        this.products = products;
        this.reservations = reservations;
        this.productInReservation = productInReservation;
    }

    @Override
    public GlobalEntity getPackage() {
        return this;
    }

    public Map<String, List<User>> getUsers() {
        return users;
    }

    public void setUsers(Map<String, List<User>> users) {
        this.users = users;
    }

    public Map<String, List<Product>> getProducts() {
        return products;
    }

    public void setProducts(Map<String, List<Product>> products) {
        this.products = products;
    }

    public Map<String, List<Reservation>> getReservations() {
        return reservations;
    }

    public void setReservations(Map<String, List<Reservation>> reservations) {
        this.reservations = reservations;
    }

    public Map<String, List<ProductInReservation>> getProductInReservation() {
        return productInReservation;
    }

    public void setProductInReservation(Map<String, List<ProductInReservation>> productInReservation) {
        this.productInReservation = productInReservation;
    }
}
