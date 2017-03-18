package com.api.dataLoader;

import com.api.dto.Restaurant;
import com.api.service.RestaurantService;
import com.api.util.MockedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Martha on 3/18/2017.
 */

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    RestaurantService restaurantService;

    @Autowired
    public void setRestaurantService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Restaurant restaurant1 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant2 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant3 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant4 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant5 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant6 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant7 = restaurantService.createRestaurant(MockedData.restaurantName());
        Restaurant restaurant8 = restaurantService.createRestaurant(MockedData.restaurantName());
    }
}
