package com.restaurant.service;

import com.restaurant.dao.OrderDAO;
import com.restaurant.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Martha on 2/25/2017.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDAO orderDAO;

    public Order createOrUpdate(Order order) {
        return orderDAO.writeOrUpdateOrder(order);
    }
}
