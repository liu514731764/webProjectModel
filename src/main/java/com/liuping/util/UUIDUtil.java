package com.liuping.util;

import java.util.UUID;

/**
 * Created by liuping on 15/12/8.
 */
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static void main(String [] args){
        int x = 10;
        while (x>0) {
            System.out.println(getUUID());
            x--;
        }
    }
}
