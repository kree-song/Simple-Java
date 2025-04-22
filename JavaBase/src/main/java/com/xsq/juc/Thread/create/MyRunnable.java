package com.xsq.juc.Thread.create;

/*
 * 多线程实现方式二：实现Runnable接口
 * */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "第二种方式实现多线程" + i);
        }
    }
}
