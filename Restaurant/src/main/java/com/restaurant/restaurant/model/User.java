package com.restaurant.restaurant.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martha on 2/24/2017.
 */
public class User implements Serializable {

    // region Fields
    private Integer id;
    private String username;
    private String password;
    private Set<Role> roles;
    private Set<Reservation> reservations;
    // endregion

    // region Constructors
    protected User() {
    }

    public User(String username,
                String password,
                Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    // endregion

    // region Properties
    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }
    // endregion

    // region Setters
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    private void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setReservations(Reservation reservation) {
        if(reservations == null) reservations = new HashSet<>();
        reservations.add(reservation);
    }

    public void setRole(Role role) {
        if(roles == null) roles = new HashSet<>();
        roles.add(role);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    // endregion

    // region Hashcode/equals overrides
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if ( !(other instanceof User) ) return false;

        final User user = (User) other;

        if (!user.getUsername().equals(getUsername())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        return result;
    }
    // endregion
}
