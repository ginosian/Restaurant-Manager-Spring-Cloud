package com.restaurant.dao;

import com.restaurant.dto.Role;
import com.restaurant.dto.User;
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
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @WriteUpdateTransactional
    @Override
    public User writeOrUpdateUser(User user) {
        Session session = null;
        try{
             session = getSession();
            session.saveOrUpdate(user);
            Query query = session.createNamedQuery("User.getUserByUsername");
            query.setParameter("username", user.getUsername());  //TODO optimize this through keeping create or update approach
            return (User) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ReadTransactional
    @Override
    public User readUser(Integer userId) {
        Session session = null;
        try{
            session = getSession();
            return  session.find(User.class, userId);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ReadRowsTransactional
    @Override
    public User readUser(String username) {
        Session session = null;
        try{
            session = getSession();
            Query query = session.createNamedQuery("User.getUserByUsername");
            query.setParameter("username", username);
            return (User) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteTransactional
    @Override
    public boolean deleteUser(Integer userId) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**deleteUser**");
            User user  = session.find(User.class, userId);
            session.delete(user);
            return session.contains(user);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @DeleteTransactional
    @Override
    public boolean deleteUser(String username) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**deleteUser**");
            Query query = session.createNamedQuery("User.deleteUserByUsername");
            query.setParameter("username", username);
            query.executeUpdate();
            return true;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @ReadRowsTransactional
    @Override
    public List<User> getAllUsers(String role) {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**getAllUsers**");
            Query query = session.createNamedQuery("User.getUsersByRole");
            query.setParameter("role", role);
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ReadRowsTransactional
    @Override
    public List<User> getAllUsers() {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**getAllUsers**");
            Query query = session.createNamedQuery("User.getAllUsers");
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @WriteUpdateTransactional
    @Override
    public Role writeRole(Role role) {
        Session session = null;
        try{
            session = getSession();
            session.saveOrUpdate(role);
            Query query = session.createNamedQuery("Role.getRoleByRole");
            query.setParameter("role", role.getRole());  //TODO optimize this through keeping create or update approach
            return (Role) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @WriteUpdateTransactional
    @Override
    public List<Role> readRoles() {
        Session session = null;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**readRoles**");
            Query query = session.createNamedQuery("Role.getAllRoles");
            return query.getResultList();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ReadRowsTransactional
    @Override
    public Role readRole(String role) {
        Session session = null;
        try{
            session = getSession();
            Query query = session.createNamedQuery("Role.getRoleByRole");
            query.setParameter("role", role);
            return (Role) query.getSingleResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @WriteUpdateTransactional
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
