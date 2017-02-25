package com.restaurant.dao;

import com.restaurant.dto.Product;
import com.restaurant.dto.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO{

    public Product writeOrUpdateProduct(Product product) {
        return null;
    }

    public Product readProduct(Integer productId) {
        return null;
    }

    public List<Product> getAllProducts(User user) {
        return null;
    }

    public boolean deleteProduct(Integer productId) {
        return false;
    }

    public boolean deletAllProducts(User user) {
        return false;
    }

    public List<Product> getAllProducts() {
        return null;
    }
}
