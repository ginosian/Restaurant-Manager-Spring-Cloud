package com.restaurant.admin.model;

import java.io.Serializable;

/**
 * Created by Martha on 2/24/2017.
 */
public class Product implements Serializable {

    // region Fields
    private Integer id;
    private String productName;
    private String number;
    // endregion

    // region Constructors
    protected Product() {
    }

    public Product(String productName,
                   String number) {
        this.productName = productName;
        this.number = number;
    }
    // endregion

    // region Properties
    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getNumber() {
        return number;
    }
    // endregion

    // region Setters

    private void setId(Integer id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private void setNumber(String number) {
        this.number = number;
    }
    // endregion

    // region Hashcode/equals overrides
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if ( !(other instanceof Product) ) return false;

        final Product order = (Product) other;

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
