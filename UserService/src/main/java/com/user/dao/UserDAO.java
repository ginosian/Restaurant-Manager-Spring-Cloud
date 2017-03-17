package com.user.dao;

import com.user.dto.Role;
import com.user.dto.User;

import java.util.List;

/**
 * Created by Martha on 2/24/2017.
 */
public interface UserDAO {

    /** Updates given entity, comparing identity is its generated id
     * @param user instance of {@link User}
     * @return {@link User} entity updated.*/
    User updateUser(User user);

    /** Persists given entity
     * @param user instance of {@link User}
     * @return {@link User} entity with generated Id from db.*/
    User writeUser(User user);

    /** Checks by username
     * @param username unique name of user
     * @return false if doesn't exist.*/
    boolean containsUserByUsername(String username);

    /** Checks by username
     * @param userId user id
     * @return false if doesn't exist.*/
    boolean containsUserById(int userId);

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

    /** Get role by role.
     * @return  {@link Role} object from db  with specified role.*/
    Role readRole(String role);

    /** Get role by role.
     * @return  {@link Role} object from db  with specified role.*/
    Role readRole(int roleId);

}
