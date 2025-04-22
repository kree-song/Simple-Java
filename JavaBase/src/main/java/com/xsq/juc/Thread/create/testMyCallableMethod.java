package com.xsq.juc.Thread.create;

import java.util.concurrent.FutureTask;

/*
 * 线程优先级：1-10 默认：5
 * */
public class testMyCallableMethod {
    public static void main(String[] args) {
        MyCallableMethod mc = new MyCallableMethod();
        FutureTask<String> ft = new FutureTask<>(mc);
        Thread t1 = new Thread(ft, "first");
        //t1.setName("zhangsan");
        t1.setPriority(1);
        //System.out.println(t1.getPriority());
        t1.start();

        MyCallableMethod mc2 = new MyCallableMethod();
        FutureTask<String> ft2 = new FutureTask<>(mc2);
        Thread t2 = new Thread(ft2, "second");
        //t2.setName("lisi");
        t2.setPriority(10);
        //System.out.println(t2.getPriority());
        t2.start();
    }
}
