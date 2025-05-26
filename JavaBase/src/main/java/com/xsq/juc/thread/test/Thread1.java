package com.xsq.juc.thread.test;

public class Thread1 extends Thread {
    private Count count;

    public Thread1(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        count.add();
    }
}
