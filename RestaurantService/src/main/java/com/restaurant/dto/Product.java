package com.restaurant.dto;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Martha on 2/24/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Product.getByRestaurant",
                query = "SELECT p FROM Product p WHERE p.restaurantId  =:" + "restaurantId",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "Product.deleteById",
                query = "DELETE FROM Product p WHERE p.id  = :" + "id",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "Product.getAll",
                query = "FROM Product",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "Product.getByNumber",
                query = "SELECT p FROM Product p WHERE p.number  = :" + "number",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
})
@Table(name = "product")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product implements Serializable {

    // region Fields
    private Integer id;
    private Integer restaurantId;
    private String productName;
    private String number;
    // endregion

    // region Constructors
    protected Product() {
    }

    public Product(String productName,
                   String number,
                   int restaurantId) {
        this.productName = productName;
        this.number = number;
        this.restaurantId = restaurantId;
    }
    // endregion

    // region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    public Integer getId() {
        return id;
    }

    @Column(name = "productName",
            nullable = false)
    public String getProductName() {
        return productName;
    }

    @Column(name = "business_key",
            unique = true,
            nullable = false,
            updatable = false)
    public String getNumber() {
        return number;
    }

    @Column(name = "restaurant_id")
    public Integer getRestaurantId() {
        return restaurantId;
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

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
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
