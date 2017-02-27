package com.restaurant.util;

import com.restaurant.dto.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martha on 2/26/2017.
 */
public class MockedData {
    public static int counter;
    private static User user;
    private static List<User> users = new ArrayList<>();

    private static Role role;
    private static List<Role> roles = new ArrayList<>();

    private static Product product;
    private static List<Product> products = new ArrayList<>();

    private static ProductInReservation productInReservation;
    private static List<ProductInReservation> productsInOrder = new ArrayList<>();

    private static Reservation reservation;
    private static List<Reservation> orders = new ArrayList<>();



    public static ArrayList<Role> generateRoleList(int quantity){
        ArrayList<Role> result = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Role role = new Role("TEST_ROLE_" + Integer.toString(++counter), "TEST_B_K_" + Integer.toString(++counter));
            result.add(role);
        }
        return result;
    }

    public static Role generateRole(){
        return new Role("TEST_ROLE_" + Integer.toString(++counter), "TEST_B_K_" + Integer.toString(++counter));
    }

    public static User generateUser(List<Role> roles){
        return new User("TEST_USER_" + Integer.toString(++counter), "TESTPASSWORD" + Integer.toString(++counter), roles);
    }

    public static Product generateProduct(){
        return new Product("TEST_PRODUCT_" + Integer.toString(++counter), "TEST_B_K_" + Integer.toString(++counter));
    }

    public static ProductInReservation ggenerateProductInOrder(Product product, Reservation reservation, int amount){
        return new ProductInReservation(product, reservation, amount, Integer.toString(++counter));
    }

//    public static Reservation generateOrder(User user){
//        return new Reservation("TEST_B_K_" + Integer.toString(++counter), ggenerateProductInOrder(generateProduct(),)  user, true);
//    }
//
//    public static Reservation generateOrder(User user, List<ProductInReservation> productInReservations){
//        return new Reservation("TEST_B_K_" + Integer.toString(++counter), user, true);
//    }

    public static List<User> usersFromDB(User user){
        if(user != null) users.add(user);
        return users;
    }

    public static User userFromDB(User user){
        if(user != null) MockedData.user = user;
        return user;
    }

    public static List<Role> rolesFromDB(Role role){
        if(role != null) roles.add(role);
        return roles;
    }

    public static Role roleFromDB(Role role){
        if(role != null) MockedData.role = role;
        return role;
    }

    public static List<Product> productsFromDB(Product product){
        if(product != null) products.add(product);
        return products;
    }

    public static Product productFromDB(Product product){
        if(product != null) MockedData.product = product;
        return product;
    }

    public static List<ProductInReservation> productsInOrderFromDB(ProductInReservation productInReservation){
        if(productInReservation != null) productsInOrder.add(productInReservation);
        return productsInOrder;
    }

    public static ProductInReservation productInOrderFromDB(ProductInReservation productInReservation){
        if(productInReservation != null) MockedData.productInReservation = productInReservation;
        return productInReservation;
    }

    public static List<Reservation> ordersFromDB(Reservation reservation){
        if(reservation != null) orders.add(reservation);
        return orders;
    }

    public static Reservation orderFromDB(Reservation reservation){
        if(reservation != null) MockedData.reservation = reservation;
        return reservation;
    }



}
