package com.restaurant.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Martha on 2/25/2017.
 */
@Repository
public class ServiceImpl implements Service{
    private static final String SERVICE_URL = "http://persistence-microservice";

    @Autowired
    RestTemplate restTemplate;

    public Object getEntity(){
        return restTemplate.getForObject(SERVICE_URL + "/user", Object.class);
    }
}
