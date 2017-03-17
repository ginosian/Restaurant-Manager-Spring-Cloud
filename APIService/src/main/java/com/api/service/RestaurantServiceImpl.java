package com.api.service;

import com.api.dao.RestaurantDAO;
import com.api.dto.Restaurant;
import com.api.util.BusKeyGen;
import com.api.util.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantDAO restaurantDAO;

    @Override
    public Restaurant createRestaurant(String restaurantName) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(restaurantName))return null;
        if(restaurantDAO.containsRestaurantByName(restaurantName))return null;
        // Operate
        Restaurant restaurantObject = new Restaurant(restaurantName, BusKeyGen.nextKey());
        return restaurantDAO.writeRestaurant(restaurantObject);
    }

    @Override
    public Restaurant findRestaurant(int restaurantId) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(restaurantId))return null;
        if(!restaurantDAO.containsRestaurantById(restaurantId))return null;
        // Persist
        return restaurantDAO.readRestaurant(restaurantId);
    }

    @Override
    public Restaurant findRestaurant(String restaurantName) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(restaurantName)) return null;
        // Persist
        return restaurantDAO.readRestaurant(restaurantName);
    }

    @Override
    public Restaurant updateRestaurantName(int restaurantId, String restaurantName) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(restaurantName, restaurantId))return null;
        Restaurant restaurant = restaurantDAO.readRestaurant(restaurantId);
        if(restaurant == null) return null;
        // Form entity
        restaurant.setName(restaurantName);
        // Persist
        return restaurantDAO.updateRestaurant(restaurant);
    }

    @Override
    public boolean deleteRestaurant(int restaurantId) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(restaurantId)) return false;
        // Persist
        return restaurantDAO.deleteRestaurant(restaurantId);
    }

    @Override
    public List<Restaurant> findAllRestaurants() {
        return restaurantDAO.getAllRestaurants();
    }
}
