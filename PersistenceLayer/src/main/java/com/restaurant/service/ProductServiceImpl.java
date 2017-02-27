package com.restaurant.service;

import com.restaurant.dao.ProductDAO;
import com.restaurant.dto.Product;
import com.restaurant.dto.ProductInReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;

    @Override
    public Product writeOrUpdateProduct(Product product) {
        return productDAO.writeOrUpdateProduct(product);
    }

    @Override
    public Product readProduct(Integer productId) {
        return productDAO.readProduct(productId);
    }

    @Override
    public Product readProduct(String number) {
        return productDAO.readProduct(number);
    }

    @Override
    public boolean deleteProduct(Integer productId) {
        return productDAO.deleteProduct(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public List<ProductInReservation> getAllProducts(int reservationId) {
        return productDAO.getAllProducts(reservationId);
    }

    @Override
    public ProductInReservation writeOrUpdateProductInReservation(ProductInReservation productInReservation) {
        return productDAO.writeOrUpdateProductInReservation(productInReservation);
    }

    @Override
    public ProductInReservation readProductInReservation(Integer productInReservationId) {
        return productDAO.readProductInReservation(productInReservationId);
    }

    @Override
    public ProductInReservation readProductInReservation(String number) {
        return productDAO.readProductInReservation(number);
    }

    @Override
    public boolean deleteProductInReservation(Integer productInResrevationId) {
        return productDAO.deleteProductInReservation(productInResrevationId);
    }

    @Override
    public List<Product> getAllProductsInReservation() {
        return productDAO.getAllProductsInReservation();
    }
}
