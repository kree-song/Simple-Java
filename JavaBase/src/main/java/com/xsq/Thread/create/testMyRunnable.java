package com.xsq.Thread.create;

public class testMyRunnable {
    public static void main(String[] args) {
        //创建了一个参数的对象
        MyRunnable mr = new MyRunnable();
        //创建一个线程对象，并把参数传递给这个线程
        //在线程启动后，执行参数里面的run()
        Thread t1 = new Thread(mr, "first");
        //开启线程
        t1.start();

        MyRunnable mr2 = new MyRunnable();
        Thread t2 = new Thread(mr2, "second");
        t2.start();
        System.out.println(Thread.currentThread().getName() + "main线程");
    }
}
