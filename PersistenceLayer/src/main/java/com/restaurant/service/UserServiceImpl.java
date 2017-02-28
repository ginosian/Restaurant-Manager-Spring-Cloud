package com.restaurant.service;

import com.restaurant.dao.UserDAO;
import com.restaurant.dto.Role;
import com.restaurant.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Martha on 2/24/2017.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    public User createOrUpdate(User user) {
        return userDAO.writeOrUpdateUser(user);
    }

    public Role createRole(Role role) {
        return userDAO.writeRole(role);
    }
<<<<<<< Updated upstream
=======

    @Override
    public List<Role> readRoles() {
        return userDAO.readRoles();
    }

    @Override
    public void addRememberMeTable() {

    }

    @Override
    public List<Role> roles() {
        return userDAO.getAllRoles();
    }
>>>>>>> Stashed changes
}
