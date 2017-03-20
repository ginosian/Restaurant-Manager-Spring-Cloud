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

        Restaurant restaurant1 = restaurantService.createRestaurant(MockedData.restaurantName(), 61);
        Restaurant restaurant2 = restaurantService.createRestaurant(MockedData.restaurantName(), 62);
        Restaurant restaurant3 = restaurantService.createRestaurant(MockedData.restaurantName(), 63);
        Restaurant restaurant4 = restaurantService.createRestaurant(MockedData.restaurantName(), 64);
        Restaurant restaurant5 = restaurantService.createRestaurant(MockedData.restaurantName(), 65);
        Restaurant restaurant6 = restaurantService.createRestaurant(MockedData.restaurantName(), 66);
        Restaurant restaurant7 = restaurantService.createRestaurant(MockedData.restaurantName(), 67);
        Restaurant restaurant8 = restaurantService.createRestaurant(MockedData.restaurantName(), 68);
    }
}
