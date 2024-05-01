package com.xsq.genericity;

import java.util.ArrayList;

public class testGenericityGlobbing {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Number> list2 = new ArrayList<>();
        ArrayList<Object> list3 = new ArrayList<>();


        /*printList(list1);
        printList(list2);*/

        /*method1(list1);
        method1(list2);
        method1(list3);//error*/

        /*method2(list1);//error
        method2(list2);
        method2(list3);*/
    }

    //类型通配符: <?>
    private static void printList(ArrayList<?> list) {
    }

    //类型通配符上限: <? extends 类型>
    private static void method1(ArrayList<? extends Number> list) {
    }

    //类型通配符下限: <? super 类型>
    private static void method2(ArrayList<? super Number> list) {
    }
}
