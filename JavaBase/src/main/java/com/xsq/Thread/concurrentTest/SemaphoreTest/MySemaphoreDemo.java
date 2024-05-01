package com.xsq.Thread.concurrentTest.SemaphoreTest;

public class MySemaphoreDemo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();

        for (int i = 0; i < 5; i++) {
            new Thread(mr).start();
        }
    }
}