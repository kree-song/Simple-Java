package com.xsq.juc.Thread.test;

public class Count {
    //共享变量num
    public int num = 0;

    public synchronized void add() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num += 1;
        System.out.println(Thread.currentThread().getName() + "---" + num);
    }
}
