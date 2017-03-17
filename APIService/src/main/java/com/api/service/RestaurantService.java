package com.api.service;

import com.api.dto.Restaurant;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface RestaurantService {

    Restaurant createRestaurant(String restaurantName);

    Restaurant findRestaurant(int restaurantId);

    Restaurant findRestaurant(String restaurantName);

    Restaurant updateRestaurantName(int restaurantId, String restaurantName);

    boolean deleteRestaurant(int restaurantId);

    List<Restaurant> findAllRestaurants();
}
