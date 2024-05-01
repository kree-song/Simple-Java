package com.xsq.annotation.inJava;

/*
 * Java中的注解
 * */
public class Zi extends Fu {
    @Override//此方法是重写了父类的方法
    public void show() {
        //super.show();
        System.out.println("子类的方法");
    }

    @Deprecated//表示这是一个过时的方法
    public void method() {
        System.out.println("method.........");
    }

    @SuppressWarnings(value = "all")//表示压制本方法中所有的警告(去除灰色警告)
    public void function() {
        int a = 10;
        int b = 20;
        //System.out.println(a);
        //System.out.println(b);
    }
}
