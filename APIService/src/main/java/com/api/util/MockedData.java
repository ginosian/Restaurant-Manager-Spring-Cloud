package com.api.util;

/**
 * Created by Martha on 2/26/2017.
 */
public class MockedData {
    public static int counter;

    public static String restaurantName(){
        return "Test_RESTAURANT_" + Integer.toString(++counter);
    }

}
