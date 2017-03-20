package model;

import java.io.Serializable;

/**
 * Created by Martha on 2/24/2017.
 */
public class Product implements Serializable {

    // region Fields
    private Integer id;
    private String productName;
    private String number;
    // endregion

    // region Constructors
    protected Product() {
    }

    public Product(String productName,
                   String number) {
        this.productName = productName;
        this.number = number;
    }
    // endregion

    // region Properties
    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getNumber() {
        return number;
    }
    // endregion

    // region Setters

    private void setId(Integer id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    // endregion


}
