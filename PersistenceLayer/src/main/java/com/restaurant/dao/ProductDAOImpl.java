package com.restaurant.dao;

import com.restaurant.dto.Product;
import com.restaurant.dto.ProductInReservation;
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
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @WriteUpdateTransactional
    @Override
    public Product writeOrUpdateProduct(Product product) {
        Session session = null;
        try{
            session = getSession();
            session.saveOrUpdate(product);
            Query query = session.createNamedQuery("Product.getByNumber");
            query.setParameter("number", product.getNumber());  //TODO optimize this through keeping create or update approach
            return (Product) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ReadTransactional
    @Override
    public Product readProduct(Integer productId) {
        Session session = null;
        try{
            session = getSession();
            return  session.find(Product.class, productId);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ReadTransactional
    @Override
    public Product readProduct(String number) {
        Session session = null;
        try{
            session = getSession();
            Query query = session.createNamedQuery("Product.getByNumber");
            query.setParameter("number", number);
            return (Product) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteTransactional
    @Override
    public boolean deleteProduct(Integer productId) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**deleteProduct**");
            Product product  = session.find(Product.class, productId);
            session.delete(product);
            return session.contains(product);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @ReadRowsTransactional
    @Override
    public List<Product> getAllProducts() {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**getAllProducts**");
            Query query = session.createNamedQuery("Product.getAll");
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ReadRowsTransactional
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

    @WriteUpdateTransactional
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

    @WriteUpdateTransactional
    @Override
    public ProductInReservation writeOrUpdateProductInReservation(ProductInReservation productInReservation) {
        Session session = null;
        try{
            session = getSession();
            session.saveOrUpdate(productInReservation);
            Query query = session.createNamedQuery("ProductInReservation.getByNumber");
            query.setParameter("number", productInReservation.getNumber());  //TODO optimize this through keeping create or update approach
            return (ProductInReservation) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ReadTransactional
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

    @ReadTransactional
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

    @ReadTransactional
    @Override
    public boolean deleteProductInReservation(Integer productInReserevationId) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**deleteProductInReservation**");
            ProductInReservation productInReservation  = session.find(ProductInReservation.class, productInReserevationId);
            session.delete(productInReservation);
            return session.contains(productInReservation);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @ReadRowsTransactional
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
