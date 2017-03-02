package com.restaurant.dao;

import com.restaurant.dto.Product;
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
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Product updateProduct(Product product) {
        Session session;
        try{
            session = getSession();
            session.update(product);
            return product;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product writeProduct(Product product) {
        Session session;
        try{
            session = getSession();
            session.persist(product);
            Integer id = (Integer) session.getIdentifier(product);
            return session.find(Product.class, id);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean containsProductByName(String productName) {
        Session session;
        try{
            session = getSession();
            Query query = session.createNamedQuery("Product.getByName");
            query.setParameter("product_name", productName);
            return query.getResultList().size() != 0;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean containsProductById(int productId) {
        Session session;
        try{
            session = getSession();
            return session.find(Product.class, productId) != null;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

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

    @Override
    public boolean deleteProduct(Integer productId) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**deleteProduct**");
            Product product  = session.find(Product.class, productId);
            session.delete(product);
            return !session.contains(product);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

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

}
