package com.xsq.api.Date;

import java.util.Date;

public class testDate {
    public static void main(String[] args) {
        Date date = new Date();
        long time = date.getTime();
        long time2 = System.currentTimeMillis();
        System.out.println(time + "\t" + time2);
        System.out.println("----------------------------------------------------");

        date.setTime(0L);
        System.out.println(date);

    }
}
