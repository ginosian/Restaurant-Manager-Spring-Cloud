package com.user.service;

import com.user.dao.UserDAO;
import com.user.dto.Role;
import com.user.dto.User;
import com.user.util.BusKeyGen;
import com.user.util.Validate;
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
    public User createUser(String username, String password, String ... roles) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(username, password))return null;
        if(userDAO.containsUserByUsername(username)) return null;
        int index = roles.length - 1;
        Set<Role> actualRoles = new HashSet<>();
        while(index >= 0){
            Role temp = userDAO.readRole(roles[index]);
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
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(userId))return null;
        // Persist
        return userDAO.readUser(userId);
    }

    @Override
    public User findUser(String username) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(username)) return null;
        // Persist
        User user = userDAO.readUser(username);
        return user;
    }

    @Override
    public User updateUserWithARole(int userId, int roleId) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(userId, roleId))return null;
        Role role = userDAO.readRole(roleId);
        if(!userDAO.containsUserById(userId) || role == null) return null;
        // Form entity
        User user = userDAO.readUser(userId);
        user.setRole(role);
        // Persist
        return userDAO.updateUser(user);
    }

    @Override
    public boolean deleteUser(int userId) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(userId)) return false;
        // Persist
       return userDAO.deleteUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        // Persist
        return userDAO.getAllUsers();
    }

    @Override
    public List<User> getAllUsersByRole(int roleId) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(roleId)) return null;
        Role role = userDAO.readRole(roleId);
        if(!Validate.valid(role)) return null;
        // Persist
        return userDAO.getAllUsers(role.getRole());
    }

    @Override
    public Role createRole(String role) {
        //Validate  (later to be separated in validations service)
        if(!Validate.valid(role))return null;
        // Persist
        Role roleObject = new Role(role, BusKeyGen.nextKey());
        return userDAO.writeRole(roleObject);
    }

    @Override
    public List<Role> getAllRoles() {
        // Persist
        return userDAO.readRoles();
    }

}
