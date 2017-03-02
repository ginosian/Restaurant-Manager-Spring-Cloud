package com.restaurant.service.helperModels;

/**
 * Created by Martha on 3/2/2017.
 */
public class ChooserProduct {

    private int productId;
    private int amount;

    public ChooserProduct(int productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public int getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }
}
