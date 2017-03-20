package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Martha on 3/19/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {

    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
