package com.booking.util;

/**
 * Created by Martha on 2/26/2017.
 */
public class MockedData {
    public static int counter;
    public static int restaurantCounter;
    public static int userCounter;
    public static int reservationCounter;

    public static String userId(){
        return Integer.toString(++userCounter);
    }

    public static String reservationId(){
        return Integer.toString(++reservationCounter);
    }

    public static String uuid(){
        return "Test_UUID_" + Integer.toString(++counter);
    }




}
