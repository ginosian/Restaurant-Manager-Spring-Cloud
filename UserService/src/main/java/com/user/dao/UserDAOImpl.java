package com.user.dao;

import com.user.dto.Role;
import com.user.dto.User;
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
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User updateUser(User user) {
        Session session;
        try{
            session = getSession();
            session.persist(user);
            Integer id = (Integer) session.getIdentifier(user);
            return session.find(User.class, id);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User writeUser(User user) {
        Session session;
        try{
            session = getSession();
            session.persist(user);
            Integer id = (Integer) session.getIdentifier(user);
            return session.find(User.class, id);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean containsUserByUsername(String username) {
        Session session;
        try{
            session = getSession();
            Query query = session.createNamedQuery("User.getUserByUsername");
            query.setParameter("username", username);
            return query.getResultList().size() != 0;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean containsUserById(int userId) {
        Session session;
        try{
            session = getSession();
            return session.find(User.class, userId) != null;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User readUser(Integer userId) {
        Session session;
        try{
            session = getSession();
            return  session.find(User.class, userId);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User readUser(String username) {
        Session session;
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

    @Override
    public boolean deleteUser(Integer userId) {
        Session session;
        try{
            session = getSession();
            System.out.println("*****Transaction is active ********" + TransactionSynchronizationManager.isActualTransactionActive() + "**deleteUser**");
            User user  = session.find(User.class, userId);
            session.delete(user);
            return !session.contains(user);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAllUsers(String role) {
        Session session;
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

    @Override
    public List<User> getAllUsers() {
        Session session;
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

    @Override
    public Role writeRole(Role role) {

        Session session;
        try{
            session = getSession();
            session.persist(role);
            Integer id = (Integer) session.getIdentifier(role);
            return session.find(Role.class, id);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Role> readRoles() {
        Session session;
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

    @Override
    public Role readRole(String role) {
        Session session;
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

    @Override
    public Role readRole(int roleId) {
        Session session;
        try{
            session = getSession();
            return  session.find(Role.class, roleId);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
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
