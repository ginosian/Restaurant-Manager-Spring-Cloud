package com.restaurant.service;

import com.restaurant.dto.Product;

/**
 * Created by Martha on 2/25/2017.
 */
public interface ProductService {

    Product createProduct(String productName);

    Product findProduct(int productId);

    Product findProduct(String productName);

    Product updateProductName(int productId, String productName);

    boolean deleteProduct(int productId);
}
