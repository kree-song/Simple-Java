package com.xsq.Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * 异常：异常就是程序出现了不正常的情况。程序在执行过程中，出现的非正常的情况，最终会导致JVM的非正常运行
 * 异常：编译时异常，受检异常；运行时异常，非受检异常
 * JVM的默认处理：1）把异常的名称，错误原因及异常出现的位置等信息输出在了控制台
 *              2）程序停止执行
 * 声明异常：throws 异常名称
 * 编译时异常因为在编译时就会检查，所以必须要写在方法后面进行显式声明
 * 手动创建异常：throw new 异常()
 * 自己处理异常：try...catch...  代码在出现异常后catch后的代码还可以继续
 * */
public class testException {
    public static void main(String[] args) throws ParseException {
        method1();//若调用者未处理就交给虚拟机处理
        //method2();
    }

    //throws:告诉调用者会出现什么异常
    //如果出现了该异常，将这个异常交给调用者处理
    private static void method1() throws NullPointerException {
        int[] arr = null;
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void method2() throws ParseException {//编译时异常
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        sdf.parse("2048-10月10日");
    }
}

