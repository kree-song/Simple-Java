package com.xsq.juc.thread.example.BoundedBufferProblem2Object;


public class Test {
    public static void main(String[] args) {
        Producter producter = new Producter();
        Consumer consumer = new Consumer();
        producter.start();
        consumer.start();
    }

}
