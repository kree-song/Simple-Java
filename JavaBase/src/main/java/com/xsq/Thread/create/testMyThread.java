package com.xsq.Thread.create;

public class testMyThread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        //MyThread t2=new MyThread();
        MyThreadMethod t2 = new MyThreadMethod();
        t1.setName("first");
        t2.setName("second");

        t1.setDaemon(true);
        t2.setDaemon(false);
        t1.start();
        t2.start();
    }
}
