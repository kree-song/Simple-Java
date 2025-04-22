package com.xsq.languageBase.Features.reflect;

import java.lang.reflect.Field;

/*
 * 获取成员变量
 * */
public class testReflectField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        //method1();
        //method2();
        //method3();
        method4();

    }

    private static void method4() throws ClassNotFoundException, NoSuchFieldException {
        //Field getDeclaredField(String name)：返回单个成员变量对象
        //1.获取class对象
        Class clazz = Class.forName("com.xsq.languageBase.Features.reflect.Student03");

        //2.获取money成员变量
        Field field = clazz.getDeclaredField("money");

        //3.打印一下
        System.out.println(field);
    }

    private static void method3() throws ClassNotFoundException, NoSuchFieldException {
        //Field getField(String name)：返回单个公共成员变量对象
        //想要获取的成员变量必须是真实存在的
        //且必须是public修饰的.
        //1.获取class对象
        Class clazz = Class.forName("com.xsq.languageBase.Features.reflect.Student03");

        //2.获取name这个成员变量
        Field field = clazz.getField("name");
        //Field field = clazz.getField("name1");
        //Field field = clazz.getField("money");

        //3.打印一下
        System.out.println(field);
    }

    private static void method2() throws ClassNotFoundException {
        //Field[] getDeclaredFields()：返回所有成员变量对象的数组
        //1.获取class对象
        Class clazz = Class.forName("com.xsq.languageBase.Features.reflect.Student03");

        //2.获取所有的Field对象
        Field[] fields = clazz.getDeclaredFields();

        //3.遍历
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    private static void method1() throws ClassNotFoundException {
        //Field[] getFields()：返回所有公共成员变量对象的数组

        //1.获取class对象
        Class clazz = Class.forName("com.xsq.languageBase.Features.reflect.Student03");

        //2.获取Field对象.
        Field[] fields = clazz.getFields();

        //3.遍历
        for (Field field : fields) {
            System.out.println(field);
        }
    }
}

class Student03 {

    public String name;

    public int age;

    public String gender;

    private int money = 300;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", money=" + money +
                '}';
    }
}