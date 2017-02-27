package com.restaurant.dto;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Martha on 2/24/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Reservation.getByNumber",
                query = "SELECT r FROM Reservation r WHERE r.number  = :" + "number"),
        @NamedQuery(
                name = "Reservation.deleteById",
                query = "DELETE FROM Reservation r WHERE r.id  = :" + "id"),
        @NamedQuery(
                name = "Reservation.getAll",
                query = "FROM Reservation"),
        @NamedQuery(
                name = "Reservation.changeState",
                query = "UPDATE Reservation SET isOpen  =:" + "isOpen" + " WHERE id_order_product =:" + "id"),
        @NamedQuery(
                name = "Reservation.getByUser",
                query = "SELECT r FROM Reservation r JOIN r.user u WHERE u.id = :" + "id")

})
@Table(name = "reservation")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Reservation implements Serializable {

    // region Fields
    private Integer id;
    private String number;
    private User user;
    private boolean isOpen;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
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

    @ManyToOne
    public User getUser() {
        return user;
    }

    @Column(name = "is_open")
    public boolean isOpen() {
        return isOpen;
    }
    // endregion

    // region Setters
    public void setIsOpen(boolean isOpen) {
        isOpen = isOpen;
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

    private void setOpen(boolean open) {
        isOpen = open;
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
