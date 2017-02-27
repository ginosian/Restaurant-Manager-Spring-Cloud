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
                name = "ProductInReservation.getByNumber",
                query = "SELECT p FROM ProductInReservation p WHERE p.number  = :" + "number",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "ProductInReservation.delete",
                query = "DELETE FROM ProductInReservation p WHERE p.id  = :" + "id",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "ProductInReservation.changeAmount",
                query = "UPDATE ProductInReservation SET amount =:" + "amount" + " WHERE id_order_product =:" + "id",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "ProductInReservation.getByReservation",
                query = "SELECT  p FROM ProductInReservation p JOIN p.reservation r WHERE r.id = :" + "id",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "ProductInReservation.addToReservation",
                query = "SELECT  p FROM ProductInReservation p JOIN p.reservation r WHERE r.id = :" + "id",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(
                name = "ProductInReservation.getAll",
                query = "FROM ProductInReservation",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
})
@Table(name = "productinreservation")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
    // endregion

    // region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_product")
    public Integer getId() {
        return id;
    }

    @OneToOne
    public Product getProduct() {
        return product;
    }

    @OneToOne
    public Reservation getReservation() {
        return reservation;
    }

    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    @Column(name = "business_key",
            unique = true,
            nullable=false,
            updatable=false)
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

    private void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    private void setAmount(int amount) {
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
