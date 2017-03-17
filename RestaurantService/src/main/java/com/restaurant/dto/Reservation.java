package com.restaurant.dto;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martha on 2/24/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Reservation.getAll",
                query = "FROM Reservation",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "Reservation.getAllClosed",
                query = "SELECT r FROM Reservation r WHERE r.isOpen = :" + "isOpen",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

})
@Table(name = "reservation")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Reservation implements Serializable {

    // region Fields
    private Integer id;
    private Integer restaurantId;
    private String number;
    private boolean isOpen;
    Set<ProductInReservation> products;
    // endregion

    // region Constructors
    protected Reservation() {
    }

    public Reservation(String number,
                       boolean isOpen,
                       Integer restaurantId) {
        this.number = number;
        this.isOpen = isOpen;
        this.restaurantId = restaurantId;
    }
    // endregion

    // region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    public Integer getId() {
        return id;
    }

    @Column(name = "restaurant_id")
    public Integer getRestaurantId() {
        return restaurantId;
    }

    @Column(name = "business_key",
            unique = true,
            nullable = false,
            updatable = false)
    public String getNumber() {
        return number;
    }

    @Column(name = "isopen")
    @Type(type = "true_false")
    public boolean getIsOpen() {
        return isOpen;
    }

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL},
            orphanRemoval = true)
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

    public void setProducts(Set<ProductInReservation> products) {
        this.products = products;
    }

    @javax.persistence.Transient
    public void setProductInReservation(ProductInReservation newProduct) {
        if(products == null) products = new HashSet<>();
        products.add(newProduct);
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
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
