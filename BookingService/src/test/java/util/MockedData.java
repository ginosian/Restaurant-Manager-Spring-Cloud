package util;

/**
 * Created by Martha on 2/26/2017.
 */
public class MockedData {
    public static int counter;
    public static int restaurantCounter;
    public static int userCounter;
    public static int reservationCounter;

    public static Integer userId(){
        return ++userCounter;
    }

    public static Integer restaurantId(){
        if(restaurantCounter == 8) restaurantCounter = 0;
        return ++restaurantCounter;
    }

    public static Integer reservationId(){
        return ++reservationCounter;
    }

    public static String uuid(){
        return "Test_UUID_" + Integer.toString(++counter);
    }



}
