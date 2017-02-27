package com.restaurant.service;

import com.restaurant.dao.UserDAO;
import com.restaurant.dto.Role;
import com.restaurant.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Martha on 2/24/2017.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public User writeOrUpdateUser(User user) {
        return userDAO.writeOrUpdateUser(user);
    }

    @Override
    public User readUser(Integer userId) {
        return userDAO.readUser(userId);
    }

    @Override
    public User readUser(String username) {
        return userDAO.readUser(username);
    }

    @Override
    public boolean deleteUser(Integer userId) {
        return userDAO.deleteUser(userId);
    }

    @Override
    public boolean deleteUser(String username) {
        return userDAO.deleteUser(username);
    }

    @Override
    public List<User> getAllUsers(String role) {
        return userDAO.getAllUsers(role);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public Role writeRole(Role role) {
        return userDAO.writeRole(role);
    }

    @Override
    public List<Role> readRoles() {
        return userDAO.readRoles();
    }

    @Override
    public void addRememberMeTable() {

    }
}
