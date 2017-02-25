package com.restaurant.dto;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Martha on 2/24/2017.
 */
@Immutable
@Entity
@Table(name = "product")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region = "product")
public class Product implements Serializable {

    // region Fields
    private Long id;
    private String name;
    private String number;
    // endregion

    // region Constructors
    protected Product() {
    }

    public Product(String name,
                   String number) {
        this.name = name;
        this.number = number;
    }
    // endregion

    // region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    public Long getId() {
        return id;
    }

    @Column(name = "name",
            unique = true,
            nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "business_key",
            unique = true,
            nullable = false,
            updatable = false)
    public String getNumber() {
        return number;
    }
    // endregion

    // region Setters

    private void setId(Long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
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
