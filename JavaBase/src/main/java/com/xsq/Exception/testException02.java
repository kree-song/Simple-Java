package com.xsq.Exception;

import java.text.ParseException;

public class testException02 {
    public static void main(String[] args) throws ParseException {
        //method1(null);//若调用者未处理就交给虚拟机处理
        method2();
    }


    private static void method1(int arr[]) {
        if (arr == null) {
            //调用者知道成功打印了吗?
            //System.out.println("参数不能为null");
            throw new NullPointerException(); //当参数为null的时候
            //手动创建了一个异常对象,抛给了调用者,产生了一个异常
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    private static void method2() {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]);
            System.out.println("这里能够访问到吗");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}

