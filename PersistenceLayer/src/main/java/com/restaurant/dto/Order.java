package com.restaurant.dto;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Martha on 2/24/2017.
 */
@Entity
@Table(name = "order")
//@NamedEntityGraph(name = "graph.order.products",
//        attributeNodes = @NamedAttributeNode(value = "products", subgraph = "products"),
//        subgraphs = @NamedSubgraph(name = "products", attributeNodes = @NamedAttributeNode("product")))
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region = "order")
public class Order implements Serializable {

    // region Fields
    private Integer id;
    private String number;
    private Set<ProductInOrder> products;
    private User user;
    private boolean isOpen;
    // endregion

    // region Constructors
    protected Order() {
    }

    public Order(String number,
                 User user,
                 Set<ProductInOrder> products,
                 boolean isOpen) {
        this.number = number;
        this.products = products;
        this.user = user;
        this.isOpen = isOpen;
    }
    // endregion

    // region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
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

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    public Set<ProductInOrder> getProducts() {
        return products;
    }

    @ManyToOne
    @JoinColumn(name = "id_user",
                nullable=false)
    public User getUser() {
        return user;
    }

    @Column(name = "is_open")
    public boolean isOpen() {
        return isOpen;
    }
    // endregion

    // region Setters
    public void setProducts(Set<ProductInOrder> products) {
        this.products = products;
    }

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
        if ( !(other instanceof Order) ) return false;

        final Order order = (Order) other;

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
