package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martha on 2/24/2017.
 */
public class Reservation implements Serializable {

    // region Fields
    private Integer id;
    private String number;
    private boolean isOpen;
    Set<ProductInReservation> products;
    // endregion

    // region Constructors
    protected Reservation() {
    }

    public Reservation(String number,
                       boolean isOpen) {
        this.number = number;
        this.isOpen = isOpen;
    }
    // endregion

    // region Properties
    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

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

    public void setProductInReservation(ProductInReservation newProduct) {
        if(products == null) products = new HashSet<>();
        products.add(newProduct);
    }

    // endregion


}
