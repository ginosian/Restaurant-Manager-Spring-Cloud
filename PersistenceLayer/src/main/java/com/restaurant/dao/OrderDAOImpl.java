package com.restaurant.dao;

import com.restaurant.dto.Order;
import com.restaurant.dto.ProductInOrder;
import com.restaurant.dto.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO{

    public Order writeOrUpdateOrder(Order order) {
        return null;
    }

    public Order readOrder(Integer orderId) {
        return null;
    }

    public List<Order> getAllOrders(User user) {
        return null;
    }

    public boolean deleteOrder(Integer orderId) {
        return false;
    }

    public boolean deletAllOrders(User user) {
        return false;
    }

    public List<Order> getAllOrders() {
        return null;
    }

    public Order writeOrUpdateProductInOrder(Order order, ProductInOrder productInOrder) {
        return null;
    }

    public Order deleteProductFromOrder(Order order, ProductInOrder productInOrder) {
        return null;
    }
}
