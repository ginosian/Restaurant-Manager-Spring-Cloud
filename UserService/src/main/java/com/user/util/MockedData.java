package com.user.util;

/**
 * Created by Martha on 2/26/2017.
 */
public class MockedData {
    public static int counterUsername;
    public static int counterPassword;
    public static int counter;

    public static String userName(){
        return "Test_User_" + Integer.toString(++counterUsername);
    }

    public static String password(){
        return "Test_Password_" + Integer.toString(++counterPassword);
    }

    public static String uuid(){
        return "Test_UUID_" + Integer.toString(++counter);
    }



}
