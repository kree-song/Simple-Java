package com.xsq.lang.features.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 异常：即程序出现了不正常的情况。程序在执行过程中，出现的非正常的情况，最终会导致JVM的非正常运行
 * 分类：编译时异常即受检异常，运行时异常即非受检异常
 * JVM的默认处理：1）把异常的名称，错误原因及异常出现的位置等信息输出在控制台
 *              2）程序停止执行
 * 声明异常：throws 异常名称。编译时异常因为在编译时就会检查，所以必须要写在方法后面进行显式声明
 * 手动创建异常：throw new 异常()
 * 自己处理异常：try...catch...  代码在出现异常后catch后的代码还可以继续
 */
public class exceptionTest {
    /**
     * 使用throws声明异常：如果出现了该异常，将这个异常交给调用者处理
     */
    private static void method1() throws NullPointerException {
        int[] arr = null;
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 编译时异常演示
     * @throws ParseException
     */
    private static void method2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        sdf.parse("2048-10月10日");
    }

    /**
     * 手动创建异常：抛给调用者处理
     * @param arr
     */
    private static void method3(int arr[]) {
        if (arr == null) {
            System.out.println("参数不能为null");
            throw new NullPointerException();
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    /**
     * 捕获异常
     */
    private static void method4() {
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

    /**
     * ！抛出异常后，下面的代码不会执行
     */
    private static void method5() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(i);
                int j = 1/0;
            } catch (Exception e) {
                System.out.println(e);
                throw e;
            }
        }
        System.out.println("这里能够访问吗");
    }

    public static void main(String[] args) throws ParseException {
//        method1();//若调用者未处理就交给虚拟机处理
        method5();
    }
}

