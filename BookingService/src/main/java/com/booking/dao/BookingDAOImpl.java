package com.booking.dao;

import com.booking.dto.Booking;
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
public class BookingDAOImpl implements BookingDAO {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Booking updateBooking(Booking booking) {
        Session session;
        try{
            session = getSession();
            session.update(booking);
            return booking;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Booking writeBooking(Booking booking) {
        Session session;
        try{
            session = getSession();
            session.persist(booking);
            Integer id = (Integer) session.getIdentifier(booking);
            return session.find(Booking.class, id);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean containsBookingById(int bookingId) {
        Session session;
        try{
            session = getSession();
            return session.find(Booking.class, bookingId) != null;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Booking readBooking(Integer bookingId) {
        Session session = null;
        try{
            session = getSession();
            return  session.find(Booking.class, bookingId);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Booking readBooking(String name) {
        Session session = null;
        try{
            session = getSession();
            Query query = session.createNamedQuery("Booking.getByName");
            query.setParameter("name", name);
            return (Booking) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteBooking(Integer bookingId) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**deleteBooking**");
            Booking booking = session.find(Booking.class, bookingId);
            session.delete(booking);
            return !session.contains(booking);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Booking> getAllBookings() {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**getAllBookings**");
            Query query = session.createNamedQuery("Booking.getAll");
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Booking> getAllBookingsByUserId(Integer userId) {
        Session session = null;
        try{
            session = getSession();
            Query query = session.createNamedQuery("Booking.getByUser");
            query.setParameter("userId", userId);
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Booking> getAllBookingsByRestaurantId(Integer restaurantId) {
        Session session = null;
        try{
            session = getSession();
            Query query = session.createNamedQuery("Booking.getByRestaurant");
            query.setParameter("restaurantId", restaurantId);
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
