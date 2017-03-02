package com.restaurant.service;

import com.restaurant.dao.UserDAO;
import com.restaurant.dto.Role;
import com.restaurant.dto.User;
import com.restaurant.util.BusKeyGen;
import com.restaurant.util.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Martha on 2/24/2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public User createUser(String username, String password, Role ... roles) {
        // Validate args
        if(!Validate.valid(username, password))return null;
        if(userDAO.containsUserByUsername(username)) return null;
        int index = roles.length - 1;
        Set<Role> actualRoles = new HashSet<>();
        while(index >= 0){
            Role temp = userDAO.readRole(roles[index].getId());
            if( temp != null) actualRoles.add(temp);
            index--;
        }
        if(actualRoles.size() == 0)return null;
        // Form entity
        User user = new User(username, password, actualRoles);
        // Persist
        User result = userDAO.writeUser(user);
        return result;
    }

    @Override
    public User findUser(int userId) {
        // Validate args
        if(!Validate.valid(userId))return null;
        // Persist
        User user = userDAO.readUser(userId);
        return user;
    }

    @Override
    public User findUser(String username) {
        // Validate args
        if(!Validate.valid(username)) return null;
        // Persist
        User user = userDAO.readUser(username);
        return user;
    }

    @Override
    public User updateUserWithARole(int userId, int roleId) {
        // Validate
        if(!Validate.valid(userId, roleId))return null;
        Role role = userDAO.readRole(roleId);
        if(!userDAO.containsUserById(userId) || role == null) return null;
        // Form entity
        User user = userDAO.readUser(userId);
        user.setRole(role);
        // Persist
        User result = userDAO.updateUser(user);
        return user;
    }

    @Override
    public boolean deleteUser(int userId) {
        // Validate
        if(!Validate.valid(userId)) return false;
        // Persist
       return userDAO.deleteUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        // Persist
        List<User> users = userDAO.getAllUsers();
        return users;
    }

    @Override
    public List<User> getAllUsersByRole(int roleId) {
        // Validate
        if(!Validate.valid(roleId)) return null;
        Role role = userDAO.readRole(roleId);
        if(!Validate.valid(role)) return null;
        // Persist
        List<User> users = userDAO.getAllUsers(role.getRole());
        return users;
    }

    @Override
    public Role createRole(String role) {
        // Validate args
        if(!Validate.valid(role))return null;
        // Persist
        Role roleObject = new Role(role, BusKeyGen.nextKey());
        Role result = userDAO.writeRole(roleObject);
        return result;
    }

    @Override
    public List<Role> getAllRoles() {
        // Persist
        List<Role> roles = userDAO.readRoles();
        return roles;
    }

}
