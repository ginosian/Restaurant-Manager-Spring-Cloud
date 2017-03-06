package com.restaurant.restaurant.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martha on 2/24/2017.
 */
public class Reservation implements Serializable {

    // region Fields
    private Integer id;
    private String number;
    private User user;
    private boolean isOpen;
    Set<ProductInReservation> products;
    // endregion

    // region Constructors
    protected Reservation() {
    }

    public Reservation(String number,
                       User user,
                       boolean isOpen) {
        this.number = number;
        this.user = user;
        this.isOpen = isOpen;
    }
    // endregion

    // region Properties
    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public User getUser() {
        return user;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public Set<ProductInReservation> getProducts() {
        return products;
    }

    // endregion

    // region Setters
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    private void setUser(User user) {
        this.user = user;
    }

    public void setProducts(Set<ProductInReservation> products) {
        this.products = products;
    }

    public void setProductInReservation(ProductInReservation newProduct) {
        if(products == null) products = new HashSet<>();
        products.add(newProduct);
    }
    // endregion

    // region Hashcode/equals overrides
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if ( !(other instanceof Reservation) ) return false;

        final Reservation reservation = (Reservation) other;

        if (!reservation.getNumber().equals(getNumber())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        return result;
    }
    // endregion

}
