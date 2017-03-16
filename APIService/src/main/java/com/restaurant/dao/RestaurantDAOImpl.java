package com.restaurant.dao;

import com.restaurant.dto.Restaurant;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class RestaurantDAOImpl implements RestaurantDAO {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        Session session;
        try{
            session = getSession();
            session.update(restaurant);
            return restaurant;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Restaurant writeRestaurant(Restaurant restaurant) {
        Session session;
        try{
            session = getSession();
            session.persist(restaurant);
            Integer id = (Integer) session.getIdentifier(restaurant);
            return session.find(Restaurant.class, id);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean containsRestaurantByName(String restaurantName) {
        Session session;
        try{
            session = getSession();
            Query query = session.createNamedQuery("Restaurant.getByName");
            query.setParameter("name", restaurantName);
            return query.getResultList().size() != 0;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean containsRestaurantById(int restaurantId) {
        Session session;
        try{
            session = getSession();
            return session.find(Restaurant.class, restaurantId) != null;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Restaurant readRestaurant(Integer restaurantId) {
        Session session = null;
        try{
            session = getSession();
            return  session.find(Restaurant.class, restaurantId);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Restaurant readRestaurant(String name) {
        Session session = null;
        try{
            session = getSession();
            Query query = session.createNamedQuery("Restaurant.getByName");
            query.setParameter("name", name);
            return (Restaurant) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteRestaurant(Integer restaurantId) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**deleteRestaurant**");
            Restaurant restaurant = session.find(Restaurant.class, restaurantId);
            session.delete(restaurant);
            return !session.contains(restaurant);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**getAllRestaurants**");
            Query query = session.createNamedQuery("Restaurant.getAll");
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

}
