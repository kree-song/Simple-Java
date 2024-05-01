package com.xsq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        System.out.println((int)'A');
//        System.out.println(Math.pow(2,16));
//        double i=10;
//        call(new Integer(1));
//        int i = Integer.parseInt("10", 2);
        String s = Integer.toBinaryString(110);
        String q = Integer.toBinaryString(2);
        int i = Integer.parseInt(s);
        int j = Integer.parseInt(q);

        System.out.println(i);
        System.out.println(j);
        System.out.println(10 ^ 2);

        List<int[]>[] g = new ArrayList[5]; // 稀疏图用邻接表
        Arrays.setAll(g, o -> new ArrayList<>());

    }

    public static void call(int i) {
        System.out.println(i);
    }
}
