package com.restaurant.dao;

import com.restaurant.dto.Role;
import com.restaurant.dto.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

    public User writeOrUpdateUser(User user) {
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

    public Role writeRole(Role role) {
        return null;
    }

    public List<Role> readRoles() {
        return null;
    }

    public void addRememberMeTable() {

    }
}
