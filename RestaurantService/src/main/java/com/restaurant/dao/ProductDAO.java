package com.restaurant.dao;

import com.restaurant.dto.Product;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface ProductDAO {

    /** Updates given entity, comparing identity is its generated id
     * @param product instance of {@link Product}
     * @return {@link Product} entity updated.*/
    Product updateProduct(Product product);

    /** Persists given entity
     * @param product instance of {@link Product}
     * @return {@link Product} entity with generated Id from db.*/
    Product writeProduct(Product product);

    /** Checks by username
     * @param productNumber unique uuid of product
     * @return false if doesn't exist.*/
    boolean containsProductByNumber(String productNumber);

    /** Checks by username
     * @param productId unique id of product
     * @return false if doesn't exist.*/
    boolean containsProductById(int productId);

    /** Finds specified product.
     * @param productId generated id of product.
     * @return {@link Product} object from db or null if doesn't exist.*/
    Product readProduct(Integer productId);

    /** Deletes specified product.
     * @param productId generated id of product.
     * @return true if product was successfully deleted or did not exist.*/
    boolean deleteProduct(Integer productId);

    /** Gets all products by restaurant.
     * @return list of {@link Product} objects from db or if non exist return a list with size of 0.*/
    List<Product> getAllProducts(Integer restaurantId);

    List<Product> getAllProducts();


}
