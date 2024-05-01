package com.xsq.api.System;

public class testSystem {
    public static void main(String[] args) {
        //public static void currentTimeMillis()：返回当前时间(以毫秒为单位)
        long start = System.currentTimeMillis();//毫秒为单位
        System.out.println(111);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("------------------------");

        //arraycopy(数组源数组，起始索引，目的地数组，起始索引，拷贝个数)：数组copy
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[10];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        System.out.println("--------------------------------");

        //public static void exit(int status)：终止当前运行的Java虚拟机，非零表示异常终止
        System.exit(0);
        System.out.println(222);
    }
}
