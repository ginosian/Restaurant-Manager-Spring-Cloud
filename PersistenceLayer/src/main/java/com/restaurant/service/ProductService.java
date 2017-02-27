package com.restaurant.service;

import com.restaurant.dto.Product;
import com.restaurant.dto.ProductInReservation;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface ProductService {

    /** Checks by product generated id, if product exists updates it, if not creates new product.
     * @param product instance of {@link Product}
     * @return {@link Product} object from db or null if doesn't exist.*/
    Product writeOrUpdateProduct(Product product);

    /** Finds specified product.
     * @param productId generated id of product.
     * @return {@link Product} object from db or null if doesn't exist.*/
    Product readProduct(Integer productId);

    /** Finds specified product.
     * @param number business key of product.
     * @return {@link Product} object from db or null if doesn't exist.*/
    Product readProduct(String number);

    /** Deletes specified product.
     * @param productId generated id of product.
     * @return true if product was successfully deleted or did not exist.*/
    boolean deleteProduct(Integer productId);

    /** Gets all products.
     * @return list of {@link Product} objects from db or if non exist return a list with size of 0.*/
    List<Product> getAllProducts();

    /** Gets all Products list within reservation.
     * @return list of {@link ProductInReservation} objects from db or if non exist return a list with size of 0.*/
    List<ProductInReservation> getAllProducts(int reservationId);

    ProductInReservation writeOrUpdateProductInReservation(ProductInReservation productInReservation);
    ProductInReservation readProductInReservation(Integer productInReservationId);
    ProductInReservation readProductInReservation(String number);
    boolean deleteProductInReservation(Integer productInResrevationId);
    List<Product> getAllProductsInReservation();
}
