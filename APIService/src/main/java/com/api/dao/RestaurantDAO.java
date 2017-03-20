package com.api.dao;


import com.api.dto.Restaurant;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface RestaurantDAO {

    /** Updates given entity, comparing identity is its generated id
     * @param restaurant instance of {@link Restaurant}
     * @return {@link Restaurant} entity updated.*/
    Restaurant updateRestaurant(Restaurant restaurant);

    /** Persists given entity
     * @param restaurant instance of {@link Restaurant}
     * @return {@link Restaurant} entity with generated Id from db.*/
    Restaurant writeRestaurant(Restaurant restaurant);

    /** Checks by username
     * @param restaurantname unique name of restaurant
     * @return false if doesn't exist.*/
    boolean containsRestaurantByName(String restaurantname);

    /** Checks by username
     * @param restaurantId unique id of restaurant
     * @return false if doesn't exist.*/
    boolean containsRestaurantById(int restaurantId);

    /** Finds specified restaurant.
     * @param restaurantId generated id of restaurant.
     * @return {@link Restaurant} object from db or null if doesn't exist.*/
    Restaurant readRestaurant(Integer restaurantId);

    /** Finds specified restaurant.
     * @param number business key of restaurant.
     * @return {@link Restaurant} object from db or null if doesn't exist.*/
    Restaurant readRestaurant(String number);

    Restaurant readRestaurantByAdmin(Integer adminId);

    /** Deletes specified restaurant.
     * @param restaurantId generated id of restaurant.
     * @return true if restaurant was successfully deleted or did not exist.*/
    boolean deleteRestaurant(Integer restaurantId);

    /** Gets all restaurants.
     * @return list of {@link Restaurant} objects from db or if non exist return a list with size of 0.*/
    List<Restaurant> getAllRestaurants();



}
