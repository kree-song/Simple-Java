package com.xsq.collections.stream;

import java.util.ArrayList;

public class TipTest {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 过滤整数，只留偶数
     * 结论：在Stream流中无法直接修改集合、数组等数据源中的数据
     */
    private static void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        list.stream().filter(number -> number % 2 == 0).forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");

        //结论：在Stream流中无法直接修改集合、数组等数据源中的数据
        System.out.println(list);
    }
}
