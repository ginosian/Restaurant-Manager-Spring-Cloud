package com.restaurant.dao;

import com.restaurant.dto.Role;
import com.restaurant.dto.User;

import java.util.List;

/**
 * Created by Martha on 2/24/2017.
 */
public interface UserDAO {

    /** Checks by username, if user exists updates it, if not creates new user.
     * If user exists in db but the password of given user is null, updates
     * whole info except the password.
     * @param user instance of {@link User}
     * @return {@link User} object from db or null if doesn't exist.*/
    User writeOrUpdateUser(User user);

    /** Finds specified user.
     * @param userId generated id of user.
     * @return {@link User} object from db or null if doesn't exist.*/
    User readUser(Integer userId);

    /** Finds specified user.
     * @param username username
     * @return {@link User} object from db or null if doesn't exist.*/
    User readUser(String username);

    /** Deletes specified user.
     * @param userId generated id of user.
     * @return  true if user successfully deleted or did not exist.*/
    boolean deleteUser(Integer userId);

    /** Deletes specified user.
     * @param username username
     * @return  true if user successfully deleted or did not exist.*/
    boolean deleteUser(String username);

    /** Gets all users with specified role.
     * @param role role of user
     * @return list of {@link User} objects from db or if non exist return a list with size of 0.*/
    List<User> getAllUsers(String role);

    /** Gets all users.
     * @return list of {@link User} objects from db or if non exist return a list with size of 0.*/
    List<User> getAllUsers();

    /** Checks by role name, if role exists does nothing, if not, creates new role.
     * @param role instance of {@link Role}
     * @return {@link Role} object from db or null if doesn't exist.*/
    Role writeRole(Role role);

    /** Gets all roles.
     * @return list of {@link Role} objects from db or if non, exist return a list with size of 0.*/
    List<Role> readRoles();

    /** Creates a table to store token for rememberMe functionality*/
    void addRememberMeTable();
}
