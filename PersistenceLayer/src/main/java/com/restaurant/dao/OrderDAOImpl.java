package com.restaurant.dao;

import com.restaurant.dto.Order;
import com.restaurant.dto.ProductInOrder;
import com.restaurant.dto.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public Order writeOrUpdateOrder(Order order) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = getSession();
            transaction = session.beginTransaction();
            return  (Order) session.merge(order);
        }catch (HibernateException e) {
            e.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
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
