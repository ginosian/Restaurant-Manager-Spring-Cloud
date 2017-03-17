package util;

/**
 * Created by Martha on 2/26/2017.
 */
public class MockedData {
    public static int counter;

    public static String userId(){
        return "Test_User_Id_" + Integer.toString(++counter);
    }

    public static String restaurantId(){
        return "Test_Restaurant_Id_" + Integer.toString(++counter);
    }

    public static String reservationId(){
        return "Test_Reservation_Id_" + Integer.toString(++counter);
    }

    public static String uuid(){
        return "Test_UUID_" + Integer.toString(++counter);
    }



}
