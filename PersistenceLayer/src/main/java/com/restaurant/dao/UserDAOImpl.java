package com.restaurant.dao;

import com.restaurant.dto.Role;
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
public class UserDAOImpl implements UserDAO{

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public User writeOrUpdateUser(User user) {
        Session session = null;
        Transaction transaction = null;
        try{
             session = getSession();
            transaction = session.beginTransaction();
            return  (User) session.merge(user);
        }catch (HibernateException e) {
            e.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    public User readUser(Integer userId) {
        return null;
    }

    public User readUser(String username) {
        return null;
    }

    public boolean deleteUser(Integer userId) {
        return false;
    }

    public boolean deleteUser(String username) {
        return false;
    }

    public List<User> getAllUsers(String role) {
        return null;
    }

    public List<User> getAllUsers() {
        return null;
    }

<<<<<<< Updated upstream
=======
    @ReadRowsTransactional
    @Override
    public List<Role> getAllRoles() {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**getAllRoles**");
            Query query = session.createNamedQuery("Role.getAllRoles");
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @WriteUpdateTransactional
    @Override
>>>>>>> Stashed changes
    public Role writeRole(Role role) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = getSession();
            transaction = session.beginTransaction();
            return  (Role) session.merge(role);
        }catch (HibernateException e) {
            e.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    public List<Role> readRoles() {
        return null;
    }

    public void addRememberMeTable() {
//        Session session = null;
//        try {
//            session = getSession();
//            session.createSQLQuery(HibernateQueries.createRememberMeTable).executeUpdate();
//        } catch (HibernateException e){
//            e.printStackTrace();
//        }
    }
}
