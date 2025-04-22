package com.xsq.languageBase.Features.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class testReflectMethod02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        Object invoke(Object obj, Object... args)：运行方法
//        参数一：用obj对象调用该方法
//        参数二：调用方法的传递的参数（如果没有就不写）
//        返回值：方法的返回值（如果没有就不写）

        //1.获取class对象
        Class clazz = Class.forName("com.xsq.languageBase.Features.reflect.Student04");
        //2.获取里面的Method对象  function4
        Method method = clazz.getMethod("function4", String.class);
        //3.运行function4方法就可以了
        //3.1创建一个Student对象,当做方法的调用者
        Student04 student = (Student04) clazz.newInstance();
        //3.2运行方法
        Object result = method.invoke(student, "zhangsan");
        //4.打印一下返回值
        System.out.println(result);
    }
}