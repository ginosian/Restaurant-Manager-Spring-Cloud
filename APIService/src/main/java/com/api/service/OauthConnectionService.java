package com.api.service;

/**
 * Created by Martha on 3/19/2017.
 */
public interface OauthConnectionService {
    Integer createUser(String username, String password, String token);

    Integer getRoleId(String role, String token);

}
