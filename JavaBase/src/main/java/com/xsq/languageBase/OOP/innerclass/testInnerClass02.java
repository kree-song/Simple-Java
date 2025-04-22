package com.xsq.languageBase.OOP.innerclass;

interface Inner {
    void show();
}

interface Inner02 {
    void show01();

    void show02();
}

/*
 * 匿名内部类
 * 概述：匿名内部类本质是一个特殊的局部内部类(定义在方法内部)
 * 前提：需要存在一个接口或类
 * 理解：将继承/实现、方法重写、创建对象，放在了一步进行
 * */
public class testInnerClass02 {
    public static void main(String[] args) {
        InnerImpl ii = new InnerImpl();
        ii.show();

        System.out.println("--------------------------------");

        //匿名内部类的理解：将继承/实现、方法重写、创建对象，放在了一步进行
        new Inner() {//解释：实现了Inner接口的，一个实现类对象
            @Override
            public void show() {
                System.out.println("匿名内部类中的show方法");
            }
        }.show();

        Inner02 i = new Inner02() {//接口中存在多个方法
            @Override
            public void show01() {
                System.out.println("show01...");
            }

            @Override
            public void show02() {
                System.out.println("show02...");
            }
        };
        i.show01();
        i.show02();
    }
}

class InnerImpl implements Inner {

    @Override
    public void show() {
        System.out.println("InnerImpl 重写的show方法");
    }
}