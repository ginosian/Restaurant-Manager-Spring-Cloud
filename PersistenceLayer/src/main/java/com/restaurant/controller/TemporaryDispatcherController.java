package com.restaurant.controller;

import com.restaurant.DataModel.ClobalEntitySingleImpl;
import com.restaurant.DataModel.GlobalEntity;
import com.restaurant.dto.*;
import com.restaurant.service.FrontService;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import com.restaurant.service.UserService;
import com.restaurant.util.MockedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martha on 2/28/2017.
 */
@RestController
public class TemporaryDispatcherController {

    boolean dataIsMaked = false;

    @Autowired
    FrontService frontService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;



    @PostMapping(value = "/roles")
    public GlobalEntity getRoles(){
        if(!dataIsMaked) makeData();
        List<Role> roles = userService.roles();
        GlobalEntity globalEntity = new ClobalEntitySingleImpl<List<Role>>("Roles", roles);
        return globalEntity;
    }




    private void makeData(){
        Role role1 = MockedData.generateRole();
        role1.setRole("Admin");
        List<Role> roles1 = new ArrayList<>();
        roles1.add(userService.writeRole(role1));

        Role role2 = MockedData.generateRole();
        role2.setRole("Admin");
        List<Role> roles2 = new ArrayList<>();
        roles2.add(userService.writeRole(role1));


        Role role3 = MockedData.generateRole();
        role3.setRole("Admin");
        List<Role> roles3 = new ArrayList<>();
        roles3.add(userService.writeRole(role1));

        User user1 = userService.writeOrUpdateUser(MockedData.generateUser(roles1));
        User user2 = userService.writeOrUpdateUser(MockedData.generateUser(roles2));
        User user3 = userService.writeOrUpdateUser(MockedData.generateUser(roles3));
        User user4 = userService.writeOrUpdateUser(MockedData.generateUser(roles1));
        User user5 = userService.writeOrUpdateUser(MockedData.generateUser(roles2));
        User user6 = userService.writeOrUpdateUser(MockedData.generateUser(roles3));
        User user7 = userService.writeOrUpdateUser(MockedData.generateUser(roles1));
        User user8 = userService.writeOrUpdateUser(MockedData.generateUser(roles2));
        User user9 = userService.writeOrUpdateUser(MockedData.generateUser(roles3));
        User user10 = userService.writeOrUpdateUser(MockedData.generateUser(roles1));


        System.out.println("*****************Users are equal**************: " + user1.equals(userService.readUser(user1.getId())));
        System.out.println("*****************Users are equal**************: " + user2.equals(userService.readUser(user2.getUsername())));

        List<User> usersWithSpecificRole = userService.getAllUsers(role1.getRole());
        System.out.println("******************************** Between two reads, cache check****************************************");
        List<User> usersWithSpecificRole1 = userService.getAllUsers(role1.getRole());
        System.out.println("******************************** Between two reads, cache check****************************************");
        List<User> usersWithSpecificRole2 = userService.getAllUsers(role1.getRole());
        System.out.println("******************************** Between two reads, cache check****************************************");
        List<User> usersWithSpecificRole3 = userService.getAllUsers(role1.getRole());

        System.out.println("Role: " + role1.getRole() + " users: " + usersWithSpecificRole.get(0) + " and " + usersWithSpecificRole);

        int user3Id = user3.getId();
        String user4Username = user4.getUsername();

        System.out.println("User 3 deleted by id? " + userService.deleteUser(user3Id)
                + ", User 4 deleted by name? " + userService.deleteUser(user4Username));

        Product product = productService.writeOrUpdateProduct(MockedData.generateProduct());
        Product sameProduct = productService.readProduct(product.getId());
        System.out.println("***************Products are equal*************: " + product.equals(sameProduct));
        Product product1 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        productService.readProduct(product1.getNumber());
        System.out.println("***************Products to be deleted*************: " + product.getName());
        productService.deleteProduct(product1.getId());
        Product product2 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        Product product3 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        Product product8 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        Product product5 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        Product product6 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        Product product7 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        List<Product> allProducts = productService.getAllProducts();


        Product product14 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        Product product9 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        Product product10 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        Product product11 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        Product product12 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        Product product13 = productService.writeOrUpdateProduct(MockedData.generateProduct());
        List<Product> allProducts2 = productService.getAllProducts();




        for(Product product4 : allProducts){
            System.out.println("********************" + product4.getName() + "*************************");
        }
        Reservation reservation = reservationService.writeOrUpdateReservation(new Reservation("4564", user1, true));
        Reservation reservation1 = reservationService.writeOrUpdateReservation(new Reservation("57857", user2, true));
        Reservation reservation2 = reservationService.writeOrUpdateReservation(new Reservation("5764", user5, true));
        Reservation reservation3 = reservationService.writeOrUpdateReservation(new Reservation("457885", user6, true));

        Reservation reservation4 = reservationService.writeOrUpdateReservation(new Reservation("4222564", user1, true));
        Reservation reservation5 = reservationService.writeOrUpdateReservation(new Reservation("57857", user2, true));
        Reservation reservation6 = reservationService.writeOrUpdateReservation(new Reservation("5764", user5, true));
        Reservation reservation7 = reservationService.writeOrUpdateReservation(new Reservation("457885", user6, true));


        ProductInReservation productInReservation = productService.writeOrUpdateProductInReservation(MockedData.ggenerateProductInOrder(product2, reservation, 5));
        ProductInReservation productInReservation2 = productService.writeOrUpdateProductInReservation(MockedData.ggenerateProductInOrder(product3, reservation1, 5));
        ProductInReservation productInReservation3 = productService.writeOrUpdateProductInReservation(MockedData.ggenerateProductInOrder(product2, reservation3, 5));

        List<ProductInReservation> productInReservations = new ArrayList<>();
        productInReservations.add(productInReservation);
        productInReservations.add(productInReservation2);
        productInReservations.add(productInReservation3);


        userService.deleteUser(user6.getId());
        reservationService.deleteReservation(reservation1.getId());

        dataIsMaked = true;

    }

}
