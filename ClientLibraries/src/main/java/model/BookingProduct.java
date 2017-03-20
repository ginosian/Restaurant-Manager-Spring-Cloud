package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Martha on 3/19/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingProduct {

    private String productName;
    private int productId;
    private int amount;

    public BookingProduct() {
    }

    public BookingProduct(int productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public BookingProduct(String productName, int amount) {
        this.productName = productName;
        this.amount = amount;
    }

    public int getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
