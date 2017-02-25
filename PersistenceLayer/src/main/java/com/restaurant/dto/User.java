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
@Table(name = "user")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region = "user")
//@NamedEntityGraph(name = "graph.Order.orders",
//        attributeNodes = @NamedAttributeNode(value = "orders", subgraph = "orders"),
//        subgraphs = @NamedSubgraph(name = "orders", attributeNodes = @NamedAttributeNode("order")))
public class User implements Serializable {

    // region Fields
    private Integer id;
    private String username;
    private String password;
    private List<Role> roles;
    private List<Order> orders;
    // endregion

    // region Constructors
    protected User() {
    }

    public User(String username,
                String password,
                List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    // endregion

    // region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    public Integer getId() {
        return id;
    }

    @Column( name = "password" )
//    @ColumnTransformer( write = "EncryptByPassPhrase('12',?)",
//                        read = "DECRYPTBYPASSPHRASE ('12',password)")
    public String getPassword() {
        return password;
    }

    @Column(name = "username",
            unique = true,
            nullable = false,
            updatable = false)
    public String getUsername() {
        return username;
    }

    @OneToMany(cascade = {CascadeType.ALL},
               orphanRemoval = false)
    public List<Role> getRoles() {
        return roles;
    }

    @OneToMany(targetEntity = Order.class,
               cascade = {CascadeType.ALL},
               orphanRemoval = true)
    public List<Order> getOrders() {
        return orders;
    }
    // endregion

    // region Setters
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    // endregion
}
