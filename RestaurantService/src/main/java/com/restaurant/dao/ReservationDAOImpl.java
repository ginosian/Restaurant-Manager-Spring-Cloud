package com.restaurant.dao;

import com.restaurant.dto.ProductInReservation;
import com.restaurant.dto.Reservation;
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
public class ReservationDAOImpl implements ReservationDAO {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Reservation writeReservation(Reservation reservation) {
        Session session;
        try{
            session = getSession();
            session.persist(reservation);
            Integer id = (Integer) session.getIdentifier(reservation);
            return session.find(Reservation.class, id);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reservation readReservation(int reservationId) {
        Session session = null;
        try{
            session = getSession();
            return  session.find(Reservation.class, reservationId);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteReservation(int reservationId) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**deleteReservation**");
            Reservation reservation  = session.find(Reservation.class, reservationId);
            session.delete(reservation);
            return !session.contains(reservation);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Reservation> getAllReservations() {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**getAllReservations**");
            Query query = session.createNamedQuery("Reservation.getAll");
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProductInReservation> getAllProducts(int reservationId) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**getAllProducts**");
            Query query = session.createNamedQuery("ProductInReservation.getByReservation");
            query.setParameter("id", reservationId);
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Session session;
        try{
            session = getSession();
            session.update(reservation);
            return reservation;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProductInReservation readProductInReservation(Integer productInReservationId) {
        Session session = null;
        try{
            session = getSession();
            return  session.find(ProductInReservation.class, productInReservationId);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteProductInReservation(Integer productInReservationId) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**deleteProductInReservation**");
            ProductInReservation productInReservation  = session.find(ProductInReservation.class, productInReservationId);
            session.delete(productInReservation);
            return !session.contains(productInReservation);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ProductInReservation findProductById(Integer productInReservationId) {
        Session session = null;
        try{
            session = getSession();
            return  session.find(ProductInReservation.class, productInReservationId);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reservation> readAllClosedReservations() {
        Session session = null;
        try{
            session = getSession();
            Query query = session.createNamedQuery("Reservation.getAllClosed");
            query.setParameter("isOpen", false);
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reservation> getAllReservationsByIds(int[] id) {
        return null;
    }
}
