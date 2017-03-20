package com.booking.dto;

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
                name = "Booking.getByNumber",
                query = "SELECT b FROM Booking b WHERE b.number  =:" + "number",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "Booking.getByRestaurant",
                query = "SELECT b FROM Booking b WHERE b.restaurantId  =:" + "restaurantId",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "Booking.getByReservation",
                query = "SELECT r FROM Booking r WHERE r.reservationId  =:" + "reservationId",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "Booking.getByUser",
                query = "SELECT r FROM Booking r WHERE r.userId  =:" + "userId",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "Booking.deleteById",
                query = "DELETE FROM Booking r WHERE r.id  = :" + "id",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "Booking.getAll",
                query = "FROM Booking",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
})
@Table(name = "booking")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Booking implements Serializable {

    // region Fields
    private Integer id;
    private String number;
    private Integer restaurantId;
    private Integer userId;
    private Integer reservationId;

    // endregion

    // region Constructors
    protected Booking() {
    }

    public Booking(String number, Integer restaurantId, Integer userId, Integer reservationId) {
        this.number = number;
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.reservationId = reservationId;
    }

    // endregion

    // region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    public Integer getId() {
        return id;
    }

    @Column(name = "business_key",
            unique = true,
            nullable = false,
            updatable = false)
    public String getNumber() {
        return number;
    }

    @Column(name = "restaurant_id",
            nullable = false,
            updatable = false)
    public Integer getRestaurantId() {
        return restaurantId;
    }

    @Column(name = "user_id",
            nullable = false,
            updatable = false)
    public Integer getUserId() {
        return userId;
    }

    @Column(name = "reservation_id",
            nullable = false,
            updatable = false)
    public Integer getReservationId() {
        return reservationId;
    }

    // endregion

    // region Setters

    private void setId(Integer id) {
        this.id = id;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    // endregion

    // region Hashcode/equals overrides
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if ( !(other instanceof Booking) ) return false;

        final Booking booking = (Booking) other;

        if (!booking.getNumber().equals(getNumber())) return false;

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
