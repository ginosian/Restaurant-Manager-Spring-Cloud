package com.api.service;

import model.RestaurantCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Martha on 3/19/2017.
 */
@Repository
public class OauthConnectionServiceImpl implements OauthConnectionService {

    private static final String USER_SERVICE_URL = "http://user";

    @Autowired
    RestTemplate restTemplate;

//    @Autowired
//    @Qualifier("myRestTemplate")
//    private OAuth2RestOperations restTemplate;
//
//    @Autowired
//    @Qualifier("myClientOnlyRestTemplate")
//    private OAuth2RestOperations clientOnlyrestTemplate;

    @Override
    public Integer createUser(String username, String password, String token) {
        final String uri = USER_SERVICE_URL + "/user";

        // Forms request header
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.set("Authorization", token);
        header.set("Content-Type", "application/json;charset=UTF-8");

//         Forms request body
        RestaurantCreation restaurantCreation = new RestaurantCreation(username, password, "RESTAURANT", null);

        HttpEntity<Object> httpEntity = new HttpEntity<>(restaurantCreation, header);

        ResponseEntity<Integer> userId = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Integer.class);
        return userId.getBody();
    }

    @Override
    public Integer getRoleId(String role, String token) {
        return null;
    }
}
