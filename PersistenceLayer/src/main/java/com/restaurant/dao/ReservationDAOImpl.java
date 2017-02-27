package com.restaurant.dao;

import com.restaurant.dto.Reservation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@Repository
@Transactional
public class ReservationDAOImpl implements ReservationDAO {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @WriteUpdateTransactional
    @Override
    public Reservation writeOrUpdateReservation(Reservation reservation) {
        Session session = null;
        try{
            session = getSession();
            session.saveOrUpdate(reservation);
            Query query = session.createNamedQuery("Reservation.getByNumber");
            query.setParameter("number", reservation.getNumber());  //TODO optimize this through keeping create or update approach
            return (Reservation) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ReadRowsTransactional
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

    @ReadTransactional
    @Override
    public Reservation readReservation(String number) {
        Session session = null;
        try{
            session = getSession();
            Query query = session.createNamedQuery("Reservation.getByNumber");
            query.setParameter("number", number);
            return (Reservation) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteTransactional
    @Override
    public boolean deleteReservation(int reservationId) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**deleteReservation**");
            Reservation reservation  = session.find(Reservation.class, reservationId);
            session.delete(reservation);
            return session.contains(reservation);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @ReadRowsTransactional
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

    @ReadRowsTransactional
    @Override
    public List<Reservation> getAllReservationsByUser(int userId) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**getAllReservationsByUser**");
            Query query = session.createNamedQuery("Reservation.getByUser");
            query.setParameter("id", userId);
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @WriteUpdateTransactional
    @Override
    public Reservation changeReservationState(int reservationId, boolean isActive) {
        Session session = null;
        try{
            session = getSession();
            Query query = session.createNamedQuery("Reservation.changeState");
            query.setParameter("isOpen", isActive);
            query.setParameter("id_order_product", reservationId);
            return (Reservation) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
