package com.user.controller;

import com.user.dto.Role;
import com.user.dto.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class UserContoller {

    public static boolean usersAreCreated = false;

    @Autowired
    UserService userService;

    // region User
    @PostMapping(path = "/user")
    public void addUser(User user, Role role){
        userService.createUser(user.getUsername(), user.getPassword(), role);
    }

    @GetMapping(path = "/user/{id}", produces = "application/json")
    public User user(@PathVariable("id") int id){
        return userService.findUser(id);
    }

    @PutMapping(path = "/user")
    public void updateUserRole(User user, Role role){
        userService.updateUserWithARole(user.getId(), role.getId());
    }

    @DeleteMapping(path = "/user")
    public void deleteUser(User user){
        userService.deleteUser(user.getId());
    }

    @GetMapping(path = "/users", produces = "application/json")
    public List<User> allUsers(){
//        createUsers();
        List<User> users = userService.getAllUsers();
        return users;
    }
    // endregion

    // region Role
    @PostMapping(path = "/role")
    public void addRole(String roleName){
        userService.createRole(roleName);
    }

    @GetMapping(path = "/roles", produces = "application/json")
    public List<Role> allRoles(){
//        createUsers();
        return userService.getAllRoles();
    }
    // endregion


    public void createUsers(){
        if(usersAreCreated) return;

        Role role1 = userService.createRole("admin");
        Role role2 = userService.createRole("guest");
        Role role3 = userService.createRole("restaurant");

        User user1 = userService.createUser("admin", "pass", role1);
        User user2 = userService.createUser("guest", "pass", role2);
        User user3 = userService.createUser("restaurant", "pass", role3);

        usersAreCreated = true;
    }
}
