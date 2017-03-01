package com.restaurant.controller;

import com.restaurant.dto.Product;
import com.restaurant.dto.Role;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import com.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@RestController
public class TestController {

    public static int counter =  0;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<Product> addOrUpdateUser(){
//        Role role1 = userService.writeRole(MockedData.generateRole());
//        Role role2 = userService.writeRole(MockedData.generateRole());
//        Role role3 = userService.writeRole(MockedData.generateRole());
//        Role role4 = userService.writeRole(MockedData.generateRole());
//        Role role5 = userService.writeRole(MockedData.generateRole());
//
//        List<Role> roles1 = new ArrayList<>();
//        roles1.add(role1);
//        roles1.add(role2);
//        List<Role> roles2 = new ArrayList<>();
//        roles2.add(role2);
//        roles2.add(role3);
//        List<Role> roles3 = new ArrayList<>();
//        roles3.add(role3);
//        roles3.add(role4);
//        List<Role> roles4 = new ArrayList<>();
//        roles4.add(role4);
//        roles4.add(role5);
//
//        User user1 = userService.writeOrUpdateUser(MockedData.generateUser(roles1));
//        User user2 = userService.writeOrUpdateUser(MockedData.generateUser(roles2));
//        User user3 = userService.writeOrUpdateUser(MockedData.generateUser(roles3));
//        User user4 = userService.writeOrUpdateUser(MockedData.generateUser(roles4));
//        User user5 = userService.writeOrUpdateUser(MockedData.generateUser(roles1));
//        User user6 = userService.writeOrUpdateUser(MockedData.generateUser(roles2));
//        User user7 = userService.writeOrUpdateUser(MockedData.generateUser(roles3));
//        User user8 = userService.writeOrUpdateUser(MockedData.generateUser(roles4));
//
//
//        System.out.println("*****************Users are equal**************: " + user1.equals(userService.readUser(user1.getId())));
//        System.out.println("*****************Users are equal**************: " + user2.equals(userService.readUser(user2.getUsername())));
//
//        List<User> usersWithSpecificRole = userService.getAllUsers(role1.getRole());
//        System.out.println("******************************** Between two reads, cache check****************************************");
//        List<User> usersWithSpecificRole1 = userService.getAllUsers(role1.getRole());
//        System.out.println("******************************** Between two reads, cache check****************************************");
//        List<User> usersWithSpecificRole2 = userService.getAllUsers(role1.getRole());
//        System.out.println("******************************** Between two reads, cache check****************************************");
//        List<User> usersWithSpecificRole3 = userService.getAllUsers(role1.getRole());
//
//        System.out.println("Role: " + role1.getRole() + " users: " + usersWithSpecificRole.get(0) + " and " + usersWithSpecificRole);
//
//        int user3Id = user3.getId();
//        String user4Username = user4.getUsername();
//
//        System.out.println("User 3 deleted by id? " + userService.deleteUser(user3Id)
//                + ", User 4 deleted by name? " + userService.deleteUser(user4Username));
//
//        Product product = productService.writeOrUpdateProduct(MockedData.generateProduct());
//        Product sameProduct = productService.readProduct(product.getId());
//        System.out.println("***************Products are equal*************: " + product.equals(sameProduct));
//        Product product1 = productService.writeOrUpdateProduct(MockedData.generateProduct());
//        productService.readProduct(product1.getNumber());
//        System.out.println("***************Products to be deleted*************: " + product.getName());
//        productService.deleteProduct(product1.getId());
//        Product product2 = productService.writeOrUpdateProduct(MockedData.generateProduct());
//        Product product3 = productService.writeOrUpdateProduct(MockedData.generateProduct());
//        Product product8 = productService.writeOrUpdateProduct(MockedData.generateProduct());
//        Product product5 = productService.writeOrUpdateProduct(MockedData.generateProduct());
//        Product product6 = productService.writeOrUpdateProduct(MockedData.generateProduct());
//        Product product7 = productService.writeOrUpdateProduct(MockedData.generateProduct());
//        List<Product> allProducts = productService.getAllProducts();
//
//       for(Product product4 : allProducts){
//           System.out.println("********************" + product4.getName() + "*************************");
//       }
//        Reservation reservation = reservationService.writeOrUpdateReservation(new Reservation("4564", user1, true));
//        Reservation reservation1 = reservationService.writeOrUpdateReservation(new Reservation("57857", user2, true));
//        Reservation reservation2 = reservationService.writeOrUpdateReservation(new Reservation("5764", user5, true));
//        Reservation reservation3 = reservationService.writeOrUpdateReservation(new Reservation("457885", user6, true));
//
//
//        ProductInReservation productInReservation = productService.writeOrUpdateProductInReservation(MockedData.ggenerateProductInOrder(product2, reservation, 5));
//        ProductInReservation productInReservation2 = productService.writeOrUpdateProductInReservation(MockedData.ggenerateProductInOrder(product3, reservation1, 5));
//        ProductInReservation productInReservation3 = productService.writeOrUpdateProductInReservation(MockedData.ggenerateProductInOrder(product2, reservation3, 5));
//
//        List<ProductInReservation> productInReservations = new ArrayList<>();
//        productInReservations.add(productInReservation);
//        productInReservations.add(productInReservation2);
//        productInReservations.add(productInReservation3);
//
//
//        userService.deleteUser(user6.getId());
//        reservationService.deleteReservation(reservation1.getId());




        return null;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Product addOrUpdateProduct(){
        return null;
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public Role addOrUpdateRole(){
        return null;
    }
}
