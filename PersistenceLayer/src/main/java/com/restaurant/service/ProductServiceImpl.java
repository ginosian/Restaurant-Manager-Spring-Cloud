package com.restaurant.service;

import com.restaurant.dao.ProductDAO;
import com.restaurant.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

import static org.terracotta.modules.ehcache.ToolkitInstanceFactoryImpl.LOGGER;

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
        long startNanos = System.nanoTime();
        LOGGER.info("CREATE PRODUCT start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("CREATE PRODUCT end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return null;
    }

    @Override
    public Product findProduct(int productId) {
        long startNanos = System.nanoTime();
        LOGGER.info("FIND PRODUCT BY NAME start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("FIND PRODUCT BY NAME end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return null;
    }

    @Override
    public Product findProduct(String productName) {
        long startNanos = System.nanoTime();
        LOGGER.info("FIND PRODUCT BY NAME start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("FIND PRODUCT BY NAME end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return null;
    }

    @Override
    public Product updateProductName(int productId, String productName) {
        long startNanos = System.nanoTime();
        LOGGER.info("UPDATE PRODUCT NAME start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("UPDATE PRODUCT NAME end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        long startNanos = System.nanoTime();
        LOGGER.info("DELETE PRODUCT start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("DELETE PRODUCT end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return false;
    }
}
