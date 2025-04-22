package com.xsq.juc.Thread.test;

public class Main {
    public static void main(String[] args) {
        //多线程使用同一个对象，不同线程改变同一对象的num
        Count count = new Count();
        for (int i = 0; i < 5; i++) {
            Thread1 thread1 = new Thread1(count);
            thread1.start();
        }
    }
}
