package com.restaurant.dto;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
                name = "Reservation.getByUser",
                query = "SELECT r FROM Reservation r JOIN r.user u WHERE u.id = :" + "id",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

})
@Table(name = "reservation")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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

    @Column(name = "isopen")
    public boolean isOpen() {
        return isOpen;
    }

    @OneToMany(fetch = FetchType.EAGER,
                cascade = {CascadeType.ALL},
                mappedBy = "reservation")
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

    private void setOpen(boolean open) {
        isOpen = open;
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
