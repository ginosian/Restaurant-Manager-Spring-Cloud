package com.restaurant.service;

import com.restaurant.dao.ProductDAO;
import com.restaurant.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Martha on 2/25/2017.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;

    public Product createOrUpdate(Product product) {
        return productDAO.writeOrUpdateProduct(product);
    }
}
