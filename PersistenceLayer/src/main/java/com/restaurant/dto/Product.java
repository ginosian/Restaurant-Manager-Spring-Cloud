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
@NamedQueries({
        @NamedQuery(
                name = "Product.getByNumber",
                query = "SELECT p FROM Product p WHERE p.number  =:" + "number",
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
                name = "Product.getByName",
                query = "SELECT p FROM Product p WHERE p.product_name = :" + "product_name",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
})
@Table(name = "product")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product implements Serializable {

    // region Fields
    private Integer id;
    private String product_name;
    private String number;
    // endregion

    // region Constructors
    protected Product() {
    }

    public Product(String product_name,
                   String number) {
        this.product_name = product_name;
        this.number = number;
    }
    // endregion

    // region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    public Integer getId() {
        return id;
    }

    @Column(name = "product_name",
            unique = true,
            nullable = false)
    public String getProduct_name() {
        return product_name;
    }

    @Column(name = "business_key'",
            unique = true,
            nullable = false,
            updatable = false)
    public String getNumber() {
        return number;
    }
    // endregion

    // region Setters

    private void setId(Integer id) {
        this.id = id;
    }

    private void setProduct_name(String product_name) {
        this.product_name = product_name;
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
