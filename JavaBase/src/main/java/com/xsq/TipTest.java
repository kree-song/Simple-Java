package com.xsq;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TipTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        //arrayTest();
        //numTest();
        //CaseTest();
        //Convert();
        //Bit();

//        Map<Long,Boolean> map = new HashMap<>();
//        map.put(2L,true);
//        if (!(Boolean) map.get(1L)){
//            System.out.println("null 为false");
//        }

//        List<Integer> list = Arrays.asList(1, 2);
//        testList(list);

        Map<Long, Boolean> map = new HashMap<>();
        map.put(1L, true);
        System.out.println(map.get(2L));
    }


    //位运算
    public static void Bit() {
        int a = 10 << 2;//10* 2^2
        int b = 10 >> 2;//10/ 2^2
        System.out.println(a + " " + b);

        int i = '0';
        System.out.println(i);
    }

    //进制
    public static void Convert() {
        int a = 0b11;
        int b = 011;
        int c = 0x11;
        System.out.println(a + " " + b + " " + c);
    }

    public static void CaseTest() {
        switch (1) { //仅支持int、String类型
            case 0:
                System.out.println("星期日");
                break;
            case 1:
                System.out.println("星期一");
            case 2:
                System.out.println("星期二");
            case 3:
                System.out.println("星期三");
            case 4:
                System.out.println("星期四");
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
        }
    }

    public static void numTest() {
        //1)类型转换
        byte a = -128;//强转:若未超过小容量则可编译通过 byte:-128~127
        float b = 3.4f;//小数默认double

        short s1 = 1;
        s1 = (short) (s1 + 1);//必须强转
        s1 += 1;//相当于s1=(short)(s1+1)
        s1 = 1 + 1;//常量优化机制

        //2)操作符
        int i = 1;
        i = i++;
        System.out.println(i);
        int count = 0;
        for (int j = 0; j < 100; j++) {
            count = count++;
        }
        System.out.println(count);
    }

    public static void arrayTest() {
        int[] arr1 = {11, 22, 33};
        int[] arr2 = {44, 55, 66};
        int[] arr3 = {77, 88, 99, 100};//3*4

        int[][] arr = new int[3][3];//3*3

        arr[0] = arr1;
        arr[1] = arr2;
        arr[2] = arr3;

        System.out.println(arr[1][3]);
        System.out.println(arr[2][3]);
    }

    public static List<Integer> testList(List<Integer> list) {
        List<Integer> lists = list;
        for (Integer num : lists) {
            if (num == 1) {
                lists.remove(num);
            }
        }
        return lists;
    }

}
