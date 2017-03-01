package com.restaurant.dao;

import com.restaurant.dto.Product;
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
    public ProductInReservation changeAmount(int productInReservationId, int amount) {
        Session session = null;
        try{
            session = getSession();
            Query query = session.createNamedQuery("ProductInReservation.changeAmount");
            query.setParameter("amount", amount);
            query.setParameter("id_order_product", productInReservationId);
            return (ProductInReservation) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProductInReservation writeProductInReservation(ProductInReservation productInReservation) {
        Session session;
        try{
            session = getSession();
            session.persist(productInReservation);
            Integer id = (Integer) session.getIdentifier(productInReservation);
            return session.find(ProductInReservation.class, id);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProductInReservation updateProductInReservation(ProductInReservation productInReservation) {
        Session session;
        try{
            session = getSession();
            session.update(productInReservation);
            return productInReservation;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean reservationContainsProduct(int reservationId, int productId) {
        Session session;
        try{
            session = getSession();
            Query query = session.createNamedQuery("ProductInReservation.containedInReservation");
            query.setParameter("reservationId", reservationId);
            query.setParameter("productId", productId);
            return query.getResultList().size() != 0;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
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
    public ProductInReservation readProductInReservation(String number) {
        Session session = null;
        try{
            session = getSession();
            Query query = session.createNamedQuery("ProductInReservation.getByNumber");
            query.setParameter("number", number);
            return (ProductInReservation) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteProductInReservation(Integer productInReserevationId) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**deleteProductInReservation**");
            ProductInReservation productInReservation  = session.find(ProductInReservation.class, productInReserevationId);
            session.delete(productInReservation);
            return !session.contains(productInReservation);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getAllProductsInReservation() {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**getAllProductsInReservation**");
            Query query = session.createNamedQuery("ProductInReservation.getAll");
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
