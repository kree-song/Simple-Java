package com.xsq.juc.Thread.create;

/*
 * 多线程实现方式一：继承Thread类
 *
 * run():封装线程执行的代码，若直接调用则相当于普通方法，此时并没有开启线程
 * start():启动线程；然后由JVM调用此线程的run()
 * */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + i);
        }
    }
}
