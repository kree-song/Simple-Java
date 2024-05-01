package com.xsq.Thread.create;

public class MyThreadMethod extends Thread {
    public MyThreadMethod() {
    }

    public MyThreadMethod(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "@@@" + i);
        }
    }
}
