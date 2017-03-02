package com.restaurant.service;

import com.restaurant.dao.ProductDAO;
import com.restaurant.dto.Product;
import com.restaurant.util.BusKeyGen;
import com.restaurant.util.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Martha on 2/25/2017.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;

    @Override
    public Product createProduct(String productName) {
        // Validate args
        if(!Validate.valid(productName))return null;
        if(productDAO.containsProductByName(productName))return null;
        // Operate
        Product productObject = new Product(productName, BusKeyGen.nextKey());
        return productDAO.writeProduct(productObject);
    }

    @Override
    public Product findProduct(int productId) {

        return null;
    }

    @Override
    public Product findProduct(String productName) {

        return null;
    }

    @Override
    public Product updateProductName(int productId, String productName) {

        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {

        return false;
    }
}
