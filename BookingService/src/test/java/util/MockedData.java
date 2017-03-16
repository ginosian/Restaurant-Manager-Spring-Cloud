package util;

import com.restaurant.dto.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martha on 2/26/2017.
 */
public class MockedData {
    public static int counter;
    private static Booking booking;
    private static Set<Booking> bookings = new HashSet<Booking>();

    public static Booking generateRestaurant(){
        return new Booking("TEST_PRODUCT_" + Integer.toString(++counter), "TEST_B_K_" + Integer.toString(++counter));
    }

    public static Set<Booking> restaurantsFromDB(Booking booking){
        if(booking != null) bookings.add(booking);
        return bookings;
    }

    public static Booking restaurantFromDB(Booking booking){
        if(booking != null) MockedData.booking = booking;
        return booking;
    }

    public static String roleName(){
        return "Test_ROLE_" + Integer.toString(++counter);
    }

    public static String userName(){
        return "Test_User_" + Integer.toString(++counter);
    }

    public static String restaurantName(){
        return "Test_Restaurant_" + Integer.toString(++counter);
    }

    public static String password(){
        return "Test_Password_" + Integer.toString(++counter);
    }

    public static String uuid(){
        return "Test_UUID_" + Integer.toString(++counter);
    }



}
