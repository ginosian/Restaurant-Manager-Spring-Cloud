package com.api.util;

import com.api.dto.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martha on 2/26/2017.
 */
public class MockedData {
    public static int counter;

    private static Restaurant restaurant;
    private static Set<Restaurant> restaurants = new HashSet<>();

    public static Restaurant generateProduct(){
        return new Restaurant("TEST_PRODUCT_" + Integer.toString(++counter), "TEST_B_K_" + Integer.toString(++counter));
    }

    public static Set<Restaurant> productsFromDB(Restaurant restaurant){
        if(restaurant != null) restaurants.add(restaurant);
        return restaurants;
    }

    public static Restaurant productFromDB(Restaurant restaurant){
        if(restaurant != null) MockedData.restaurant = restaurant;
        return restaurant;
    }

    public static String roleName(){
        return "Test_ROLE_" + Integer.toString(++counter);
    }

    public static String userName(){
        return "Test_User_" + Integer.toString(++counter);
    }

    public static String productName(){
        return "Test_Product_" + Integer.toString(++counter);
    }

    public static String password(){
        return "Test_Password_" + Integer.toString(++counter);
    }

    public static String uuid(){
        return "Test_UUID_" + Integer.toString(++counter);
    }



}
