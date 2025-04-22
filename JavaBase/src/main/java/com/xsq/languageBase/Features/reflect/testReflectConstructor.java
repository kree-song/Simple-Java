package com.xsq.languageBase.Features.reflect;

import java.lang.reflect.Constructor;

/*
 * 获取构造方法
 * */
public class testReflectConstructor {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //method1();
        method2();
        //method3();
        //method4();
    }

    private static void method4() throws ClassNotFoundException, NoSuchMethodException {
        //Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)：返回单个构造方法对象
        //1.获取Class对象
        Class clazz = Class.forName("com.xsq.languageBase.Features.reflect.Student02");
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        System.out.println(constructor);
    }

    private static void method3() throws ClassNotFoundException, NoSuchMethodException {
        //Constructor<T> getConstructor(Class<?>... parameterTypes)：返回单个公共构造方法对象
        //1.获取Class对象
        Class clazz = Class.forName("com.xsq.languageBase.Features.reflect.Student02");
        //小括号中,一定要跟构造方法的形参保持一致.
        Constructor constructor1 = clazz.getConstructor();
        System.out.println(constructor1);

        Constructor constructor2 = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor2);

        //因为Student类中,没有只有一个int的构造,所以这里会报错.
        Constructor constructor3 = clazz.getConstructor(int.class);
        System.out.println(constructor3);
    }

    private static void method2() throws ClassNotFoundException {
        //Constructor<?>[] getDeclaredConstructors()：返回所有构造方法对象的数组
        //1.获取Class对象
        Class clazz = Class.forName("com.xsq.languageBase.Features.reflect.Student02");

        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    private static void method1() throws ClassNotFoundException {
        //Constructor<?>[] getConstructors()：返回所有公共构造方法对象的数组
        //1.获取Class对象
        Class clazz = Class.forName("com.xsq.languageBase.Features.reflect.Student02");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }
}

class Student02 {
    private String name;
    private int age;

    //私有的有参构造方法
    private Student02(String name) {
        System.out.println("name的值为:" + name);
        System.out.println("private...Student...有参构造方法");
    }

    //公共的无参构造方法
    public Student02() {
        System.out.println("public...Student...无参构造方法");
    }

    //公共的有参构造方法
    public Student02(String name, int age) {
        System.out.println("name的值为:" + name + " age的值为:" + age);
        System.out.println("public...Student...有参构造方法");
    }
}