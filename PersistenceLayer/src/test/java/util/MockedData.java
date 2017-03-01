package util;

import com.restaurant.dto.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martha on 2/26/2017.
 */
public class MockedData {
    public static int counter;
    private static User user;
    private static Set<User> users = new HashSet<>();

    private static Role role;
    private static Set<Role> roles = new HashSet<>();

    private static Product product;
    private static Set<Product> products = new HashSet<>();

    private static ProductInReservation productInReservation;
    private static Set<ProductInReservation> productsInOrder = new HashSet<>();

    private static Reservation reservation;
    private static Set<Reservation> orders = new HashSet<>();



    public static Set<Role> generateRoleSet(int quantity){
        Set<Role> result = new HashSet<>();
        for (int i = 0; i < quantity; i++) {
            Role role = new Role("TEST_ROLE_" + Integer.toString(++counter), "TEST_B_K_" + Integer.toString(++counter));
            result.add(role);
        }
        return result;
    }

    public static Role generateRole(){
        return new Role("TEST_ROLE_" + Integer.toString(++counter), "TEST_B_K_" + Integer.toString(++counter));
    }

    public static User generateUser(Set<Role> roles){
        return new User("TEST_USER_" + Integer.toString(++counter), "TESTPASSWORD" + Integer.toString(++counter), roles);
    }

    public static Product generateProduct(){
        return new Product("TEST_PRODUCT_" + Integer.toString(++counter), "TEST_B_K_" + Integer.toString(++counter));
    }

    public static ProductInReservation ggenerateProductInOrder(Product product, Reservation reservation, int amount){
        return new ProductInReservation(product, reservation, amount, Integer.toString(++counter));
    }

//    public static Reservation generateOrder(User user){
//        return new Reservation("TEST_B_K_" + Integer.toString(++counter), ggenerateProductInOrder(generateProduct(),)  user, true);
//    }
//
//    public static Reservation generateOrder(User user, Set<ProductInReservation> productInReservations){
//        return new Reservation("TEST_B_K_" + Integer.toString(++counter), user, true);
//    }

    public static Set<User> usersFromDB(User user){
        if(user != null) users.add(user);
        return users;
    }

    public static User userFromDB(User user){
        if(user != null) MockedData.user = user;
        return user;
    }

    public static Set<Role> rolesFromDB(Role role){
        if(role != null) roles.add(role);
        return roles;
    }

    public static Role roleFromDB(Role role){
        if(role != null) MockedData.role = role;
        return role;
    }

    public static Set<Product> productsFromDB(Product product){
        if(product != null) products.add(product);
        return products;
    }

    public static Product productFromDB(Product product){
        if(product != null) MockedData.product = product;
        return product;
    }

    public static Set<ProductInReservation> productsInOrderFromDB(ProductInReservation productInReservation){
        if(productInReservation != null) productsInOrder.add(productInReservation);
        return productsInOrder;
    }

    public static ProductInReservation productInOrderFromDB(ProductInReservation productInReservation){
        if(productInReservation != null) MockedData.productInReservation = productInReservation;
        return productInReservation;
    }

    public static Set<Reservation> ordersFromDB(Reservation reservation){
        if(reservation != null) orders.add(reservation);
        return orders;
    }

    public static Reservation orderFromDB(Reservation reservation){
        if(reservation != null) MockedData.reservation = reservation;
        return reservation;
    }

    public static String roleName(){
        return "Test_ROLE_" + Integer.toString(++counter);
    }

    public static String userName(){
        return "Test_User_" + Integer.toString(++counter);
    }

    public static String productName(){
        return "Test_Product_" + Integer.toString(++counter);
    }

    public static String password(){
        return "Test_Password_" + Integer.toString(++counter);
    }

    public static String uuid(){
        return "Test_UUID_" + Integer.toString(++counter);
    }



}
