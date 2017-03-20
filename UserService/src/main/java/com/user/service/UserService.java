package com.user.service;

import com.user.dto.Role;
import com.user.dto.User;

import java.util.List;

/**
 * Created by Martha on 2/24/2017.
 */
public interface UserService {

    User createUser(String username, String password, String... roles);

    User findUser(int userId);

    User findUser(String username);

    User updateUserWithARole(int userId, int roleId);

    boolean deleteUser(int userId);

    List<User> getAllUsers();

    List<User> getAllUsersByRole(int roleId);

    Role createRole(String role);

    List<Role> getAllRoles();
}
