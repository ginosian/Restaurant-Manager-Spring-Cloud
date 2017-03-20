package com.api.service;

import com.api.dto.Restaurant;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface RestaurantService {

    Restaurant createRestaurant(String restaurantName, Integer adminId);

    Restaurant findRestaurant(int restaurantId);

    Restaurant findRestaurant(String restaurantName);

    Restaurant findRestaurantByAdmin(String adminId);

    Restaurant updateRestaurantName(int restaurantId, String restaurantName);

    boolean deleteRestaurant(int restaurantId);

    List<Restaurant> findAllRestaurants();
}
