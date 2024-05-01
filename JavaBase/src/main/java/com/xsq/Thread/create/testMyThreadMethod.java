package com.xsq.Thread.create;

/*
 * 线程默认名字：Thread+编号
 * */
public class testMyThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        testName();

        System.out.println(Thread.currentThread().getName());

        System.out.println("睡觉前");
        Thread.sleep(3000);
        System.out.println("睡觉后");

    }

    private static void testName() {
        MyThreadMethod t1 = new MyThreadMethod("zhangsan");
        MyThreadMethod t2 = new MyThreadMethod("lisi");

        //t1.setName("zhangsan");
        //t2.setName("lisi");

        t1.start();
        t2.start();
    }
}
