package com.user.util;

/**
 * Created by Martha on 3/1/2017.
 */
public class Validate {

    public static boolean valid(int entry){
        return entry > 0;
    }

    public static boolean valid(String entry){
        return entry != null && !entry.isEmpty();
    }

    public static boolean valid(String entry1, int entry2){
        return entry1 != null && !entry1.isEmpty() && entry2 > 0;
    }

    public static boolean valid(Object object){
        return object != null;
    }

    public static boolean valid(Object object, String entry1, int entry2){
        return valid(entry1, entry2) && object != null;
    }

    public static boolean valid(int ... args){
        int index = args.length - 1;
        while(index >= 0){
            if(!valid(args[index]))return false;
            index--;
        }
        return true;
    }

    public static boolean valid(String ... args){
        int index = args.length - 1;
        while(index >= 0){
            if(!valid(args[index]))return false;
            index--;
        }
        return true;
    }

}
