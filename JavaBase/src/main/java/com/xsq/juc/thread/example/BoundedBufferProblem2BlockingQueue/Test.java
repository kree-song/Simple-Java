package com.xsq.juc.thread.example.BoundedBufferProblem2BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        Producter producter = new Producter(bq);
        Consumer consumer = new Consumer(bq);
        producter.start();
        consumer.start();

    }
}
