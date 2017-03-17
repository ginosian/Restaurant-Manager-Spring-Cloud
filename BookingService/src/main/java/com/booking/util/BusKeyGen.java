package com.booking.util;

import java.util.UUID;

/**
 * Created by Martha on 3/1/2017.
 */
public class BusKeyGen {

    public static String nextKey(){
        return UUID.randomUUID().toString();
    }
}
