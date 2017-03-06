package com.restaurant.guest.model;

import java.io.Serializable;

/**
 * Created by Martha on 2/24/2017.
 */
public class ProductInReservation implements Serializable {

    // region Fields
    private Integer id;
    private Product product;
    private Reservation reservation;
    private int amount;
    private String number;
    // endregion

    // region Constructor
    protected ProductInReservation() {
    }

    public ProductInReservation(Product product,
                                Reservation reservation,
                                int amount,
                                String number) {
        this.product = product;
        this.reservation = reservation;
        this.amount = amount;
        this.number = number;
    }

    public ProductInReservation(Product product,
                                int amount,
                                String number) {
        this.product = product;
        this.amount = amount;
        this.number = number;
    }

    // endregion

    // region Properties
    public Integer getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public int getAmount() {
        return amount;
    }

    public String getNumber() {
        return number;
    }
    // endregion

    // region Setter

    private void setId(Integer id) {
        this.id = id;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private void setNumber(String number) {
        this.number = number;
    }
    // endregion

    // region Hashcode/equals overrides
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if ( !(other instanceof ProductInReservation) ) return false;

        final ProductInReservation order = (ProductInReservation) other;

        if (!order.getNumber().equals(getNumber())) return false;

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
