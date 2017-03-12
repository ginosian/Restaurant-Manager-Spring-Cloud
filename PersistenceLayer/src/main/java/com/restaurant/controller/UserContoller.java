package com.restaurant.controller;

import com.restaurant.dto.Product;
import com.restaurant.dto.Reservation;
import com.restaurant.dto.Role;
import com.restaurant.dto.User;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import com.restaurant.service.UserService;
import com.restaurant.service.helperModels.ChooserProduct;
import com.restaurant.util.MockedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class UserContoller {

    public static boolean usersAreCreated = false;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;

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

        Product product1 = productService.createProduct(MockedData.productName());
        Product product2 = productService.createProduct(MockedData.productName());
        Product product3 = productService.createProduct(MockedData.productName());
        Product product4 = productService.createProduct(MockedData.productName());
        Product product5 = productService.createProduct(MockedData.productName());
        Product product6 = productService.createProduct(MockedData.productName());
        Product product7 = productService.createProduct(MockedData.productName());
        Product product8 = productService.createProduct(MockedData.productName());
        Product product9 = productService.createProduct(MockedData.productName());
        Product product10 = productService.createProduct(MockedData.productName());
        Product product11 = productService.createProduct(MockedData.productName());
        Product product12 = productService.createProduct(MockedData.productName());

        List<ChooserProduct> products1 = new LinkedList<>();
        products1.add(new ChooserProduct(product1.getId(), 2));
        products1.add(new ChooserProduct(product2.getId(), 8));
        products1.add(new ChooserProduct(product3.getId(), 5));
        List<ChooserProduct> products2 = new LinkedList<>();
        products2.add(new ChooserProduct(product4.getId(), 20));
        products2.add(new ChooserProduct(product5.getId(), 0));

        Reservation reservation1 = reservationService.createReservationAndAddProducts(1, products1);
        Reservation reservation2 = reservationService.createReservationAndAddProducts(2, products2);
        Reservation reservation3 = reservationService.createReservationAndAddProducts(3, products1);
        Reservation reservation4 = reservationService.createReservationAndAddProducts(4, products2);
        Reservation reservation5 = reservationService.createReservationAndAddProducts(5, products1);
        Reservation reservation6 = reservationService.createReservationAndAddProducts(6, products2);
        Reservation reservation7 = reservationService.createReservationAndAddProducts(7, products1);

        reservationService.changeReservationState(reservation2.getId(), false);
        reservationService.changeReservationState(reservation3.getId(), false);
        reservationService.changeReservationState(reservation4.getId(), false);
        reservationService.changeReservationState(reservation5.getId(), false);
        reservationService.changeReservationState(reservation6.getId(), false);

        usersAreCreated = true;
    }
}
