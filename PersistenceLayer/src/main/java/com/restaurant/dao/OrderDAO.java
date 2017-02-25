package com.restaurant.dao;

import com.restaurant.dto.Order;
import com.restaurant.dto.ProductInOrder;
import com.restaurant.dto.User;

import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
public interface OrderDAO {

    /** Checks by order generated id, if order exists updates it, if not creates new order.
     * @param order instance of {@link Order}
     * @return {@link Order} object from db or null if doesn't exist.*/
    Order writeOrUpdateOrder(Order order);

    /** Finds specified order.
     * @param orderId generated id of order.
     * @return {@link Order} object from db or null if doesn't exist.*/
    Order readOrder(Integer orderId);

    /** Gets all orders with specified user.
     * @param user ordered user
     * @return list of {@link Order} objects from db or if non exist return a list with size of 0.*/
    List<Order> getAllOrders(User user);

    /** Deletes specified order.
     * @param orderId generated id of order.
     * @return true if order was successfully deleted or did not exist.*/
    boolean deleteOrder(Integer orderId);

    /** Deletes all orders with specified user.
     * @param user ordered user
     * @return true if order were successfully deleted or did not exist.*/
    boolean deletAllOrders(User user);

    /** Gets all orders.
     * @return list of {@link Order} objects from db or if non exist return a list with size of 0.*/
    List<Order> getAllOrders();

    /** Adds or updates product in order.
     * @param order {@link Order} to be updated with new or modified product in order.
     * @param productInOrder {@link ProductInOrder} created or updated product in order..
     * @return {@link Order} object from db or null if doesn't exist.*/
    Order writeOrUpdateProductInOrder(Order order, ProductInOrder productInOrder);

    /** Deletes product from order.
     * @param order {@link Order} to be updated with new or modified product in order.
     * @param productInOrder {@link ProductInOrder} created or updated product in order..
     * @return {@link Order} object from db or null if doesn't exist.*/
    Order deleteProductFromOrder(Order order, ProductInOrder productInOrder);

}
