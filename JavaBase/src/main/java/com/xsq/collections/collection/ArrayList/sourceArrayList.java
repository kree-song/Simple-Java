package com.xsq.collections.collection.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class sourceArrayList {
    public static void main(String[] args) {
//        testCopyOf();
//        createNewList();
    }

    private static void createNewList() {
        List<Integer> data = new ArrayList<>(2);
        data.add(1);
        data.add(2);
        //通过已有集合构造新ArrayList
        List<Integer> dataCopy = new ArrayList<>(data);
        dataCopy.add(3);
        System.out.println(data);
        System.out.println(dataCopy);
    }

    private static void testCopyOf(){
        int[] a = new int[]{0,1,2,3,4,5};
        int[] b = Arrays.copyOf(a,10);
        Arrays.stream(b).forEach(o -> System.out.print(o + " "));

        System.out.println();

        Date[] dates = new Date[]{new Date()};
        Date[] dateCopy = Arrays.copyOf(dates,3);
        Arrays.stream(dateCopy).forEach(o -> System.out.print(o + " "));
    }
}
