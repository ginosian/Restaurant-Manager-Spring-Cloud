package com.restaurant.dao;

import com.restaurant.dto.Product;
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
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public Product writeOrUpdateProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = getSession();
            transaction = session.beginTransaction();
            return  (Product) session.merge(product);
        }catch (HibernateException e) {
            e.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    public Product readProduct(Integer productId) {
        return null;
    }

    public List<Product> getAllProducts(User user) {
        return null;
    }

    public boolean deleteProduct(Integer productId) {
        return false;
    }

    public boolean deletAllProducts(User user) {
        return false;
    }

<<<<<<< Updated upstream
    public List<Product> getAllProducts() {
=======
    @ReadRowsTransactional
    @Override
    public List<ProductInReservation> getAllProductsInReservation() {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**getAllProductsInReservation**");
            Query query = session.createNamedQuery("ProductInReservation.getAll");
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
>>>>>>> Stashed changes
        return null;
    }
}
