package com.restaurant.dto;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Martha on 2/24/2017.
 */
@Entity
@Table(name = "productsinorder")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region = "productsinorder")
public class ProductInOrder implements Serializable {

    // region Fields
    private Integer id;
    private Product product;
    private Order order;
    private int amount;
    private String number;
    // endregion

    // region Constructor
    protected ProductInOrder() {
    }

    public ProductInOrder(Product product,
                          Order order,
                          int amount) {
        this.product = product;
        this.order = order;
        this.amount = amount;
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
    public Order getOrder() {
        return order;
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

    private void setOrder(Order order) {
        this.order = order;
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
        if ( !(other instanceof ProductInOrder) ) return false;

        final ProductInOrder order = (ProductInOrder) other;

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
