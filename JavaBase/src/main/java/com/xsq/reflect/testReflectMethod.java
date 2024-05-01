package com.xsq.reflect;

import java.lang.reflect.Method;

/*
 * 获取成员方法
 * */
public class testReflectMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //method1();
        //method2();
        //method3();
        //method4();
        method5();
    }

    private static void method5() throws ClassNotFoundException, NoSuchMethodException {
        //Method getDeclaredMethod(String name, Class<?>... parameterTypes)：返回单个成员方法对象
        //1.获取class对象
        Class clazz = Class.forName("com.xsq.reflect.Student04");
        //2.获取一个成员方法show
        Method method = clazz.getDeclaredMethod("show");
        //3.打印一下
        System.out.println(method);
    }

    private static void method4() throws ClassNotFoundException, NoSuchMethodException {
        //1.获取class对象
        Class clazz = Class.forName("com.xsq.reflect.Student04");
        //2.获取一个有形参的方法function2
        Method method = clazz.getMethod("function2", String.class);
        //3.打印一下
        System.out.println(method);
    }

    private static void method3() throws ClassNotFoundException, NoSuchMethodException {
        //Method getMethod(String name, Class<?>... parameterTypes) ：返回单个公共成员方法对象
        //1.获取class对象
        Class clazz = Class.forName("com.xsq.reflect.Student04");
        //2.获取成员方法function1
        Method method1 = clazz.getMethod("function1");
        //3.打印一下
        System.out.println(method1);
    }

    private static void method2() throws ClassNotFoundException {
        //Method[] getDeclaredMethods()：返回所有成员方法对象的数组，不包括继承的                   
        //1.获取class对象
        Class clazz = Class.forName("com.xsq.reflect.Student04");

        //2.获取Method对象
        Method[] methods = clazz.getDeclaredMethods();
        //3.遍历一下数组
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    private static void method1() throws ClassNotFoundException {
        //Method[] getMethods()：返回所有公共成员方法对象的数组，包括继承的
        //1.获取class对象
        Class clazz = Class.forName("com.xsq.reflect.Student04");
        //2.获取成员方法对象
        Method[] methods = clazz.getMethods();
        //3.遍历
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}

class Student04 {

    //私有的，无参无返回值
    private void show() {
        System.out.println("私有的show方法，无参无返回值");
    }

    //公共的，无参无返回值
    public void function1() {
        System.out.println("function1方法，无参无返回值");
    }

    //公共的，有参无返回值
    public void function2(String name) {
        System.out.println("function2方法，有参无返回值,参数为" + name);
    }

    //公共的，无参有返回值
    public String function3() {
        System.out.println("function3方法，无参有返回值");
        return "aaa";
    }

    //公共的，有参有返回值
    public String function4(String name) {
        System.out.println("function4方法，有参有返回值,参数为" + name);
        return "aaa";
    }
}