package com.xsq.internet.TCP;

import java.util.UUID;

public class testUUID {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().replace("-", "");
        System.out.println(s);
    }
}
