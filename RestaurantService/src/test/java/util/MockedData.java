package util;

/**
 * Created by Martha on 2/26/2017.
 */
public class MockedData {
    public static int counter;

    public static String productName(){
        return "Test_Product_" + Integer.toString(++counter);
    }

    public static Integer restaurantId(){
        return counter++;
    }



}
