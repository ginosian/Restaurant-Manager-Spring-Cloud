package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Martha on 3/17/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantCreation {
    private String restaurantName;
    private String username;
    private String password;
    private String role;

    public RestaurantCreation() {
    }

    public RestaurantCreation(String username, String password, String role, String restaurantName) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.restaurantName = restaurantName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

}
